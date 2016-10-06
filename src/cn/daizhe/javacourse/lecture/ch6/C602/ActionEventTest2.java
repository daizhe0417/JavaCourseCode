package cn.daizhe.javacourse.lecture.ch6.C602;

//��ť���ı��򡢱�ǩ���÷����Լ��¼�����
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ActionEventTest2 extends Applet implements ActionListener {
	TextField text;
	Button bEnter, bClear;

	public void init() {
		text = new TextField("0", 10);
		add(text);
		bEnter = new Button("计算");
		bClear = new Button("清除");
		add(bEnter);
		add(bClear);
		bEnter.addActionListener(this);
		bClear.addActionListener(this);
		text.addActionListener(this);
	}

	public void paint(Graphics g) {
		g.drawString("是的发送到", 10, 100);
		g.drawString("是打发第三方", 10, 120);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bEnter || e.getSource() == text) {
			double n = 0;
			try {
				n = Double.valueOf(text.getText()).doubleValue();
				text.setText("" + Math.sqrt(n));
			} catch (NumberFormatException event) {
				text.setText("非法数字");
			}
		} else if (e.getSource() == bClear) {
			text.setText("0");
		}
	}
}