package cn.daizhe.javacourse.lecture.ch6.C603;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

class MyTree extends JFrame implements TreeSelectionListener {
	JTree tree = null;
	JTextArea text = new JTextArea(20, 20);

	MyTree() {
		Container con = getContentPane();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("通讯录");
		DefaultMutableTreeNode r1 = new DefaultMutableTreeNode("大学同学");
		DefaultMutableTreeNode r2 = new DefaultMutableTreeNode("研究生同");
		DefaultMutableTreeNode r11 = new DefaultMutableTreeNode("小明");
		DefaultMutableTreeNode r12 = new DefaultMutableTreeNode("老七");
		DefaultMutableTreeNode r21 = new DefaultMutableTreeNode("罗");
		DefaultMutableTreeNode r22 = new DefaultMutableTreeNode("张");

		root.add(r1);
		root.add(r2);
		r1.add(r11);
		r1.add(r12);
		r2.add(r21);
		r2.add(r22);
		tree = new JTree(root);
		tree.setEditable(true);

		JScrollPane sp = new JScrollPane(text);
		JSplitPane spl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true,
				tree, sp);

		tree.addTreeSelectionListener(this);
		con.add(spl);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
		setBounds(100, 100, 300, 300);
	}

	public void valueChanged(TreeSelectionEvent e) {
		if (e.getSource() == tree) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
					.getLastSelectedPathComponent();
			if (node.isLeaf()) {
				String str = node.toString();
				if (str.equals("小明")) {
					text.setText("鞍山");
				} else if (str.equals("老七")) {
					text.setText("大连");
				}
				if (str.equals("罗")) {
					text.setText("北京");
				}
			} else {
				text.setText(node.getUserObject().toString());
			}
		}
	}
}

public class JTreeTest {
	public static void main(String args[]) {
		MyTree t = new MyTree();
		t.pack();
	}
}
