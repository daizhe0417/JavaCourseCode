package cn.daizhe.javacourse.lecture.ch2.C202;

/**
 * 1、常量的定义使用 2、为了说明常量将由引用者在各自的常量池中复制一个拷贝 下面的类和ConstantDate请去掉包声明后在命令行下编译执行
 * 会发现当修改ConstantDate类中常量的值并单独重新编译（不重新编译ConstantTest类）时，本类的输出结果不会修改
 * 
 * @author venice
 * @version 2012-02-26
 */
public class ConstantTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// =================================
		// 常量的定义
		final float PI = 3.14f;
		// PI++;//错误，常量的值不能修改

		// 也可以先声明后赋值，但只能赋值一次
		final float MAX_FILENAME_LENGTH;
		MAX_FILENAME_LENGTH = 100;

		// =================================
		// 在引用类中只使用了常量的独立拷贝
		System.out.println(ConstantDate.CONS);
	}
}
