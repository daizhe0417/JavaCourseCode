package cn.daizhe.javacourse.lecture.ch5.C501;

/**
 * Java对数组范围有检测
 * 
 * @author venice
 * @version 2013
 */
public class OutofBoundsTest {
	public static void main(String args[]) {
		int a[] = { 1, 2, 3, 4 };
		for (int i = 0; i < 5; i++)
			// 下面代码将产生ArrayIndexOutOfBoundsException异常
			System.out.println("  a[" + i + "]=" + a[i]);
		// 发生异常下面的内容执行不到
		System.out.println("finish");
	}
}
