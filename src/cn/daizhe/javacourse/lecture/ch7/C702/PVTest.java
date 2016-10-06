package cn.daizhe.javacourse.lecture.ch7.C702;

/**
 * 线程互斥方法
 * 
 * @author daizhe
 * @version 2013
 */
public class PVTest {

	public static void main(String args[]) {
		PVTestThread t = new PVTestThread();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
	}
}

class PVTestThread implements Runnable// extends Thread
{
	String str = "";
	private Integer tickets = 100;

	// 代码块同步时用该句创建一个对象作为监视器

	public void run() {
		for (int i = 0; i < 10000; i++) {
			// 代码块同步时用该句说明需同步的代码块
			synchronized (this) {
				if (tickets > 0) {
					// 用sleep方法模拟判断后没来得及售出即轮到下一线程执行
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
					// 售票：打印票号，票号减1
					System.out.println(Thread.currentThread().getName()
							+ " is saling tickets " + tickets--);
				}
			}
		}
	}
}