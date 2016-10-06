package cn.daizhe.javacourse.lecture.ch7.C701;

/**
 * 用Thread类的子类创建线程的方式一
 * 
 * @author daizhe
 * @version 2013
 */
// 多线程和单线程的区别，不继承Thread类或者直接调用run方法都是单线程情况
public class ThreadDemo1 {
	public static void main(String args[]) {
		// 单线程的情况
		// new TestThread().run();
		// 多线程的情况
		new TestThread().start();
		new TestThread().start();
		new TestThread().start();
		for (int i = 0; i < 10; i++) {
			System.out.println("main" + Thread.currentThread().getName() + " is running");// *
		}
	}
}

// 单线程的情况
// class TestThread{
// 多线程的情况
class TestThread extends Thread {
	static int t = 10;

	public void run()// run方法在start方法使线程开始运行后自动调用
	{
		// for (int i = 0; i < 10; i++) {
		// System.out.println("child" + Thread.currentThread().getName()
		// + " is running");// *
		// }
		System.out.println(Thread.currentThread().getName());
		while (t > 0) {
			System.out.println(Thread.currentThread().getName() + "  t=" + t--);
		}
	}
}

// 效果：单线程时是死循环，且只有main在运行，但是是在执*行的语句，行多线程时两个线程交替运行
// 命令行下用ctrl+c终止