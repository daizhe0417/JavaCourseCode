package cn.daizhe.javacourse.lecture.ch7.C701;

/**
 * 用Thread类的子类创建线程方法二
 * 
 * @author daizhe
 * @version 2013
 */
public class ThreadDemo2 {
	public static void main(String args[]) {
		// 创建目标对象，要求创建目标对象的类实现Runnable接口
		TestThread2 tt = new TestThread2();
		// 创建线程用目标对象创建线程
		Thread t1 = new Thread(tt);
		Thread t2 = new Thread(tt);
		Thread t3 = new Thread(tt);
		Thread t4 = new Thread(tt);
		// 设置线程优先级，10最高1最低
		t1.setPriority(10);
		// t.setPriority(1);
		t1.start();// 线程开始执行
		t2.start();
		t3.start();
		t4.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("main " + Thread.currentThread().getName() + " is running");
		}
	}
}

// 创建目标对象的类实现Runnable接口
class TestThread2 implements Runnable {

	int t = 10;

	// 实现Runnable接口中的方法
	// run方法在start方法使线程开始运行后自动调用
	public void run() {
		System.out.println(Thread.currentThread().getName());
		while (t > 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "  t=" + t--);
		}
	}
}
// 效果：两个线程交替运行
// 命令行下用ctrl+c终止