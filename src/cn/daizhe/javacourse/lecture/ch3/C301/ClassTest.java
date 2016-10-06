package cn.daizhe.javacourse.lecture.ch3.C301;

/**
 * 关于类的定义、对象的使用、局部变量的作用域，局部变量和成员变量同名
 * 
 * @author venice
 * @version 2013
 */

// 声明类
class Person {
	// 声明成员变量
	private String name;
	private int age;

	// 声明成员方法
	// 一些方法被称为getter和setter，约定方法名的形式为：getXxx和setXxx，其中Xxx为对应的成员变量名，首字母大写
	// 这些方法主要用于类的封装，将成员变量定义为private的，通过对应的publict的getter和setter方法在外部设置值和取值
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		System.out.println("My age is " + age);
		return this.age;
	}

	public void setAge(int age) {// 这里的age是setAge方法的局部变量
		// =================================
		// 局部变量和成员变量的区别
		// private int x;// 声明局部变量不能加访问权限
		int x;
		x = 0;// 没有这行，下面一行x++将编译报错，因为x是局部变量，引用前必须赋初值！而成员变量可以由系统完成初始化
		x++;

		// 当局部变量与成员变量同名时，在方法中只能引用局部变量，成员变量被忽略，
		System.out.println("age in setAge() is " + age);
		// 引用成员变量的方法是在变量前加this.
		System.out.println("this.age in setAge() is " + this.age);
		// 常用的成员变量赋值格式
		this.age = age;
	}

	// 声明构造方法
	Person() {
		this.name = "";
	}

	// 声明重载的构造方法
	Person(String name) {
		this.name = name;
	}

	// 声明重载的构造方法
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// 重载Object类的equals方法
	// 给出自己的判断两个本类实例是否相等的标准
	public boolean equals(Person p) {
		return this == p || p != null && this.name.equals(p.name)
				&& this.age == p.getAge();
	}

	// 下面的语句将报错
	// 所有的语句只能存在于某个方法中，不能单独在类中直接出现
	// System.out.println("x in setAge is "+age);
}

// 一个java文件可以声明多个类，但只能有一个public的
// 编译后每个类生成一个.class文件
public class ClassTest {
	// 声明main方法，格式固定
	public static void main(String args[]) {
		// =================================
		// 创建类的实例

		// 声明对象的引用变量
		Person p1, p2;
		// 对象的实例化
		p1 = new Person("张三");
		p2 = new Person("李四");
		// 调用成员方法，可以输出p1、p2的age值，虽然没有赋初值，因为成员变量自动初始化
		p1.getAge();
		p2.getAge();
		// 调用成员方法为成员变量赋值
		p1.setAge(10);

		p1.getAge();
		p2.getAge();

		// =================================
		// 运算关系和比较相等
		System.out.println("运算关系和比较相等");
		p2.setName("张三");
		p2.setAge(p1.getAge());
		System.out.println("p1==p2?  " + (p1 == p2));
		System.out.println("p1.equals(p2)?  " + p1.equals(p2));

	}
}
