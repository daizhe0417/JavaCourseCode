package cn.daizhe.javacourse.lecture.ch3.C303;

/**
 * this的三个用法
 * 
 * @author venice
 * @version 2013
 */
public class ThisTest {
	public static void main(String args[]) {
		
		Tdate t1 = new Tdate();
		Tdate t2 = new Tdate(4);
		t1.equals(t1);
//		Tdate t3 = new Tdate(5, 1);
//		Tdate t4 = new Tdate(6, 2, 2007);
//		t1.setM(9);
//		System.out.println("" + t1.getY() + "年" + t1.getM() + "月" + t1.getD()
//				+ "日");
//		System.out.println("" + t2.getY() + "年" + t2.getM() + "月" + t2.getD()
//				+ "日");
//		System.out.println("" + t3.getY() + "年" + t3.getM() + "月" + t3.getD()
//				+ "日");
//		System.out.println("" + t4.getY() + "年" + t4.getM() + "月" + t4.getD()
//				+ "日");
	}
}

class Tdate {
	private int m, d, y;// 私有成员变量

	// 构造方法
	public Tdate(int m, int d, int y) {
		// this的用法二
		// 通过this访问当前对象的成员变量
		this.m = m;
		this.d = d;
		this.y = y;
		System.out.println("Tdate(int m,int d,int y)");
	}

	// 重载的构造方法
	public Tdate(int m, int d) {
		// this.m=m;this.d=d;y=2006;
		// this的用法三
		// 通过this调用本类的其他构造方法
		// 注意：如果使用this，必须放在方法的第一行
		this(m, d, 2006);
		System.out.println("Tdate(int m,int d)");
	}

	public Tdate(int m) {
		// this.m=m;d=28;y=2006;
		this(m, 28);// 通过this调用本类的其他构造方法
		System.out.println("Tdate(int m)");
	}

	public Tdate() {
		// m=3;d=28;y=2006;
		this(3, 28, 2006);
		System.out.println("Tdate()");
	}

	// 访问私有成员变量的共有方法
	public int getM() {
		return m;
	}

	public int getD() {
		return d;
	}

	public int getY() {
		return y;
	}

	public void setM(int m) {
		this.m = m;
	}

	public void setD(int d) {
		this.d = d;
	}

	public void setY(int y) {
		this.y = y;
	}

	// this的用法一
	// this==t中的this指调用成员方法的当前对象自身
	public boolean equals(Tdate t) {
		return this == t || t != null && this.d == t.d && this.m == t.m
				&& this.y == t.y;
	}
}
