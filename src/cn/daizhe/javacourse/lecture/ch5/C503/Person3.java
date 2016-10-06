package cn.daizhe.javacourse.lecture.ch5.C503;

/**
 * 自定义异常类的使用，throw和throws
 * 
 * @author book
 * @version 2013
 */

public class Person3 {
	protected String name; // 姓名
	protected int age; // 年龄

	public Person3(String name, int age) throws IllegalAgeException {
		this.set(name);
		this.set(age);
	}

	public void set(String name) {
		if (name == null || name == "")
			this.name = "姓名未知";
		else
			this.name = name;
	}

	// 当年龄不再范围内，通过throw声明抛出自定义异常类对象
	// 在本方法中不做异常处理，而是通过throws声明将可能产生的异常对象抛给本方法的调用者处理
	public void set(int age) throws IllegalAgeException {
		if (age >= 0 && age < 100)
			this.age = age;
		else
			throw new IllegalAgeException("" + age);
		// System.out.println("");
	}

	public void set(String name, int age) throws IllegalAgeException {
		this.set(name);
		this.set(age);
	}

	public String toString() {
		return this.name + "," + this.age + "岁";
	}

	public void print() {
		System.out.println(this.toString());
	}

	// 如果下面的p1.set(121);调用时不放在try中，则需要main函数按如下形式声明
	// public static void main(String args[]) throws IllegalAgeException
	// 或者
	// public static void main(String args[]) throws Exception
	public static void main(String args[]) {
		Person3 p1 = null;
		try {
			// 调用声明抛出异常的方法，必须写在try语句中，否则编译不通过
			// 除非本方法也通过throws声明将对应的异常对象或者其父类对象抛出给自己的调用者
			p1 = new Person3("李小明", 20);
			p1.set(121);
			p1.set(90);// 即使是调用时参数在合理范围内不会产生异常，也需要放在try中
		} catch (IllegalAgeException e) // 捕获自定义异常类，而非Exception类
		{
			e.printStackTrace(); // 显示异常栈跟踪信息
		} finally {
			p1.print();
		}
	}
}

/*
 * 程序运行结果如下：
 * 
 * IllegalAgeException: 121 at Person2.set(Person2.java:29) at
 * Person2.main(Person2.java:53)
 * 
 * 李小明,20岁
 */
