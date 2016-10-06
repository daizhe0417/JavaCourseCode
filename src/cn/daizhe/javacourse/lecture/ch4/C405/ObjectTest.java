package cn.daizhe.javacourse.lecture.ch4.C405;
/**
 * Object类
 * @author venice
 * @version 2012-04-12
 */
import cn.daizhe.javacourse.lecture.ch4.C404.InnerClassTest;
public class ObjectTest {
	public static void main(String args[]){
		InnerClassTest i=new InnerClassTest();
		// getClass()方法，继承自Object类
		System.out.println(i.getClass());
		
	}
}
