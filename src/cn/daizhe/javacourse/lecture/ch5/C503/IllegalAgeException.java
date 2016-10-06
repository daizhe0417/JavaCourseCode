package cn.daizhe.javacourse.lecture.ch5.C503;

/**
 * 自定义异常类
 * 
 * @author book
 * @version 2013
 */
// 自定义的无效年龄异常类，需继承Exception类
public class IllegalAgeException extends Exception {
	public IllegalAgeException(String s) {
		super(s);
	}

	public IllegalAgeException() {
		this("");
	}
}
