package cn.daizhe.javacourse.lecture.ch6.C603;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class EditorJFrame extends JFrame implements ActionListener,
		MouseListener {
	private JComboBox combox_name, combox_size;// 字体、字号组合框
	private JCheckBox checkb_bold, checkb_italic;// 粗体、斜体复选框
	private JRadioButton radiob_color[];// 颜色单选按钮
	// private JTextField text_size; // 字号文本行
	// private JCheckBox checkbox_bold, checkbox_italic; // 粗体、斜体复选框
	private JButton button_cut, button_copy, button_paste; // 剪切、复制、粘贴按钮
	private JTextArea textarea; // 文本区
	private Color color;

	private JPopupMenu popupmenu; // 快捷菜单
	private JDialog dialog; // 出错提示对话框
	private JLabel label_dialog; // 对话框中的标签

	public EditorJFrame() {
		super("文本编辑器"); // 默认BorderLayout布局

		Dimension dim = this.getToolkit().getScreenSize();
		this.setBounds(dim.width / 4, dim.height / 4, dim.width / 2,
				dim.height / 2);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setSize(500, 300);
		this.setLocation(300, 240);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 单击窗口关闭按钮时，结束程序运行

		textarea = new JTextArea("Welcom!");
		textarea.addMouseListener(this); // 为文本区注册鼠标事件监听器
		this.getContentPane().add(new JScrollPane(textarea)); // 文本区添加到框架的中部

		JToolBar toolbar = new JToolBar();
		this.getContentPane().add(toolbar, "North");

		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		String[] fontsName = ge.getAvailableFontFamilyNames();
		combox_name = new JComboBox(fontsName);
		combox_name.addActionListener(this);
		toolbar.add(combox_name);

		String[] sizestr = { "20", "30", "40", "50", "60", "70" };
		combox_size = new JComboBox(sizestr);
		combox_size.setEditable(true);
		combox_size.addActionListener(this);
		toolbar.add(combox_size);

		checkb_bold = new JCheckBox("粗体"); // 复选框
		toolbar.add(checkb_bold);
		checkb_bold.addActionListener(this); // 注册复选框的选择事件监听器

		checkb_italic = new JCheckBox("斜体");
		toolbar.add(checkb_italic);
		checkb_italic.addActionListener(this);

		String[] colorStr = { "红", "绿", "蓝" };
		ButtonGroup bgroup_color = new ButtonGroup();
		radiob_color = new JRadioButton[colorStr.length];
		for (int i = 0; i < radiob_color.length; i++) {
			radiob_color[i] = new JRadioButton(colorStr[i]);
			radiob_color[i].addActionListener(this);
			bgroup_color.add(radiob_color[i]);
			toolbar.add(radiob_color[i]);
		}
		radiob_color[0].setSelected(true);

		this.addmyMenu(); // 调用自定义方法，添加菜单
		this.setVisible(true);
	}

	private void addmyMenu(){ // 添加主菜单、快捷菜单、对话框
	
		JMenuBar menubar = new JMenuBar(); // 菜单栏
		this.setJMenuBar(menubar); // 框架上添加菜单栏

		JMenu menu_file = new JMenu("文件"); // 菜单
		menubar.add(menu_file); // 菜单栏中加入菜单
//		menu_file.add(new JMenuItem("打开")); // 生成菜单项并加入到菜单
		JMenuItem menuitem_open = new JMenuItem("打开");
		menu_file.add(menuitem_open);
		menuitem_open.addActionListener(this);
		
		menu_file.add(new JMenuItem("保存"));

		menu_file.addSeparator(); // 加分隔线

		JMenuItem menuitem_exit = new JMenuItem("退出");
		menu_file.add(menuitem_exit);
		menuitem_exit.addActionListener(this); // 为菜单项注册单击事件监听器

		JMenu menu_edit = new JMenu("编辑");
		menubar.add(menu_edit);

		JMenu menu_style = new JMenu("字形");
		menu_style.add(new JCheckBoxMenuItem("粗体")); // 复选菜单项
		menu_style.add(new JCheckBoxMenuItem("斜体"));
		menu_edit.add(menu_style); // 菜单加入到菜单中成为二级菜单

		JMenu menu_color = new JMenu("颜色");
		menu_edit.add(menu_color);

		ButtonGroup buttongroup = new ButtonGroup(); // 按钮组
		JRadioButtonMenuItem rbmi_red = new JRadioButtonMenuItem("红", true); // 单选菜单项
		buttongroup.add(rbmi_red); // 单选菜单项添加到按钮组
		menu_color.add(rbmi_red); // 单选菜单项添加到菜单

		JRadioButtonMenuItem rbmi_green = new JRadioButtonMenuItem("绿", true);
		buttongroup.add(rbmi_green);
		menu_color.add(rbmi_green);

		JRadioButtonMenuItem rbmi_blue = new JRadioButtonMenuItem("蓝", true);
		buttongroup.add(rbmi_blue);
		menu_color.add(rbmi_blue);

		menubar.add(new JMenu("帮助"));

		popupmenu = new JPopupMenu(); // 弹出式菜单对象
		JMenuItem menuitem_cut = new JMenuItem("剪切");
		menuitem_cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				InputEvent.CTRL_MASK));// 设置快捷键Ctrl+X
		popupmenu.add(menuitem_cut); // 加入剪切菜单项
		menuitem_cut.addActionListener(this);

		JMenuItem menuitem_copy = new JMenuItem("复制");
		menuitem_copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				InputEvent.CTRL_MASK));// 设置快捷键Ctrl+C
		popupmenu.add(menuitem_copy);
		menuitem_copy.addActionListener(this);

		JMenuItem menuitem_paste = new JMenuItem("粘贴");
		menuitem_paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				InputEvent.CTRL_MASK));// 设置快捷键Ctrl+V
		popupmenu.add(menuitem_paste);
		menuitem_paste.addActionListener(this);

		textarea.add(popupmenu); // 文本区添加快捷菜单

		dialog = new JDialog(this, "提示");
		dialog.setSize(240, 80);
		label_dialog = new JLabel("", JLabel.CENTER);
		dialog.add(label_dialog);
		dialog.setDefaultCloseOperation(HIDE_ON_CLOSE); // 单击对话框的关闭按钮时，隐藏对话框而不结束程序运行
	}

	public void actionPerformed(ActionEvent e) { // 单击事件处理程序

		if (e.getSource() instanceof JRadioButton) {
			if (e.getSource() == radiob_color[0]) {
				color = new Color(255, 0, 0);
			}
			if (e.getSource() == radiob_color[1]) {
				color = new Color(0, 255, 0);
			}
			if (e.getSource() == radiob_color[2]) {
				color = new Color(0, 0, 255);
			}
			textarea.setForeground(color);
			return;
		}

		if (e.getSource() instanceof JMenuItem) {

			if (e.getActionCommand() == "退出") { // 不能用switch(int)语句
				if (JOptionPane.showConfirmDialog(this, "终止当前程序运行？") == 0) {
					System.exit(0); // 单击菜单项时结束程序
				}
			}
			if(e.getActionCommand() == "打开") {
			}
			if (e.getActionCommand() == "剪切") {
				textarea.cut(); // 将选中文本剪切送系统剪贴板
			}
			if (e.getActionCommand() == "复制") {
				textarea.copy();
			}
			if (e.getActionCommand() == "粘贴") {
				textarea.paste();
			}
		}

		if (e.getSource() instanceof JComboBox
				|| e.getSource() instanceof JCheckBox) {

			int size = 0;
			try {
				String fontNameStr = (String) combox_name.getSelectedItem();
				size = Integer.parseInt((String) combox_size.getSelectedItem());
				if (size <= 0 || size > 72)
					throw new Exception("SizeException"); // 抛出异常对象
				Font font = textarea.getFont();
				int style = font.getStyle();
				if (e.getSource() == checkb_bold) {
					style = style ^ 1; // 整数的位运算，异或^
				}
				if (e.getSource() == checkb_italic) {
					style = style ^ 2;
				}
				textarea.setFont(new Font(font.getName(), style, size));
			} catch (NumberFormatException nfe) {
				label_dialog.setText("\"" + combox_size.getSelectedItem()
						+ "\" 不能转换成整数，请重新输入!");
				dialog.setLocation(this.getX() + 100, this.getY() + 100);
				dialog.setVisible(true);
			} catch (Exception ex) {
				if (ex.getMessage() == "SizeException") // 捕获自己抛出的异常对象
				{
					JOptionPane.showMessageDialog(this, " 字号不合适，请重新输入!");
				}
			} finally {
			}
		}

		if (e.getSource() == combox_size) {
			String sizeStr = (String) combox_size.getSelectedItem();
			for (int i = 0, n = combox_size.getItemCount(); i < n; i++) {
				if (sizeStr.compareTo((String) combox_size.getItemAt(i)) == 0) {
					return;
				} else if (sizeStr.compareTo((String) combox_size.getItemAt(i)) > 0) {
					combox_size.insertItemAt(sizeStr, i);
				}
			}
		}
	}

	public void mouseClicked(MouseEvent mec) { // 单击鼠标时触发
		// 实现MouseListener接口中的方法
		if (mec.getModifiers() == mec.BUTTON3_MASK) // 单击的是鼠标右键
			popupmenu.show(textarea, mec.getX(), mec.getY());// 在鼠标单击处显示快捷菜单
	}

	public void mousePressed(MouseEvent mep) {
	}

	public void mouseReleased(MouseEvent mer) {
	}

	public void mouseEntered(MouseEvent mee) {
	}

	public void mouseExited(MouseEvent mex) {
	}

	public void mouseDragged(MouseEvent med) {
	}

	public static void main(String arg[]) {
		new EditorJFrame();
	}
}

/*
 * 
 * 程序设计说明如下。 1、JFrame类和JDialog类都有下列方法
 * dialog.setDefaultCloseOperation(HIDE_ON_CLOSE); //单击对话框的关闭按钮时，隐藏对话框而不结束程序运行
 * 因此，不需要再写实现WindowListener接口中的windowClosing(WindowEvent e)方法。
 * 
 * 2、主菜单的编辑菜单中可以增加下列菜单项：
 * 
 * JMenuItem menuitem_cut = new JMenuItem("剪切");
 * menuitem_cut.setAccelerator(KeyStroke
 * .getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));//设置快捷方式Ctrl+X
 * menu_edit.add(menuitem_cut); menuitem_cut.addActionListener(this);
 * 
 * JMenuItem menuitem_copy = new JMenuItem("复制");
 * menuitem_copy.setAccelerator(KeyStroke
 * .getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));//设置快捷方式Ctrl+C
 * menu_edit.add(menuitem_copy); menuitem_copy.addActionListener(this);
 * 
 * JMenuItem menuitem_paste = new JMenuItem("粘贴");
 * menuitem_paste.setAccelerator(
 * KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));//设置快捷方式Ctrl+V
 * menu_edit.add(menuitem_paste); menuitem_paste.addActionListener(this);
 * menu_edit.addSeparator();
 * 问题是，一个菜单项只能添加一次，引用类型，想一个菜单项即添加在主菜单上，也添加在弹出式菜单上，没有成功。
 * 
 * 3、复选菜单项也可响应选择事件，如果
 * 
 * JMenu menu_style = new JMenu("字形"); cbmi_bold = new JCheckBoxMenuItem("粗体");
 * //复选菜单项 menu_style.add(cbmi_bold); cbmi_bold.addItemListener(this);
 * //复选菜单项注册选择事件监听器
 * 
 * cbmi_italic = new JCheckBoxMenuItem("斜体"); menu_style.add(cbmi_italic);
 * cbmi_italic.addItemListener(this); menu_edit.add(menu_style);
 * //菜单加入到菜单中成为二级菜单 则 public void itemStateChanged(ItemEvent e) //复选框选择事件处理程序 {
 * //实现ItemListener接口中的方法 Font font = textarea.getFont(); int style =
 * font.getStyle(); if (e.getSource()==checkbox_bold ||
 * e.getSource()==cbmi_bold) { style = style ^ 1; //整数的位运算，异或^ }
 * 
 * if (e.getSource()==checkbox_italic|| e.getSource()==cbmi_italic) style =
 * style ^ 2; textarea.setFont(new Font(font.getName(),style,font.getSize())); }
 * 上述方法中还应该维护复选菜单项的状态，下述方法好像没有成功，没有时间了。 if (e.getSource()==checkbox_bold ||
 * e.getSource()==cbmi_bold) { style = style ^ 1; //整数的位运算，异或^
 * checkbox_bold.setSelected(checkbox_bold.isSelected());
 * cbmi_bold.setState(cbmi_bold.getState()); }
 * 
 * 
 * 4、改变文本的颜色，菜单颜色弹出对话框，对话框中嵌入选择颜色组件JColorChoose，对话框返回时带回颜色值。 JMenuItem
 * menuitem_color = new JMenuItem("颜色..."); menu_edit.add(menuitem_color);
 * menuitem_color.addActionListener(this);
 * 
 * 
 * 5、字号文本行可以改为组合框，当单击时，组合框中新输入的字号将添加到其下拉列表中。先要查找，不添加重复值。
 * 
 * 6、组件都可以添加菜单栏 dialog.add(menubar); //对话框添加菜单栏
 * 
 * textarea.add(menubar); //文本区添加菜单栏
 */