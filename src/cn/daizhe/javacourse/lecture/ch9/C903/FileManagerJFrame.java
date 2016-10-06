package cn.daizhe.javacourse.lecture.ch9.C903;

import java.io.*;
import java.awt.event.*;
import javax.swing.*;

public class FileManagerJFrame extends JFrame implements ActionListener// ,
																		// FilenameFilter
{
	private File dir; // 文件对象，表示指定目录
	private File[] files; // 保存指定目录中所有文件
	private JTextField text_dir; // 地址栏，显示目录路径
	private JList list_files; // 列表框，显示指定目录中所有文件和子目录

	public FileManagerJFrame() {
		super("文件管理器");
		this.setSize(400, 300);
		this.setLocation(200, 140);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.dir = new File(".", ""); // 创建表示当前目录的文件对象
		this.text_dir = new JTextField(this.dir.getAbsolutePath()); // 显示目录路径
		this.add(this.text_dir, "North");
		this.text_dir.addActionListener(this);

		this.files = this.dir.listFiles(); // 返回指定目录中所有文件对象
		String[] filenames = this.dir.list(); // 返回指定目录中所有文件名字符串
		this.list_files = new JList(filenames); // 所有文件名字符串显示在列表框中
		this.add(this.list_files);
		this.addMenu(); // 调用自定义方法，添加菜单

		this.setVisible(true);
	}

	private void addMenu() // 添加主菜单
	{
		JMenuBar menubar = new JMenuBar(); // 菜单栏
		this.setJMenuBar(menubar); // 框架上添加菜单栏

		JMenu menu_file = new JMenu("文件"); // 菜单
		menubar.add(menu_file); // 菜单栏中加入菜单
		JMenuItem menuitem_open = new JMenuItem("打开"); // 创建菜单项
		menu_file.add(menuitem_open); // 菜单项加入到菜单
		menuitem_open.addActionListener(this); // 为菜单项注册单击事件监听器

		JMenuItem menuitem_sendto = new JMenuItem("复制到C:\\备份");
		menu_file.add(menuitem_sendto);
		menuitem_sendto.addActionListener(this);

		JMenuItem menuitem_delete = new JMenuItem("删除");
		menu_file.add(menuitem_delete);
		menuitem_delete.addActionListener(this);
	}

	public static void copyFile(File file, File file2) // 复制文件，适用于任意类型文件
	{ // 将file文件内容复制file文件中，重写方式
		try {
			FileInputStream fin = new FileInputStream(file); // 创建文件输入流对象
			FileOutputStream fout = new FileOutputStream(file2); // 创建文件输出流对象
			byte[] buffer = new byte[512]; // 字节缓冲区
			int count = 0;
			do {
				count = fin.read(buffer); // 读取输入流
				if (count != -1)
					fout.write(buffer); // 写入输出流
			} while (count != -1);
			fin.close(); // 关闭输入流
			fout.close(); // 关闭输出流

			file2.setLastModified(file.lastModified()); // 将新文件的最后修改时间设置为原文件的最后修改时间
		} catch (IOException ioex) {
			System.out.println("复制 " + file.getName() + " 文件未成功。");
			return;
		}
	}

	/*
	 * public boolean accept(File dir, String filename) { filename =
	 * filename.toLowerCase(); return (filename.startsWith(this.prefix)) &
	 * (filename.endsWith(this.extend)); }
	 */
	public void actionPerformed(ActionEvent e) // 单击事件处理程序
	{
		if (e.getSource() == this.text_dir) // 单击文本行时
		{
			this.dir = new File(this.text_dir.getText());
			this.files = this.dir.listFiles();
			String[] filenames = this.dir.list();
			this.list_files.setListData(filenames); // 重新设置列表框中的数据项
		}

		if (e.getActionCommand() == "打开") // 单击菜单项时
		{
			int i = this.list_files.getSelectedIndex(); // 返回列表框第1个选中数据项的序号，从0开始；没有选中时返回-1
			if (i != -1)
				if (this.files[i].isFile()) {
					String fname = (String) this.list_files.getSelectedValue(); // 返回列表框第1个选中数据项的值；没有选中时返回null
					int j = fname.indexOf('.');
					if (j > 0) {
						String extend = fname.substring(j + 1); // 获得.之后的扩展名字符串
						if (extend.equals("txt") || extend.equals("java"))
							new TextFileEditorJFrame(this.files[i]); // 打开文本文件编辑器
						else
							System.out.println("运行错误：不能打开这种类型文件。");
					}
				} else {
					this.dir = this.files[i];
					this.files = this.dir.listFiles();
					String[] filenames = this.dir.list();
					this.list_files.setListData(filenames);
				}
		}

		if (e.getActionCommand() == "复制到C:\\备份") {
			int i = this.list_files.getSelectedIndex();
			if (i != -1 && this.files[i].isFile()) // 仅复制文件，不复制目录
			{
				File dir_copyto = new File("C:\\备份", ""); // 指定复制到的目录
				if (!dir_copyto.exists()) // 目录不存在时
				{
					dir_copyto.mkdir(); // 创建目录
					File f2 = new File(dir_copyto, this.files[i].getName());
					this.copyFile(this.files[i], f2); // 复制文件
				} else // 目录存在时
				{
					File f2 = new File(dir_copyto, this.files[i].getName());
					if (!f2.exists()) // 文件不存在时
						this.copyFile(this.files[i], f2);
					else // 文件存在时
					if (this.files[i].lastModified() > f2.lastModified())
						this.copyFile(this.files[i], f2); // 待复制文件日期较新时复制
				}
			}
		}

		if (e.getActionCommand() == "删除") {
			int i = this.list_files.getSelectedIndex();
			if (i != -1) {
				this.files[i].delete(); // 删除文件
				String[] filenames = this.dir.list();
				this.list_files.setListData(filenames);
			}
		}
	}

	public static void main(String arg[]) {
		new FileManagerJFrame();
	}
}