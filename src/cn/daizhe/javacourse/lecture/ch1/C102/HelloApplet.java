package cn.daizhe.javacourse.lecture.ch1.C102;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
/**
 * 第一个java Applet程序
 * @author daizhe
 *
 */
//主类需要是Applet类的子类
public class HelloApplet extends Applet {
//程序起点不是main()方法，而是paint()方法
	public void paint(Graphics g){
		g.setColor(Color.red);
		g.drawString("Hello!", 20, 20);
	}
}

/*
执行方法：
1、编译生成字节码文件HelloApplet.class
2、编写.html文件，
3、浏览器打开.html文件，或者用appletviewer.exe执行
*/
