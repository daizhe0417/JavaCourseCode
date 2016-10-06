package cn.daizhe.javacourse.lecture.ch3.C308;

/**
 * 类的加载顺序：有父类优先加载父类，以此类推；每个类先按字面顺序加载静态内容；所有父子类的静态内容加载完成才调用main函数，然后才创建实例 
 * The full process of initialization. From 'Thinking in Java, 2nd ed.'
 * 
 * @author Bruce Eckel
 * 
 */

// 父类
class Insect {
	// 实例成员变量
	int i = 9;
	int j;

	// 构造方法
	Insect() {
		prt("i = " + i + ", j = " + j);
		j = 39;
	}

	// 类成员变量，赋值时调用类方法（只能调用类方法，实例方法不行，因为这时可能还没有创建任何实例，实例方法还不可用
	static int x1 = prt("static Insect.x1 initialized");

	// 类方法，类加载时加载其方法入口，但不是执行方法
	static int prt(String s) {
		System.out.println(s);
		return 47;
	}
}

// 子类
public class Beetle extends Insect {

	// 实例成员变量，如果没有prt将在创建实例时自动初始化
	// 这里的prt方法可以是实例方法，因为只在创建实例时才调用prt方法进行初始化
	int k = prt("Beetle.k initialized");

	// 构造方法
	Beetle() {
		super();// super调用父类的构造方法，必须在第一行
		prt("k = " + k);// 子类的成员
		prt("j = " + j);// j是从父类继承的成员
	}

	// 静态代码块
	static int x2 = prt("static Beetle.x2 initialized");
	static int x3 = prt("static Beetle.x3 initialized");

	// main函数也是静态内容，但要等到父类和本类的所有静态内容加载完才执行
	public static void main(String[] args) {
		// 调用其他类的main函数
		String[] s = new String[2];
		s[0] = "hello";
		s[1] = " world";
//		InstanceofTest.main(s);
		prt("Beetle constructor");
		Beetle b = new Beetle();
		// Insect i = new Insect();
		// i.Insect();
	}

	static {
		prt("static block");
	}

}

/*
执行结果：
static Insect.x1 initialized// 父类静态内容
static Beetle.x2 initialized// 子类静态内容
static Beetle.x3 initialized
static block// 虽然这个静态代码块在main之后，但也先执行
InstanceTest// main的内容
InstanceTest
Beetle constructor
i = 9, j = 0
Beetle.k initialized
k = 47
j = 39
 */