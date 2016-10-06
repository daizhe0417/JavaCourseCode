package cn.daizhe.javacourse.lecture.ch3.C310;

/**
 * 抽象类和抽象方法
 * 
 * @author venice
 * @version 2013
 */
public class AbstractTest {
	public static void main(String[] args) {
		// 抽象方法不能实例化，下一句将出错
		// Person p = new Person();
		Chinese c = new Chinese();
		Person p=new Chinese();
		p.eat(new Food());
	}
}

class Food {
}

// 由于有抽象方法eat()，Person必须是抽象类
abstract class Person {

	// 抽象类也可以有非抽象的成员变量和方法
	private String name;

	public void run() {

	}

	// 抽象方法eat，规定People类必须具有的方法
	abstract public void eat(Food food);
	// 抽象方法不能有方法体，下面的定义不正确
	// abstract public void eat(Food food){
	//
	// }

	// 构造方法不能声明为抽象方法，下面的定义不正确
	// public abstract Person(){ }
	// public abstract Person();

	// 类方法不能声明为抽象方法，下面的定义不正确
	// abstract static void eat();
}

class Chinese extends Person {
	// People的子类必须完成其抽象方法的实现
	// 去掉下面的eat方法将报错
	// 解决方法或者给出eat的实现，或者将Chinese声明为abstract类
	public void eat(Food food) {
		System.out.println("Chinese eating " + food);
	}
	// 将上面的eat方法声明为如下格式都不对
	// 一、实现抽象方法也不能降低访问权限
	// private void eat(Food food){}
	// 二、返回值类型不同，也不被认为是实现抽象方法，要么将String改为void，要么将Person中的抽象方法改为
	// public String eat(Food food) {
	// return "";
	// }
	// public String eat(Food food){}
	// 三、参数列表不同当然更不行
	// public void eat(){}
}

class Amercian extends Person {
	// People的子类必须完成其抽象方法的实现
	public void eat(Food food) {
		System.out.println("Amercian eating " + food);
	}
}

// 抽象类的子类必须实现父类的抽象方法，除非它也是抽象类
// Person的子类Man是抽象类，所以不需要实现eat()方法
abstract class Man extends Person {
}

// ChineseMan必须实现eat()方法
class ChineseMan extends Man {

	@Override
	public void eat(Food food) {
		// TODO Auto-generated method stub
		
	}


}
