package cn.daizhe.javacourse.lecture.ch7.C702;

/**
 * 多个线程共享资源方法及可能出现的错误
 * 
 * @author daizhe
 * @version 2013
 */
public class PVErrotTest {
	public static void main(String args[]) {
		// 方法一：调用线程t的start方法四次，试图使线程t执行四次
		// 结果：不行，出现异常，一个线程死亡前只能开始一次
		// TestThread t = new TestThread();
		// t.start();
		// t.start();
		// t.start();
		// t.start();
		// 方法二：创建四个线程，
		// 结果：不行，四个线程都有各自的tickets变量 //相当于四个售票口各卖了100张票
		// new TestThread().start();
		// new TestThread().start();
		// new TestThread().start();
		// new TestThread().start();
		// 方法三：创建一个目标对象t，用它创建四个线程 // 结果：可以，四个线程共享同一个目标对象的变量
		TestThread t = new TestThread();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
	}
}

class TestThread implements Runnable {// 方法三使用
	// class TestThread extends Thread {// 方法一二使用
	// 要共享的变量
	private int tickets = 100;

	public void run() {
		for (int i = 0; i < 10000; i++) {
			if (tickets > 0) {
				// 强制线程sleep，模拟线程运行中被打断的现象
				try {
					Thread.currentThread().sleep(200);
				} catch (InterruptedException e) {
				}
				// 售票：打印票号，票号减1
				System.out.println(Thread.currentThread().getName()
						+ " is saling tickets " + tickets--);
			}

		}
	}
}
/*
四个线程每次执行的情况都不一样，由虚拟机的调度决定
强制线程sleep后，可能出现票号为0，-1、-2、-3等情况
 */