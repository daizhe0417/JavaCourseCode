package cn.daizhe.javacourse.lecture.ch6.C604;

import java.awt.*;
import java.awt.event.*;

class ImageCanvas extends Canvas {
	Image img = null;

	ImageCanvas() {
		setSize(200, 200);
		img = this.getToolkit().getImage("java.jpg");
	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
}

public class ImageTest2 extends Frame {
	public static void main(String args[]) {
		ImageTest2 f = new ImageTest2("图像操作");
	}

	public ImageTest2(String s) {
		super(s);
		add(new ImageCanvas());
		setSize(300, 500);
		setVisible(true);
		pack();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
