package cn.daizhe.javacourse.lecture.ch4.C404;

import cn.daizhe.javacourse.lecture.ch3.C306.Student;

/**
 * //内部类引用外部类的成员
 * 
 * @author venice
 * @version 2013
 */
class Outer {
	int a = 1;

	static int h = 10;

	// 下一行的声明不可以，不允许内部类与外部类同名
	// class Inner2 {
	// 内部类aa
	class aa {
		// 内部类也可以是静态的
		// static class aa {
		int a = 10;

		// 静态成员只能声明在静态内部类中
		// static int c=0;
		// static final int c=0;

		// class bb {
		private class bb {
			public int b = 2;

			class cc {
				int a = 5;
				int b = 4;
				int c = 3;

				public void cmethod() {// 这对括号必须有，因为类中语句必须包含在一个代码块或方法体中
					System.out.println("cc");
					System.out.println("cc.c=" + c);
					System.out.println("cc.a=" + a);// 内部类的成员将覆盖外部类同名成员
					System.out.println("bb.b=" + bb.this.b);// 通过外部类名.this访问外部类成员
					System.out.println("aa.a=" + aa.this.a);
					System.out.println("Outer.a=" + Outer.this.a);
				}
			}

		}
	}

	// 内部类的继承
	class ee extends Student {

	}

	// 抽象内部类
	abstract class ff {
		abstract void ffmethod();
	}

//	// 实现内部抽象类
//	class gg extends ff {
//
//		@Override
//		void ffmethod() {
//			// TODO Auto-generated method stub
//
//		}
//
//	}

	// 内部借款
	interface hh {

	}

	// 静态内部类
	static class dd {
		static int j = 9;
		{
			// System.out.println(Outer.a);//静态内部类中不能访问外部类的非静态成员
			System.out.println(Outer.h);// 静态内部类中只能访问静态的外部类成员
		}
	}

	public static void main(String[] args) {
		// 创建内部类的实例的方式
		Outer out = new Outer();
		aa a = out.new aa();
		aa.bb b = a.new bb();
		aa.bb.cc c = new Outer().new aa().new bb().new cc();
		// 访问内部类的成员
		System.out.println(a.a);
		System.out.println(out.a);
		c.cmethod();
		// 访问内部的成员要考虑访问权限，此处对bb类有访问权限，然后在看对bb类的b变量有没有访问权限
		System.out.println("bb.b=" + new Outer().new aa().new bb().b);
	}
}

public class Inner2 {
	public static void main(String[] args) {
		Outer in = new Outer();
		Outer.aa a = in.new aa();
		System.out.println(a.a);
		System.out.println(in.a);
		// bb类是aa的私有内部类，不能在外部调用其构造方法创建实例
		// 此时，bb类的所有内部成员和内部类都不能被访问
		// Outer.aa.bb b = a.new bb();
		// Outer.aa.bb.cc c = new Outer().new aa().new bb().new cc();
		// c.cmethod();
		// System.out.println("bb.b=" + new Outer().new aa().new bb().b);
	}
}
