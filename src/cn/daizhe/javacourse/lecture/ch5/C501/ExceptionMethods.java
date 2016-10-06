package cn.daizhe.javacourse.lecture.ch5.C501;

/**
 * c10:ExceptionMethods.java Demonstrating the Exception Methods.
 * Exception类中的方法.抛出异常throw关键字
 * 
 * @author Bruce Eckel
 * 
 */
public class ExceptionMethods {
	public static void main(String[] args) {
		try {
			throw new ArrayIndexOutOfBoundsException("Here's my Exception");
			
		} catch (Exception e) {
			System.err.println("Caught Exception");
			// getMessage方法
			System.err.println("e.getMessage(): " + e.getMessage());
			// getLocalizedMessage方法
			System.err.println("e.getLocalizedMessage(): "
					+ e.getLocalizedMessage());
			// toString方法
			System.err.println("e.toString(): " + e);
			// printStackTrace方法
			System.err.println("e.printStackTrace():");
			e.printStackTrace(System.err);
		}
	}
}