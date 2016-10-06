package cn.daizhe.javacourse.lecture.ch5.C502;

/**
 * 关于自定义异常及throw 自定义异常类，必须是Exception的子类
 * 
 * @author venice
 * 
 */

class MyException extends Exception {
	private int detail;

	// 自定义异常类的构造方法
	MyException(int a) {
		detail = a;
	}

	public String toString() {
		return "MyException" + detail;
	}
}

public class ExceptionDemo3 {
	static void compute(int a) throws Exception,ArrayIndexOutOfBoundsException {
		if (a > 10)
			throw new MyException(a);// 用throw抛出异常
		System.out.println("Normal Exit");
	}

	public static void main(String args[]) throws Exception {
//		try {
			compute(1);
			compute(20);
//		} catch (Exception e) {
//			System.out.println("Caugh" + e);
//		}
	}
}