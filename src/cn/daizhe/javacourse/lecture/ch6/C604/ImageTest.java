package cn.daizhe.javacourse.lecture.ch6.C604;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ImageTest extends Frame {
	Image img = null;

	public static void main(String args[]) {
		ImageTest f = new ImageTest("图像操作");
		f.init();
	}

	public ImageTest(String s) {
		super(s);
	}

	public void init() {
		img = this.getToolkit().getImage("java.jpg");
		setSize(500, 300);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void paint(Graphics g) {
		this.getGraphics().drawImage(img, 0, 0, this);
	}
}
