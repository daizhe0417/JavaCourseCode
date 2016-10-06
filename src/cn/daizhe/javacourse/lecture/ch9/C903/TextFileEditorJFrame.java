package cn.daizhe.javacourse.lecture.ch9.C903;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class TextFileEditorJFrame extends JFrame implements ActionListener// ,
																			// FilenameFilter
{
	private File file; // 当前文件
	private JTextArea textarea; // 文本区

	public TextFileEditorJFrame() // 空文件的构造方法
	{
		super("文本文件编辑器");
		this.setSize(400, 300);
		this.setLocation(360, 300);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);

		this.textarea = new JTextArea();
		this.add(textarea);
		this.addMenu(); // 调用自定义方法，添加菜单
		this.setVisible(true);

		this.file = null; // 空文件对象
	}

	public TextFileEditorJFrame(String filename) // 指定文件名的构造方法
	{
		this();
		if (filename != null) {
			this.file = new File(filename);
			this.setTitle(filename); // 将文件名添加在窗口标题栏上
			this.textarea.setText(this.readFromFile()); // 使用流读取指定文件中的字符串，并显示在文本区中
		}
	}

	public TextFileEditorJFrame(File file) // 指定文件对象的构造方法
	{
		this();
		if (file != null) {
			this.file = file;
			this.setTitle(this.file.getName());
			this.textarea.setText(this.readFromFile());
		}
	}

	private void addMenu() // 添加主菜单
	{
		JMenuBar menubar = new JMenuBar();
		this.setJMenuBar(menubar);

		JMenu menu_file = new JMenu("文件");
		menubar.add(menu_file);
		JMenuItem menuitem_open = new JMenuItem("打开");
		menu_file.add(menuitem_open);
		menuitem_open.addActionListener(this);

		JMenuItem menuitem_save = new JMenuItem("保存");
		menu_file.add(menuitem_save);
		menuitem_save.addActionListener(this);

		JMenuItem menuitem_saveas = new JMenuItem("另存为");
		menu_file.add(menuitem_saveas);
		menuitem_saveas.addActionListener(this);

		menubar.add(new JMenu("编辑"));
		menubar.add(new JMenu("帮助"));
	}

	public void writeToFile(String lines) // 使用字符流将指定字符串写入当前文本文件中
	{
		try {
			FileWriter fout = new FileWriter(this.file);
			fout.write(lines + "\r\n"); // 向文件字符输出流写入一个字符串
			fout.close();
		} catch (IOException ioex) {
			return;
		}
	}

	public String readFromFile() // 使用流从指定文本文件中读取字符串
	{
		try {
			FileReader fin = new FileReader(this.file);
			BufferedReader bin = new BufferedReader(fin);
			String aline = "", lines = "";
			do {
				aline = bin.readLine(); // 读取一行字符串，输入流结束时返回null
				if (aline != null)
					lines += aline + "\r\n";
			} while (aline != null);

			bin.close();
			fin.close();
			return lines;
		} catch (IOException ioex) {
			return null;
		}
	}

	public boolean openDialog() // 执行打开文件对话框
	{ // 在打开文件对话框中，单击【打开】按钮时返回true，单击【取消】按钮时返回false
		FileDialog filedialog = new FileDialog(this, "Open", FileDialog.LOAD); // 创建打开文件对话框
		// filedialog.setFilenameFilter(this); //new DirFilter("*.txt"));
		filedialog.setVisible(true); // 显示打开文件对话框
		if ((filedialog.getDirectory() != null)
				&& (filedialog.getFile() != null)) // 单击【打开】按钮时
		{
			this.file = new File(filedialog.getDirectory(),
					filedialog.getFile());
			return true;
		} else
			return false; // 单击【取消】按钮时
	}

	/*
	 * public boolean accept(File dir, String filename) { // String fname =
	 * filename.toLowerCase(); // return filename.startsWith("") &
	 * filename.endsWith(".txt"); return filename.endsWith(".txt"); }
	 */
	public boolean saveDialog() // 执行保存文件对话框
	{ // 在保存文件对话框中，单击【保存】按钮时返回true，单击【取消】按钮时返回false
		FileDialog filedialog = new FileDialog(this, "SaveAs", FileDialog.SAVE); // 创建保存文件对话框
		filedialog.setFile(this.file.getName()); // 设置保存文件对话框初始显示当前文件名
		filedialog.setVisible(true); // 显示保存文件对话框
		if ((filedialog.getDirectory() != null)
				&& (filedialog.getFile() != null)) // 单击【保存】按钮时
		{
			this.file = new File(filedialog.getDirectory(),
					filedialog.getFile() + ".txt");
			return true;
		} else
			return false; // 单击【取消】按钮时
	}

	public void actionPerformed(ActionEvent e) // 单击事件处理程序
	{
		if (e.getActionCommand() == "打开") // 单击菜单项时
		{
			if (this.openDialog()) // 打开文件对话框并单击【打开】按钮时执行，单击【取消】按钮时不执行
			{
				this.setTitle(this.file.getName());
				this.textarea.setText(this.readFromFile());
			}
		}

		if (e.getActionCommand() == "保存" && this.file != null)// 非第1次保存时，只保存不需要打开保存文件对话框
		{
			this.writeToFile(this.textarea.getText());
		}

		if (e.getActionCommand() == "保存" && this.file == null
				|| e.getActionCommand() == "另存为") { // 第1次保存或执行"另存为"菜单时，需要打开保存文件对话框
			if (this.saveDialog()) // 打开文件对话框并单击【保存】按钮时执行，单击【取消】按钮时不执行
			{
				this.writeToFile(this.textarea.getText());
				this.setTitle(this.file.getName());
			}
		}
	}

	public static void main(String arg[]) {
		new TextFileEditorJFrame("唐诗\\秋日赴阙题潼关驿楼.txt");
	}
}