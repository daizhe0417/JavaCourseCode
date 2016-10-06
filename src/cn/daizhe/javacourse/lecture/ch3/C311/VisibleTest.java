package cn.daizhe.javacourse.lecture.ch3.C311;

import cn.daizhe.javacourse.lecture.ch3.C306.Person;

/**
 * 关于访问权限 protected权限的含义： 只是在本类中访问本类实例从父类中继承来的protected成员 不能直接访问父类的protected成员
 * 不能访问父类的其他子类的protected成员
 * 
 * @author venice
 * @version 2013
 */
public class VisibleTest extends Person {
	public static void main(String args[]) {

		// 不能直接访问父类的protected成员
		// Person p=new Person();
		// System.out.println(p.name);

		// 不能访问父类的其他子类继承到的protected成员
		// Acce a=new Acce();
		// System.out.println(a.name);

		// 只能在本类中访问本类实例从父类中继承来的protected成员
		VisibleTest vt = new VisibleTest();
		System.out.println(vt.name);
	}
}

class Acce extends Person {

	public static void main(String args[]) {
		// VisibleTest vt = new VisibleTest();
		// System.out.println(vt.name);

		Acce a = new Acce();
		System.out.println(a.name);
	}

}