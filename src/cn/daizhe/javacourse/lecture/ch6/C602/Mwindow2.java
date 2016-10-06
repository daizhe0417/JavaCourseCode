package cn.daizhe.javacourse.lecture.ch6.C602;//���ڡ��˵���ʹ��
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

//Բ�࣬�����������࣬������Ϊ�¼�������
class Mcircle extends Panel implements ActionListener {
	double r, area;
	TextField tr = null, result = null;
	Button b = null;

	// ���췽�����������������е����
	Mcircle() {
		tr = new TextField(10);
		result = new TextField(10);
		b = new Button("ȷ��");
		add(new Label("����뾶"));
		add(tr);
		add(new Label("����ǣ�"));
		add(result);
		add(b);
		// Ϊ��ťע���¼�������
		b.addActionListener(this);
	}

	// �¼�������
	public void actionPerformed(ActionEvent e) {
		try// ��һ������쳣
		{
			r = Double.parseDouble(tr.getText());
			area = Math.PI * r * r;
			result.setText("" + area);
		} catch (Exception ee) {
			// tr.setText("�����������ַ�");
			// Swing����е���Ϣ�Ի���
			JOptionPane.showMessageDialog(this, "�����������ַ�", "��Ϣ�Ի���",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}

// �������࣬���������࣬����Ϊ�¼�������
class Mtrangle extends Panel implements ActionListener {
	double a = 0, b = 0, c = 0, area;
	TextField ta = new TextField(6), tb = new TextField(6), tc = new TextField(
			6), tr = new TextField(24);
	Button Button = new Button("ȷ��");
	MyDialog dia;

	Mtrangle() {
		add(new Label("�������߳��ȣ�"));
		add(ta);
		add(tb);
		add(tc);
		add(new Label("����ǣ�"));
		add(tr);
		add(Button);
		Button.addActionListener(this);
	}

	// �¼�������
	public void actionPerformed(ActionEvent e) {
		try {
			a = Double.parseDouble(ta.getText());
			b = Double.parseDouble(tb.getText());
			c = Double.parseDouble(tc.getText());
			if (a + b > c && b + c > a && c + a > b) {
				double p = (a + b + c) / 2;
				area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
				tr.setText("" + area);
			} else {
				tr.setText("���ܹ���������");
			}
		} catch (Exception ee) {
			// tr.setText("�����������ַ�");
			JOptionPane.showConfirmDialog(this, "�����������ַ�", "ȷ�϶Ի���",
					JOptionPane.YES_NO_OPTION);
		}
	}
}

// �Ի�����
class MyDialog extends Dialog implements ActionListener {
	Button yes;

	public MyDialog(Frame f, String s, boolean b) {
		super(f, s, b);
		if (b)
			yes = new Button("��ģʽ�Ի���");
		else
			yes = new Button("��ģʽ�Ի���");
		yes.addActionListener(this);
		add(yes);
		setBounds(250, 200, 200, 100);
		// Ϊ�Ի�����Ӵ����¼�������
		// �����������������ڲ���
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == yes) {
			setVisible(false);
		}
	}
}

// �����࣬window�����࣬����Ϊ�¼�������
class Win extends Frame implements ActionListener {
	MenuBar bar = null;
	Menu men = null, men2 = null;
	MenuItem item1, item2, item3, item4;
	Mcircle c;
	Mtrangle t;
	MyDialog dai;

	Win() {
		// ��Ӳ˵�
		bar = new MenuBar();
		men = new Menu("ѡ��");
		item1 = new MenuItem("Բ�������");
		item2 = new MenuItem("�������������");
		men2 = new Menu("�Ի���");
		item3 = new MenuItem("��ģʽ");
		item4 = new MenuItem("��ģʽ");
		men.add(item1);
		men.add(item2);
		men2.add(item3);
		men2.add(item4);
		bar.add(men);
		bar.add(men2);
		setMenuBar(bar);

		c = new Mcircle();
		t = new Mtrangle();
		// Ϊ���˵�������¼�������
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);

		setVisible(true);
		setBounds(100, 120, 100, 90);
	}

	// �¼�������
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == item1) {
			removeAll();
			add(c, "Center");
			validate();// ������С
		} else if (e.getSource() == item2) {
			removeAll();
			add(t, "Center");
			validate();
		} else if (e.getSource() == item3) {
			dai = new MyDialog(this, "��ģʽ", true);
			dai.setVisible(true);
		} else if (e.getSource() == item4) {
			dai = new MyDialog(this, "��ģʽ", false);
			dai.setVisible(true);
		}
	}
}

public class Mwindow2 {
	public static void main(String args[]) {
		Win win = new Win();
		win.setBounds(100, 100, 500, 300);
		win.setVisible(true);
		// ��Ӵ����¼�������
		// �������ڲ���Ϊ���������ô����¼�������
		win.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
