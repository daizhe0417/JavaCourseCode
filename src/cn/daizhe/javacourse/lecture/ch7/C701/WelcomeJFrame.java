package cn.daizhe.javacourse.lecture.ch7.C701;

//【例7.3】  设计滚动字演示线程状态及改变方法。

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WelcomeJFrame extends JFrame {
	private JDialog dialog;
	private JLabel label_dialog;

	public WelcomeJFrame(String[] texts) // texts指定移动字符串
	{ // 数组元素个数决定窗口中的面板数
		super("滚动字");

		this.setSize(400, 300);
		this.setLocation(300, 240);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 单击窗口关闭按钮时，结束程序运行

		if (texts == null || texts.length == 0)
			this.add(new RollbyJPanel("Welcome!")); // 至少有一行字符串
		else {
			this.setLayout(new GridLayout(texts.length, 1));// 网格布局，1行若干列
			for (int i = 0; i < texts.length; i++)
				this.add(new RollbyJPanel(texts[i]));
		}
		this.setVisible(true);

		dialog = new JDialog(this, "提示", true); // 模式窗口
		dialog.setSize(240, 80);
		label_dialog = new JLabel("", JLabel.CENTER);
		dialog.add(label_dialog);
		dialog.setDefaultCloseOperation(HIDE_ON_CLOSE); // 单击对话框的关闭按钮时，隐藏对话框而不结束程序运行
	}

	public WelcomeJFrame() {
		this(null);
	}

	private class RollbyJPanel extends JPanel implements ActionListener,
			Runnable { // 自定义面板类，私有内部类，实现单击事件监听器接口和线程接口
		private JTextField text_word, text_sleep; // 滚动字文本行，线程睡眠时间文本行
		private JButton button_start, button_interrupt; // 启动按钮，中断按钮
		private JTextField text_state; // 线程状态文本行

		private Thread thread_rollby; // 线程对象
		private int sleeptime; // 线程睡眠时间

		private RollbyJPanel(String text) // 内部面板类构造方法
		{
			this.setLayout(new GridLayout(2, 1));

			for (int i = 0; i < 100; i++)
				// 为字符串添加空格
				text = text + " ";
			text_word = new JTextField(text);
			this.add(text_word);

			JPanel panel_sub = new JPanel(new FlowLayout(FlowLayout.LEFT));
			this.add(panel_sub);
			panel_sub.add(new JLabel("sleep"));

			this.sleeptime = (int) (Math.random() * 100);
			text_sleep = new JTextField("" + sleeptime, 5);
			panel_sub.add(text_sleep);
			text_sleep.addActionListener(this);

			button_start = new JButton("启动");
			panel_sub.add(button_start);
			button_start.addActionListener(this);

			button_interrupt = new JButton("中断");
			panel_sub.add(button_interrupt);
			button_interrupt.addActionListener(this);

			thread_rollby = new Thread(this); // 创建线程对象，目标对象是当前对象
			button_interrupt.setEnabled(false); // 设置中断按钮为无效状态

			panel_sub.add(new JLabel("state"));
			text_state = new JTextField("" + thread_rollby.getState(), 10);
			text_state.setEditable(false);
			panel_sub.add(text_state);
		}

		public void run() // 线程体，必须是公有方法
		{
			while (thread_rollby.isAlive() && !thread_rollby.isInterrupted()) { // 线程活动且没中断时
				try {
					String str = text_word.getText();
					str = str.substring(1) + str.substring(0, 1);
					text_word.setText(str);
					thread_rollby.sleep(sleeptime); // 线程睡眠，抛出异常
				} catch (InterruptedException e) {
					break; // 退出循环
				}
			}
		} // run()方法结束，线程对象终止

		public void actionPerformed(ActionEvent e) // 单击事件处理，必须是公有方法
		{
			if (e.getSource() == button_start) // 单击启动按钮时
			{
				thread_rollby = new Thread(this); // 重新创建一个线程对象
				thread_rollby.start();
				text_state.setText("" + thread_rollby.getState()); // 显示线程状态
				button_start.setEnabled(false);
				button_interrupt.setEnabled(true);
			}

			if (e.getSource() == button_interrupt) // 单击中断按钮时
			{
				thread_rollby.interrupt(); // 设置当前线程对象中断标记
				text_state.setText("" + thread_rollby.getState());
				button_start.setEnabled(true);
				button_interrupt.setEnabled(false);
			}

			if (e.getSource() == text_sleep) // 单击线程睡眠时间文本行时
			{
				try {
					sleeptime = Integer.parseInt(text_sleep.getText());
				} catch (NumberFormatException nfe) {
					label_dialog.setText("\"" + text_sleep.getText()
							+ "\" 不能转换成整数，请重新输入!");
					dialog.setLocation(this.getX() + 100, this.getY() + 100);
					dialog.setVisible(true);
				}
			}
		}
	}

	public static void main(String arg[]) {
		String[] texts = { "Welcome", "Hello", "Rollby" ,"dsfkdsf"};
		new WelcomeJFrame(texts);
	}
}

/*
 * new WelcomeJFrame(); 相当于 String[] texts={"Welcome"}; new
 * WelcomeJFrame(texts);
 */

