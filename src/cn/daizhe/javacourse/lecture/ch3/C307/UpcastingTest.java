package cn.daizhe.javacourse.lecture.ch3.C307;

/**
 * 向上转型，即允许用父类的引用指向其子类的实例 这时，通过父类的引用能够访问的方法只有在父类中声明过的，试图访问子类新增方法将编译报错
 * 但是实际调用时要看当时到底指向谁的实例（即如果指向子类实例，调用的还是子类的方法） 如果再将该子类实例用子类引用指向，才可以访问子类中新增的方法
 * 
 * 
 * @author daizhe
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

}

/** Rice extends Food */
class Rice extends Food {
	public Rice() {
		super();
	}

	public Rice(String name) {
		super(name);
	}
}

/** Sandwich extends Food */
class Sandwich extends Food {
	public Sandwich(String name) {
		super(name);
	}
}

abstract class Person {
	// 下面的eat方法如果不是接收Food类型的参数，则需要为每个Food的子类创建相应的eat方法
	// 而采用Food作为参数类型，调用时可以传入任意Food或其子类的实例
	// 这就是Food类型的引用指向其子类的实例，即向上转型

	// eat方法可以是抽象或非抽象的
	// 抽象方法eat，规定People类必须具有的方法
	// abstract public void eat(Food food);
	public void eat(Food food) {
		System.out.println("Person eat" + food);
	}
}

class Chinese extends Person {
	// 如果Person的eat方法是抽象的，子类必须完成其抽象方法的实现
	// 否则这里就是对Person的eat方法的覆盖
	public void eat(Object food) {
		System.out.println("Chinese eating " + food);
	}
	
	public void eat(Rice food) {
		System.out.println("Chinese eating " + food);
	}
	public void eat(Sandwich food) {
		System.out.println("Chinese eating " + food);
	}

	// 子类中定义的新的方法
	public void run() {

	}
}

class Amercian extends Person {
	// 对People的eat抽象方法的实现，或者是覆盖
	public void eat(Food food) {
		System.out.println("Amercian eating " + food);
	}
	
	
}

public class UpcastingTest {
	public static void main(String[] args) {
		// 定义Person类的引用
		Person man;
		// 上转型对象，即父类的引用指向子类的实例
		man = new Chinese();
		
		Rice rice = new Rice("rice");
		// 调用上转型对象的方法，因为此时man指向的是Chinese的实例，调用的是Chinese类的eat方法
		// eat的参数需要Food类型，rice是子类实例，也可以
		man.eat(rice);
		// 编译时对方法的检查以引用的类型为准
		// 下面的代码man是Person父类的引用，而run是子类的新方法，父类Person中没有，所以下面的调用编译时报错
		// man.run();
		
		Rice rice2 = new Rice();
		// 通过类型强制换行，用子类引用指向子类实例
		Chinese c = (Chinese) man;
		c.eat(rice2);// 调用子类Chinese的eat方法
		c.run();// 这时又可以调用run方法了
		
		// 给eat方法其他类型的参数，因为是Food子类实例，所以可以
		Sandwich san = new Sandwich("sandwich");
		man.eat(san);
		
		// 父类引用指向其他子类的实例
		man = new Amercian();
		// 调用的是Amercian类的eat方法
		man.eat(rice2);
	}
}
