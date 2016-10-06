package cn.daizhe.javacourse.lecture.ch6.C602;

//窗口、菜单的使用
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

//圆类，是面板类的子类，可以作为事件监听器
class Mcircle extends Panel implements ActionListener {
	double r, area;
	TextField tr = null, result = null;
	Button b = null;

	// 构造方法，创建并添加面板中的组件
	Mcircle() {
		tr = new TextField(10);
		result = new TextField(10);
		b = new Button("确定");
		add(new Label("输入半径"));
		add(tr);
		add(new Label("面积是："));
		add(result);
		add(b);
		// 为按钮注册事件监听器
		b.addActionListener(this);
	}

	// 事件处理器
	public void actionPerformed(ActionEvent e) {
		try// 第一句可能异常
		{
			r = Double.parseDouble(tr.getText());
			area = Math.PI * r * r;
			result.setText("" + area);
		} catch (Exception ee) {
			// tr.setText("请输入数字字符");
			// Swing组件中的消息对话框
			JOptionPane.showMessageDialog(this, "请输入数字字符", "消息对话框",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}

// 三角形类，面板类的子类，可作为事件监听器
class Mtrangle extends Panel implements ActionListener {
	double a = 0, b = 0, c = 0, area;
	TextField ta = new TextField(6), tb = new TextField(6), tc = new TextField(
			6), tr = new TextField(24);
	Button Button = new Button("确定");
	MyDialog dia;

	Mtrangle() {
		add(new Label("输入三边长度："));
		add(ta);
		add(tb);
		add(tc);
		add(new Label("面积是："));
		add(tr);
		add(Button);
		Button.addActionListener(this);
	}

	// 事件处理器
	public void actionPerformed(ActionEvent e) {
		try {
			a = Double.parseDouble(ta.getText());
			b = Double.parseDouble(tb.getText());
			c = Double.parseDouble(tc.getText());
			if (a + b > c && b + c > a && c + a > b) {
				double p = (a + b + c) / 2;
				area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
				tr.setText("" + area);
			} else {
				tr.setText("不能构成三角形");
			}
		} catch (Exception ee) {
			// tr.setText("请输入数字字符");
			JOptionPane.showConfirmDialog(this, "请输入数字字符", "确认对话框",
					JOptionPane.YES_NO_OPTION);
		}
	}
}

// 对话框类
class MyDialog extends Dialog implements ActionListener {
	Button yes;

	public MyDialog(Frame f, String s, boolean b) {
		super(f, s, b);
		if (b)
			yes = new Button("有模式对话框");
		else
			yes = new Button("无模式对话框");
		yes.addActionListener(this);
		add(yes);
		setBounds(250, 200, 200, 100);
		// 为对话框添加窗口事件监听器
		// 窗口适配器：匿名内部类
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == yes) {
			setVisible(false);
		}
	}
}

// 窗口类，window的子类，可作为事件监听器
class Win extends Frame implements ActionListener {
	MenuBar bar = null;
	Menu men = null, men2 = null;
	MenuItem item1, item2, item3, item4;
	Mcircle c;
	Mtrangle t;
	MyDialog dai;

	Win() {
		// 添加菜单
		bar = new MenuBar();
		men = new Menu("选择");
		item1 = new MenuItem("圆面积计算");
		item2 = new MenuItem("三角形面积计算");
		men2 = new Menu("对话框");
		item3 = new MenuItem("有模式");
		item4 = new MenuItem("无模式");
		men.add(item1);
		men.add(item2);
		men2.add(item3);
		men2.add(item4);
		bar.add(men);
		bar.add(men2);
		setMenuBar(bar);

		c = new Mcircle();
		t = new Mtrangle();
		// 为各菜单项添加事件监听器
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);

		setVisible(true);
		setBounds(100, 120, 100, 90);
	}

	// 事件处理器
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == item1) {
			removeAll();
			add(c, "Center");
			validate();// 调整大小
		} else if (e.getSource() == item2) {
			removeAll();
			add(t, "Center");
			validate();
		} else if (e.getSource() == item3) {
			dai = new MyDialog(this, "有模式", true);
			dai.setVisible(true);
		} else if (e.getSource() == item4) {
			dai = new MyDialog(this, "无模式", false);
			dai.setVisible(true);
		}
	}
}

public class Mwindow {
	public static void main(String args[]) {
		Win win = new Win();
		win.setBounds(100, 100, 500, 300);
		win.setVisible(true);
		// 添加窗口事件监听器
		// 以匿名内部类为参数，利用窗口事件适配器
		win.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
