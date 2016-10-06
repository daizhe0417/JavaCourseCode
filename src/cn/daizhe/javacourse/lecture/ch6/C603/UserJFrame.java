package cn.daizhe.javacourse.lecture.ch6.C603;

import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

/*
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 */

public class UserJFrame extends JFrame implements ActionListener, ItemListener {
	private int number = 1; // 编号

	private JTextField text_number, text_name; // 编号、姓名文本行
	private JRadioButton radiobutton_male, radiobutton_female; // 性别按钮
	private JComboBox combobox_province, combobox_city; // 省份、城市组合框
	private JButton button_add; // 添加按钮
	private JTextArea text_user; // 文本区

	public UserJFrame() {
		super("输入用户信息");

		this.setSize(360, 200);
		this.setLocation(300, 240);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 单击窗口关闭按钮时，结束程序运行
		this.setLayout(new GridLayout(1, 2)); // 网格布局，1行2列，左右分隔窗口

		text_user = new JTextArea(); // 创建文本区
		this.add(text_user); // 占据窗口左半部分

		JPanel panel = new JPanel(new GridLayout(6, 1)); // 面板网格布局，6行1列
		this.add(panel); // 占据窗口右半部分

		text_number = new JTextField("1"); // 编号文本行
		text_number.setEditable(false); // 不可编辑，编号自动生成
		panel.add(text_number);

		text_name = new JTextField("姓名");
		panel.add(text_name);

		JPanel panel_radiobutton = new JPanel(new GridLayout(1, 2)); // 单选按钮子面板，网格布局，1行2列
		panel.add(panel_radiobutton);

		ButtonGroup buttongroup = new ButtonGroup(); // 按钮组
		radiobutton_male = new JRadioButton("男", true); // 创建单选按钮
		buttongroup.add(radiobutton_male); // 单选按钮添加到按钮组
		panel_radiobutton.add(radiobutton_male); // 单选按钮添加到子面板

		radiobutton_female = new JRadioButton("女");
		buttongroup.add(radiobutton_female);
		panel_radiobutton.add(radiobutton_female);

		Object province[] = { "江苏省", "浙江省" };
		combobox_province = new JComboBox(province); // 省份组合框
		// combobox_province.setEditable(true); //设置可编辑，默认不可编辑
		combobox_province.addItemListener(this); // 注册组合框的选择事件监听器
		panel.add(combobox_province);

		Object city[] = { "南京市", "苏州市", "无锡市" };
		combobox_city = new JComboBox(city); // 城市组合框
		panel.add(combobox_city);

		button_add = new JButton("添加");
		button_add.addActionListener(this);
		panel.add(button_add);

		this.setVisible(true);
	}

	public void itemStateChanged(ItemEvent e) // 在组合框的下拉列表中选择数据项时触发执行
	{ // 实现ItemListener接口中的方法
		if (combobox_province.getSelectedIndex() == 0) // 在省份组合框中选择了"江苏省"
		{
			combobox_city.removeAllItems(); // 清除地区组合框中原所有内容
			combobox_city.addItem("南京市"); // 地区组合框添加数据项
			combobox_city.addItem("苏州市");
			combobox_city.addItem("无锡市");
		}

		if (combobox_province.getSelectedIndex() == 1) // 选择了"浙江省"
		{
			combobox_city.removeAllItems();
			combobox_city.addItem("杭州市");
			combobox_city.addItem("宁波市");
			combobox_city.addItem("温州市");
		}
	}

	public void actionPerformed(ActionEvent e) // 单击按钮时触发执行
	{
		if (e.getSource() == button_add) {
			String aline = "";
			aline = number + ", " + text_name.getText();

			if (radiobutton_male.isSelected()) // 指定单选按钮选中时
				aline += ", " + radiobutton_male.getText(); // 获得单选按钮表示的性别字符串

			if (radiobutton_female.isSelected())
				aline += ", " + radiobutton_female.getText();

			aline += ", " + combobox_province.getSelectedItem(); // 获得组合框选中数据项的字符串
			aline += ", " + combobox_city.getSelectedItem();
			text_user.append(aline + "\n"); // 文本区添加一行字符串

			this.number++; // 编号自动加1
			text_number.setText("" + this.number);
			text_name.setText("姓名");
		}
	}

	public static void main(String arg[]) {
		new UserJFrame();
	}
}

/*
 * 程序程序设计说明如下。 1、JFrame类调用下列方法，当单击窗口关闭按钮时，将自动结束程序运行。
 * this.setDefaultCloseOperation(EXIT_ON_CLOSE); //单击窗口关闭按钮时，结束程序运行
 * 因此，不需要再写实现WindowListener接口中的windowClosing(WindowEvent e)方法。
 * 
 * 2、使用JComboBox代替AWT中的Choice组件，用法完全一样。
 * 
 * 
 * 1、JRadioButton使用问题
 * 与AWT中用CheckBox表示单选按钮，相同点是，都需要一个组Group，这样在一个逻辑组中的多个按钮之间可以实现单项选择。
 * 
 * 可以调用getText()方法获得指定单选按钮的文本。例如， aline += ", "+radiobutton_male.getText(); //行
 * 但是，不能判断单选按钮是否选中的状态，即不能像CheckBox调用getState()方法判断状态 if
 * (radiobutton_male.getState()) //不行
 * 所以，程序中只好声明了一个私有变量sex，当单击单选按钮时，自己记住单选按钮的文本。这算是一个笨办法。
 * 
 * 为什么？怎样判断单选按钮的状态？或者不需要判断状态了吗？ 解决,用AbstractButton类中的isSelected()方法。
 * 
 * 
 * 2、单选按钮可以注册单击事件监听器: radiobutton_male.addActionListener(this); //注册单选按钮的单击事件监听器
 * 实现方法如下。 public void actionPerformed(ActionEvent e) //单击按钮、单击单选按钮时触发执行 { if
 * (e.getSource() == radiobutton_male || e.getSource() == radiobutton_female)
 * sex = e.getActionCommand(); //获得单选按钮表示的性别字符串 }
 * 
 * 
 * 3、单选按钮可以注册选择事件监听器: radiobutton_male.addItemListener(this); //注册复选框的选择事件监听器
 * 
 * public void itemStateChanged(ItemEvent e) //在组合框的下拉列表中选择数据项时触发执行 {
 * //选择单选按钮时触发执行 if (e.getSource() == radiobutton_male || e.getSource() ==
 * radiobutton_female) //选择单选按钮时 sex = ((JRadioButton)e.getSource()).getText();
 * //获得单选按钮表示的性别字符串 }
 * 
 * 程序存在问题： 3、JList没有使用成功，不能像AWT中的List一样，调用add()方法增加一个数据项，只能创建对象时，给定一个死数据。
 * 以下语句可行。
 * 
 * String data[] = {"南京市","苏州市","无锡市"}; list_area = new JList(data); //地区列表框
 * panel.add(list_area);
 * 
 * public void itemStateChanged(ItemEvent e) { if
 * (combobox_province.getSelectedIndex()==0) //选择组合框中省份数据项时 { String data[] =
 * {"南京市","苏州市","无锡市"}; list_area = new JList(data); } if
 * (combobox_province.getSelectedIndex()==1) { String data[] =
 * {"杭州市","宁波市","温州市"}; list_area = new JList(data); } }
 * 
 * 但最终此例没有使用JList，因为布局问题。现采用网格布局，每个网格大小相等，所以，省份和地区使用了两个组合框。
 * 如果地区使用列表框，则仅占用一个网格不够，需要占用多个网格，此时，必须使用GridBagLayout布局，而该布局太复杂， 程序太长，两句话说不清。
 * GridBagLayout是最复杂的一种布局管理器，但给出了最灵活的排列控制组件的方式。它能在每个大小不同的矩形格子中精确地
 * 指定组件之间的关系，从而有效地布置组件。
 * 
 * 3、JTable也没有使用成功，只好采用JTextArea
 * 
 * 与JList类似，JTable也无法直接动态增加一行数据，如调用add()方法之类，只能在创建时以一个指定二维数组的值构造。 适用于贷款计算的例题。
 * 
 * 构造JList、JTable对象时，可以通过集合类对象，还没时间仔细研究。
 * 
 * table = new JTable(10,5); //创建表格，6行10列 this.add(table); //占据窗口左半部分
 */