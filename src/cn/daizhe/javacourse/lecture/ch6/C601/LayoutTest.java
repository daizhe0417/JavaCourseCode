package cn.daizhe.javacourse.lecture.ch6.C601;

/**
 * awt����
 * @author venice
 * @version 2012-05-03
 */
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LayoutTest extends Frame implements ActionListener {
	MenuBar bar = null;
	Menu men = null;
	MenuItem flow, border, grid;

	public LayoutTest() {
		setSize(500, 300);

		bar = new MenuBar();
		men = new Menu("����");
		flow = new MenuItem("FlowLayout");
		border = new MenuItem("BorderLayout");
		grid = new MenuItem("GridLayout");
		men.add(flow);
		men.add(border);
		men.add(grid);
		bar.add(men);
		setMenuBar(bar);

		flow.addActionListener(this);
		border.addActionListener(this);
		grid.addActionListener(this);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == flow) {
			removeAll();
			FlowLayout fl = new FlowLayout();
			fl.setAlignment(FlowLayout.LEFT);
			fl.setHgap(20);
			fl.setVgap(40);
			setLayout(fl);
			for (int i = 0; i < 10; i++) {
				add(new Button("button" + (i + 1)));
			}
			validate();
		} else if (e.getSource() == border) {
			removeAll();
			setLayout(new BorderLayout());
			add(new Button("��"), BorderLayout.NORTH);
			add(new Button("��"), BorderLayout.SOUTH);
			add(new Button("��"), BorderLayout.EAST);
			add(new Button("��"), BorderLayout.WEST);
			add(new Button("��"), BorderLayout.CENTER);

			validate();
		} else if (e.getSource() == grid) {
			removeAll();
			setLayout(new GridLayout(4, 4));
			Label l[][] = new Label[4][4];
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++) {
					l[i][j] = new Label();
					if ((i + j) % 2 == 0)
						l[i][j].setBackground(Color.black);
					else
						l[i][j].setBackground(Color.white);
					add(l[i][j]);
				}
			validate();
		}
	}

	public static void main(String args[]) {
		LayoutTest l = new LayoutTest();
		l.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
