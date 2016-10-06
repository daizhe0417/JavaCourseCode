package cn.daizhe.javacourse.lecture.ch6.C602;

/**
 * �¼�����
 * @author venice
 * @version 2012-05-03
 */
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

//ActionEventTest��ʵ����ActionListener�ӿڣ��������Ϊ������
public class ActionEventTest1 extends Applet implements ActionListener {
	TextField text1, text2, text3;

	// applet�Ĺ涨����init��ʼ��
	public void init() {
		text1 = new TextField(10);
		text2 = new TextField(10);
		text3 = new TextField(10);
		this.add(text1);
		add(text2);
		add(text3);
		text1.addActionListener(this);// Ϊ�¼�Դ�ı���text1ע�������
		text2.addActionListener(this);// Ϊ�¼�Դ�ı���text2ע�������
	}

	// ʵ��ActionListener�ӿڵķ��������¼�������
	public void actionPerformed(ActionEvent e)// e���¼�����
	{
		if (e.getSource() == text1)// getSource()����ȡ���¼�Դ
		{
			String str = text1.getText();
			if (str.equals("boy")) {
				text3.setText("男");
			} else if (str.equals("girl")) {
				text3.setText("女");
			} else {
				text3.setText("其他");
			}
		} else if (e.getSource() == text2) {
			String str = text2.getText();
			if (str.equals("男")) {
				text3.setText("boy");
			} else if (str.equals("女")) {
				text3.setText("girl");
			} else {
				text3.setText("其他");
			}
		}
	}
}