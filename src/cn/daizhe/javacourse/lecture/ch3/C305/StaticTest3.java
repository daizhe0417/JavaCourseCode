package cn.daizhe.javacourse.lecture.ch3.C305;

/**
 * 静态代码块和类的加载，注意程序的执行结果中的输出顺序
 * 
 * @author venice
 * @version 2013
 */
public class StaticTest3 {

	// 类方法，简化输出函数
	public static void prt(String s) {
		System.out.println(s);
	}

	// 成员变量v是Value类的实例的引用变量，是Static3类的实例成员变量，和下面的int x类似
	Value v = new Value(1);
	private int x = 10;
	// v1和v2是Static3类的类成员变量
	static Value v1, v2;
	// 静态代码块，
	/*
	 * 一个类中可以使用不包含在任何方法体中的静态代码块（static block）， 当类被载入时，静态代码块被执行； 静态代码块只执行一次；
	 * 静态代码块经常用来进行类属性的初始化
	 */
	static {
		prt("Static block1");
		prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
		v1 = new Value(5);
		prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
		v2 = new Value(6);
		prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
	}

	public static void main(String[] args) {
		prt("main");
		StaticTest3 ct = new StaticTest3(); // 创建一个Count类的实例，其引用是ct
		StaticTest3 ct2 = new StaticTest3();
		// Count类的实例的成员变量v的成员变量c
		prt("ct.v.c=" + ct.v.c);
		// Count类的成员方法main调用Count类的成员变量v1和v2
		// 注意：类方法只能调用类变量
		prt("v1.c=" + ct.v1.c + "  v2.c=" + v2.c);
		// Count类的成员变量v1的成员方法inc
		v1.increase();
		prt("ct.v.c=" + ct.v.c);
		prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
	}

	static {
		prt("Static block2");
		prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
		v1 = new Value(5);
		prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
		v2 = new Value(6);
		prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
	}
}

class Value {
	// 整型类成员变量
	static int c;

	// 构造方法
	Value() {
		System.out.println("Value()");
		c = 3;
	}

	// 重载构造方法
	Value(int i) {

		System.out.println("Value(int i) i=" + i);
		c = i;
	}

	// 类成员方法
	static void increase() {
		System.out.println("inc()");
		c++;
	}
}