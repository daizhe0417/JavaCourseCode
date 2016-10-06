package cn.daizhe.javacourse.lecture.ch5.C504;

/**
 * Demonstrating fillInStackTrace()
 * 
 * @author Bruce Eckel
 * 
 */
public class Rethrowing {

	public static void f() throws Exception {
		System.out.println("originating the exception in f()");
		throw new Exception("thrown from f()");
	}

	public static void g() throws Throwable {
		try {
			f();
		} catch (Exception e) {
			System.err.println("Inside g(), e.printStackTrace()");
			e.printStackTrace(System.err);
			throw e; // 17
			// throw e.fillInStackTrace(); // 18
		}
	}

	public static void main(String[] args) throws Throwable {
		try {
			g();
		} catch (Exception e) {
			System.err.println("Caught in main, e.printStackTrace()");
			e.printStackTrace(System.err);
		}
	}

}
