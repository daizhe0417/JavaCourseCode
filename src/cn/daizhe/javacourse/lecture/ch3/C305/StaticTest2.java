package cn.daizhe.javacourse.lecture.ch3.C305;

/**
 * 类成员和实例成员的调用关系及创建时机
 * 
 * @author venice
 * @version 2013
 */
// 圆类
class MyCircle {
	// 实例成员变量
	private int x, y;// 坐标
	private int r;// 半径

	// 类变量
	protected static int num;// 计数器

	// =================================
	// 构造方法
	public MyCircle() {
		x = 0;
		y = 0;
		r = 0;
		num++;
	}

	public MyCircle(int r) {
		this.r = r;
		num++;
	}

	public MyCircle(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
		num++;
	}

	// =================================
	// 修改成员变量方法
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setR(int r) {
		this.r = r;
	}

	// 访问成员变量方法
	public int getX() {
		return x;
	}

	public int getY() {
		int y = 9;
		return y;// 与类的成员变量重名，则成员变量在该方法中被隐藏
	}

	public int getR() {
		int r = 9;
		return this.r;// 用this操作法引用类的成员变量
	}

	// 修改成员变量方法set
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// 重载set方法
	public void set(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	// =================================
	// 类方法，可以访问类变量，若不是类方法也可以访问类变量
	static public int getN() {
		return num;
	}

	// 计算面积方法
	public double area() {
		return Math.PI * r * r;
	}
}

public class StaticTest2 {
	 static MyCircle c;
	// main方法是类方法
	public static void main(String[] args) {
		// 未创建对象前，可以调用类成员和类方法
		System.out.println("创建对象前num的值：" + MyCircle.num);// 使用类名.类变量名方式访问类变量
		System.out.println("创建对象前num的值：" + MyCircle.getN());// 使用类名.类方法名方式访问类变量
		// 也可以通过引用名.类成员的方式访问类成员
//		MyCircle c;// c=null必须有，负责调用c.getN()将报c未初始化的错误
		// 或者上一行的声明放在main之前c作为成员变量，如94行，注意必须是static的成员，否则main方法中不能直接调用
		System.out.println("创建对象前num的值：" + c.area());
		// 未创建对象前，不可以调用类的实例成员
		// Mycircle.getN();// 编译报错

		// 对象的创建
		MyCircle c1 = new MyCircle();// 完成对象的声明、实例化及指向对象实例，没有使用定义的构造方法
		MyCircle c2 = new MyCircle(3);// 构造方法的重载
		MyCircle c3 = new MyCircle(2, 4, 6);// 构造方法的重载

		// 创建对象后仍然可以访问类成员
		System.out.println("创建对象后num的值：" + MyCircle.num);
		System.out.println("创建对象后num的值：" + c1.num);// 也可以用任意对象名访问类变量

		// 通过成员方法访问成员变量
		System.out.println("修改前");
		System.out.println("c1的坐标是：" + c1.getX() + "," + c1.getY());
		System.out.println("c1的半径是：" + c1.getR());
		System.out.println("c2的坐标是：" + c2.getX() + "," + c2.getY());
		System.out.println("c2的半径是：" + c2.getR());
		System.out.println("c3的坐标是：" + c3.getX() + "," + c3.getY());
		System.out.println("c3的半径是：" + c3.getR());
		// 通过成员方法修改成员变量
		c1.setX(1);
		c1.setY(2);
		c1.setR(3);
		c2.set(4, 5);
		c3.set(6, 7, 8);
		// 通过成员方法访问成员变量
		System.out.println("修改后");
		System.out.println("c1的坐标是：" + c1.getX() + "," + c1.getY());
		System.out.println("c1的半径是：" + c1.getR());
		System.out.println("c2的坐标是：" + c2.getX() + "," + c2.getY());
		System.out.println("c2的半径是：" + c2.getR());
		System.out.println("c3的坐标是：" + c3.getX() + "," + c3.getY());
		System.out.println("c3的半径是：" + c3.getR());
		// 调用成员方法
		System.out.println("c1的面积是：" + c1.area());
	}
}
