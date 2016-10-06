package cn.daizhe.javacourse.lecture.ch6.C604;

//Graphics实例
import java.util.*;
import java.awt.*;
import java.awt.event.*;

class MyLine {
	private int x1, y1, x2, y2;

	public MyLine(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public void drawMe(Graphics g) {
		g.drawLine(x1, y1, x2, y2);
	}
}

public class DrawAllLine extends Frame {
	Vector v = new Vector();

	public static void main(String args[]) {
		DrawAllLine dal = new DrawAllLine();
		dal.init();
	}

	public void init() {
		setSize(900, 500);
		setVisible(true);
		addMouseListener(new MouseAdapter() {
			int orgX, orgY;

			public void mousePressed(MouseEvent e) {
				orgX = e.getX();
				orgY = e.getY();
			}

			public void mouseReleased(MouseEvent e) {
				Graphics g = e.getComponent().getGraphics();
				g.setColor(Color.red);
				g.drawLine(orgX, orgY, e.getX(), e.getY());
				v.add(new MyLine(orgX, orgY, e.getX(), e.getY()));
			}
		});
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				((Window) e.getSource()).dispose();
				System.exit(0);
			}
		});

	}

	public void paint(Graphics g) {
		g.setColor(Color.red);
		Enumeration e = v.elements();
		while (e.hasMoreElements()) {
			MyLine ln = (MyLine) e.nextElement();
			ln.drawMe(g);
		}
	}
}