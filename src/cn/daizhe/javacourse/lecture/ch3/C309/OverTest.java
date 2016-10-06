package cn.daizhe.javacourse.lecture.ch3.C309;

/**
 * 关于重载和覆盖
 * 
 * @author venice
 * @version 2013
 */

// 父类A
class A {
	int max(int x, int y) {
		System.out.println("A:int max(int x,int y)");
		return x > y ? x : y;
	}

	// 变量名称不能区分同名方法，不是重载
	// int max(int y,int x) {
	// System.out.println("int max(int x,int y)");
	// return x>y?x:y;
	// }

	// 访问权限不能区分方法，不是重载
	// public int max(int x,int y) {
	// System.out.println("public int max(int x,int y)");
	// return x>y?x:y;
	// }

	// 与上面方法的区别只在返回值类型，不是重载，编译通不过
	// float max(int x,int y) {
	// System.out.println("float max(int x,int y)");
	// return x>y?x:y;
	// }

	// 参数类型可以区分重载了max方法
	float max(float x, float y) {
		System.out.println("A:float max(float x,float y)");
		return x > y ? x : y;
	}

	// 与max方法的声明完全相同，又在同一类中，编译同不过
	// int max(int x,int y){
	// System.out.println("int max(int x,int y)");
	// return x>y?x:y;
	// }

}

// 子类
class B extends A {
	// 子类中声明的与父类继承来的方法返回值、方法名、参数列表都相同，且访问权限不低于继承来方法的是覆盖
	// ok：访问权限高于父类方法时可以
	public int max(int x, int y) {

		System.out.println("B:int max(int x,int y)");
		return x > y ? x : y;
	}

	// 下面的声明都有问题：
	// 一、error：返回值不同参数列表相同，如果想重载参数列表应该不同，如果想覆盖返回值要相同
	// public float max(int x,int y){

	// 二、error：覆盖的方法访问权限不能比父类中方法的访问权限低
	// private int max(int x,int y)//

	// 与继承到的方法同名，但参数列表不同，是重载
	public double max(double x, double y) {
		return x > y ? x : y;
	}
}
public class OverTest {
	public static void main(String args[]) {
		A a = new A();// A的引用指向A的实例
		// 调用A的max方法
		System.out.println("a.max(10,20)=" + a.max(10, 20));
		// 调用A的被重载max方法
		System.out.println("a.max(10.5,20.5)=" + a.max(10.5f, 20.5f));
		
		// 
		a = new B();// A的引用指向子类B的实例
		// 调用B中重写的max方法
		System.out.println("a.max(10,20)=" + a.max(10, 20));
		// a.max(3.5, 4.5);
		// 调用B继承自A的max方法
		System.out.println("a.max(10.5,20.5)=" + a.max(10.5f, 20.5f));
		
		B b = (B) a;// B的引用指向B的实例
		b.max(3.5, 4.5);
		// 调用B中重写的max方法
		System.out.println("b.max(10,20)=" + b.max(10, 20));
		// 调用B继承自A的max方法
		System.out.println("b.max(10.5,20.5)=" + b.max(10.5f, 20.5f));
	}
}