package cn.daizhe.javacourse.lecture.ch3.C304;

/**
 * 关于instanceof操作符，前一个操作数是引用，后一个操作数是可以被实例化的标志denote 当前面的引用可以指向后面的类型时返回真，否则返回假
 * 当用于父类、子类条件判断时，注意顺序
 * 
 * @author venice
 * @version 2013
 */
class Child extends InstanceofTest {
	public Child() {
		super("Child");
	}
}

public class InstanceofTest {
	private String name;

	public InstanceofTest(String name) {
		this.name = name;
	}

	public InstanceofTest() {
		this.name = "Parent";
	}

	public static void main(String[] args) {
		InstanceofTest it = new InstanceofTest();
		it = new Child();
		// 下面两种写法都返回InstanceTest
		// 即it既是Child的实例，也可以认为是其父类InstanceofTest的实例
		if (it instanceof Child)
			System.out.println("InstanceTest");
		else if (it instanceof InstanceofTest)
			System.out.println("Child");
		
		if (it instanceof InstanceofTest)
			System.out.println("InstanceTest");
		else if (it instanceof Child)
			System.out.println("Child");
	}
}
