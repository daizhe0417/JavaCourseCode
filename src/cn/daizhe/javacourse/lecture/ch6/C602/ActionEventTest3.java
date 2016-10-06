package cn.daizhe.javacourse.lecture.ch6.C602;

//���������������¼�Դtext1�ֱ�ִ�в�ͬ�Ķ���
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ActionEventTest3 extends Applet implements ActionListener {
	TextField text1, text2, text3;
	Second s;

	public void init() {
		text1 = new TextField(10);
		text2 = new TextField(20);
		text3 = new TextField(20);
		s = new Second(this);
		add(text1);
		add(text2);
		add(text3);
		text1.addActionListener(this);// Ϊ�ı���text1���ü�����
		text1.addActionListener(s);// ������������һ����this����һ����s����
	}

	public void actionPerformed(ActionEvent e)// ʵ��ActionListener�ӿڵķ���
	{
		/*
		 * getActionCommand()��������ͬһ���¼�Դ��ͬһ���¼����簴ť
		 * ������������в�ͬ��ActionCommand�����ActionCommand��һ�� �ַ��ڰ�ť
		 * �Ͳ˵����Ͽ�����setActionCommand���ã� �����¼�����ʱ������ͨ���жϸ÷����ķ���ֵ���԰�ť�ڲ�ͬ
		 * ����±�������¼��������ˣ�
		 */
		// String number=e.getActionCommand();
		String number = text1.getText();// ���ַ��������Եõ�numberֵ
		int n = Integer.parseInt(number);
		int m = n * n;
		text2.setText(n + "��ƽ���ǣ�" + m);
	}
}

class Second implements ActionListener {
	ActionEventTest3 a = null;

	Second(ActionEventTest3 a)// ���췽��
	{
		this.a = a;
	}

	public void actionPerformed(ActionEvent e)// ActionListener�ӿ��з���������һ��ʵ��
	{
		String number = e.getActionCommand();
//		String number= a.text1.getText();
		int n = Integer.parseInt(number);
		int m = n * n * n;
		a.text3.setText(n + "�������ǣ�" + m);
	}
}