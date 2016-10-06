package cn.daizhe.javacourse.lecture.ch8.C801;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class AppletPara extends Applet {
	private String text;
	private int size, color;

	public void init() {
		this.text = this.getParameter("text"); // 获得文本参数
		String str=this.getParameter("size");
		this.size = Integer.parseInt(this.getParameter("size")); // 获得字体大小
		this.color = Integer.parseInt(this.getParameter("color"), 16);// 获得颜色的十六进制�?
	}

	public void paint(Graphics g) {
		g.setColor(new Color(this.color));
		g.setFont(new Font("", 1, this.size));
		g.drawString(this.text, 10, 50); // 显示指定大小颜色的字符串
	}
}