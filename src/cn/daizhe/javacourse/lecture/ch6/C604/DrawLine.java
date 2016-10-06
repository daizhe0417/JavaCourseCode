package cn.daizhe.javacourse.lecture.ch6.C604;

//Graphics实例
import java.awt.*;
import java.awt.event.*;

public class DrawLine {
	Frame f = new Frame("画线程序");

	public static void main(String args[]) {
		new DrawLine().init();
	}

	public void init() {
		f.setSize(900, 500);
		f.setVisible(true);
		f.addMouseListener(new MouseAdapter() {
			int orgX;
			int orgY;

			public void mousePressed(MouseEvent e) {
				orgX = e.getX();
				orgY = e.getY();
			}

			public void mouseReleased(MouseEvent e) {
				// f.getGraphics().setColor(Color.red);
				// f.getGraphics().drawLine(orgX,orgY,e.getX(),e.getY());
				Graphics g = f.getGraphics();
				g.setColor(Color.red);
				g.setFont(new Font("隶书", Font.ITALIC | Font.BOLD, 30));
				g.drawString(new String(orgX + "," + orgY), orgX, orgY);
				g.drawString(new String(e.getX() + "," + e.getY()), e.getX(),
						e.getY());
				g.drawLine(orgX, orgY, e.getX(), e.getY());
			}
		});
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}