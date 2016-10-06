package cn.daizhe.javacourse.lecture.ch6.C601;

/**
 * awt登录窗口
 * @author venice
 * @version 2012-05-03
 */
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrame extends Frame {
	public LoginFrame() {
		super("User Login");
		this.setSize(200, 120); // 设置框架尺寸
		this.setBackground(Color.lightGray); // 设置框架背景颜色
		this.setLocation(300, 240); // 框架显示在屏幕的位置
		// 不设置布局的后果
		this.setLayout(new FlowLayout()); // 框架流布局，居中

		this.add(new Label("userid")); // 创建标签，添加到框架上
		this.add(new TextField("user1", 10)); // 创建文本行
		this.add(new Label("password"));
		this.add(new TextField(10)); // 创建20列的文本行
		this.add(new Button("Ok")); // 创建按钮
		this.add(new Button("Cancel"));
		// pack重绘，有和没有它的效果
		this.pack();
		// 一定要有这句，否则不会显示窗口
		this.setVisible(true); // 显示框架
	}

	public static void main(String arg[]) {
//		LoginFrame lf=new LoginFrame();
//		lf.addWindowListener(l);
		new LoginFrame().addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}