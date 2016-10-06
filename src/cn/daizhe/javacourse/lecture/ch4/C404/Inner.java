package cn.daizhe.javacourse.lecture.ch4.C404;

/**
 * //内部类
 * 
 * @author venice
 * @version 2013
 */
class InOut {
	String str = new String("Between");

	public void amethod(final int iArgs) {
		final int abc = 8;
		// int abc = 8;
		// 内部类Bicycle
		class Bicycle {
			// 也可以定义成员变量
			private int x = 10;

			// 成员方法
			public void sayHello() {
				System.out.println(str);// 内部类的方法可以访问外部类的成员变量
				System.out.println(iArgs); // 内部类的方法也可以访问外部方法的局部变量
				System.out.println(abc);// 方法中定义的内部类只能访问方法的final变量，如果12行的定义改为13行的形式，此处将编译报错
			}
		}// End of Bicycle class
		new Bicycle().sayHello();// 创建内部类的实例并调用其方法
	}// End of amethod
}

public class Inner {
	public static void main(String args[]) {
		new InOut().amethod(10);
	}
}
