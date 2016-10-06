package cn.daizhe.javacourse.lecture.ch6.C602;

//鼠标事件
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventTest extends Applet implements ActionListener,
		MouseMotionListener {
	int x = -1, y = -1, 橡皮擦通知 = 0, 清除通知 = 0;
	Color c = new Color(255, 0, 0);
	int con = 3;
	Button b_red, b_blue, b_green, b_clear, b_quit;

	// 初始化方法
	public void init() {
		// 为当前对象注册鼠标事件监视器
		// 当前对象是Applet对象
		this.addMouseMotionListener(this);
		// 创建按钮
		b_red = new Button("red");
		b_blue = new Button("blue");
		b_green = new Button("green");
		b_clear = new Button("clear");
		b_quit = new Button("quit");
		// 添加按钮
		add(b_red);
		add(b_blue);
		add(b_green);
		add(b_clear);
		add(b_quit);
		// 为所有按钮添加监视器
		// 由于当前类实现了ActionListener
		b_red.addActionListener(this);
		b_blue.addActionListener(this);
		b_green.addActionListener(this);
		b_clear.addActionListener(this);
		b_quit.addActionListener(this);
	}

	// 绘图方法
	public void paint(Graphics g) {
		if (x != 1 && y != -1 && 橡皮擦通知 == 0 && 清除通知 == 0) {
			g.setColor(c);
			// 划线
			g.fillOval(x, y, con, con);
		} else if (橡皮擦通知 == 1 && 清除通知 == 0) {
			// 擦除
			g.clearRect(x, y, con + 2, con + 2);
		} else if (橡皮擦通知 == 0 && 清除通知 == 1) {
			// 清除全部
			g.clearRect(0, 0, getSize().width, getSize().height);
		}
	}

	// 鼠标脱拽事件处理器
	public void mouseDragged(MouseEvent e) {
		// 取得事件发生坐标
		x = (int) e.getX();
		y = (int) e.getY();
		// 重画
		repaint();
	}

	// 鼠标移动事件处理器在MouseMotionListener接口中声明，必须实现
	public void mouseMoved(MouseEvent e) {
	}

	// Applet中的方法
	public void update(Graphics g) {
		paint(g);
	}

	// Action事件处理器
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b_red) {
			橡皮擦通知 = 0;
			清除通知 = 0;
			c = new Color(255, 0, 0);
		}
		if (e.getSource() == b_blue) {
			橡皮擦通知 = 0;
			清除通知 = 0;
			c = new Color(0, 0, 255);
		}
		if (e.getSource() == b_green) {
			橡皮擦通知 = 0;
			清除通知 = 0;
			c = new Color(0, 255, 0);
		}
		if (e.getSource() == b_quit) {
			橡皮擦通知 = 0;
			清除通知 = 1;
			repaint();
		}
		if (e.getSource() == b_clear) {
			橡皮擦通知 = 1;
			清除通知 = 0;
		}
	}
}
