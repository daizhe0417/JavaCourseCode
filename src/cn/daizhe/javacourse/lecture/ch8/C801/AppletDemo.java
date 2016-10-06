package cn.daizhe.javacourse.lecture.ch8.C801;

import java.awt.GridLayout;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AppletDemo extends JApplet {
	private static int i = 0, j = 0;

	public void init() {
		i++;
		getContentPane().setLayout(new GridLayout(3, 1));
		getContentPane().add(new JLabel("init():i=" + i));
	}

	public void start() {
		j++;
		getContentPane().add(new JTextField("start():j=" + j));
	}
}
