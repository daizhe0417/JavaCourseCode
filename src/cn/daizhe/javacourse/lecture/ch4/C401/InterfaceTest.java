package cn.daizhe.javacourse.lecture.ch4.C401;

/**
 * 关于接口的定义和接口回调
 * 
 * @author venice
 * @version 2013
 */
class Food {

	// private String name;
	protected String name;

	public Food() {
		name = "Food";
		System.out.println("Food OK");
	}

	public Food(String name) {
		this.name = name;
		System.out.println(name + " OK");
	}

	public String toString() {
		return name;
	}

	public static void main(String args[]) {
		Food food = new Food("food");
		System.out.println("" + food.toString());
	}
}

class Rice extends Food {
	public Rice() {
		super();
	}

	public Rice(String name) {
		super(name);
	}
}

class Sandwich extends Food {
	public Sandwich(String name) {
		super(name);
	}
}

class Language {
}

// 下面的接口声明错误，接口可以声明为public的，但必须与所在文件同名，且不能与其他类同名
// public interface Interfacetest {// 注意大小写
// public interface Person{

// 定义接口
interface Person {
	// -------接口也可以声明数据成员，但是都是final的-------
	// int weight;//错误，接口中的数据成员都是final的必须赋初值

	// 接口的数据成员隐含修饰为public static final，这三个修饰写不写效果一样
	// 下面两行都可以
	// int weight = 10;// 正确，

	public static final int weight = 0;

	// -------接口的方法只是声明，没有实现，隐患是public abstract的，没有构造方法-------
	void eat(Food food);// 规定实现接口的类必须覆盖的方法
	// void eat(Food food){}// 错误，接口方法没有实现，不能有{}
	// static void eat(Food food);//错误，接口中的方法默认为abstract的，所以不能是static的
	// public Person();//错误，接口中不能定义构造方法

	public abstract void speak(Language l);// 正确，有没有public abstract效果一样

}

// abstract // 实现接口的类
class Chinese implements Person {
	// -------接口的实现类必须实现接口中的抽象方法，除非它是抽象类-------

	// -------实现eat(Food food)方法-------
	// 一、和方法的覆盖一样，返回值类型也要和接口中声明的一样
	// 因此下面的声明会报错
//	 public String eat(Food food){}
	// 解决办法要么把String改成void；
	// 要么再写一个返回值为void的方法，但是要注意，不能同时存在String eat(Food food)和void eat(Food food)
	// 因为这两个方法既不是覆盖也不是重载

	// 二、和方法的覆盖一样，访问权限不能比接口中方法的访问权限低
//	 protected void eat(Food food);// 错误，
	public void eat(Food food) {// 正确，实现了接口中的抽象方法

	}

	// -------实现speak(Language l)方法-------
	// 下面的声明错误，覆盖接口的方法不能也是抽象的，除非这个类是抽象类，
	// public abstract void speak(Language l);
	// 在Chinese类的声明前加上abstract可以解决这个错误
	public void speak(Language l) {// 正确

	}

	// -------接口的实现类也可以有自己的数据成员和成员方法-------
	public void run() {

	}
}

// 实现接口的类，接口可以被多个类实现
class Amercian implements Person // 实现接口
{
	public void eat(Food food) // 实现People接口的类必须完成它的方法
	{
		System.out.println("Amercian eatint " + food);
	}

	public void speak(Language l) {
	}
}

public class InterfaceTest {
	public static void main(String[] args) {
		// -------访问接口的数据成员-------
		// 接口中的数据成员是public的可以在任意其他类中直接访问
		// 接口中的数据成员是static的可以不必创建实例而通过接口名.的方式访问
		System.out.println("Person.weight=" + Person.weight);
		// 接口中的数据成员是final的，不能修改其值
//		Person.weight++;// 错误

		// -------接口不能实例化-------
		// Person man = new Person();// 错误

		// -------接口回调-------
		Person man;// 接口不能实例化，但是接口也是数据类型，可以定义这个类型的引用
		man = new Chinese(); // 接口回调，即接口的引用可以指向任意实现了该接口的类的实例
		Food f = new Rice("rice");
		man.eat(f); // 调用实现接口类的方法，原则是指向谁的实例，就调用谁的方法
		// man.run();// 错误，因为man是Person类型的引用，编译时检查只能调用Person中定义过的方法

		// 用instanceof判断引用所指向的实例
		if (man instanceof Chinese)
			System.out.println("Instance of Chinese");
		man = new Amercian();// 同上
		man.eat(f);

		// -------接口回调的意义-------
		// 根据参数决定创建谁的实例
		if (args.length > 0) {
			if (args[0].equals("Chinese"))
				man = new Chinese();
			else
				// if(args[0]=="Amercian")
				man = new Amercian();

			// 无论参数是什么，调用eat()方法的代码都一样
			// 因为man作为接口Person类型的引用，可以指向任意实现类的实例，再调用其方法
			man.eat(f);
			// 接口回调的意义就是，如果没有接口回调，代码就要写出下面这样
			if (args[0].equals("Chinese")) {
				Chinese c = new Chinese();
				c.eat(f);
			} else {
				Amercian a = new Amercian();
				a.eat(f);
			}
			// 这样的写法当接口的实现类发生变化时，就要做大量的修改了
		}
	}
}
