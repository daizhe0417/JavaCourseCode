package cn.daizhe.javacourse.lecture.ch7.C701;

public class DaemonDemo {
	public static void main(String args[]) {
		// 创建目标对象，该对象必须实现Runnable接口
		DaemonThread t = new DaemonThread();
		// 创建Thread类实例，即创建线程
		Thread tt = new Thread(t);
		// setDaemon方法使该线程成为后台线程
//		tt.setDaemon(true);
		System.out.println(Thread.currentThread().getName() + " start!");
		// 线程开始运行
		tt.start();
//		try {
//			System.in.read(); // 接受输入，使程序在此停顿，一旦接收到用户输入，main线程结束，守护线程自动结束
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
		System.out.println(Thread.currentThread().getName() + " end!");
	}
}

// 产生目标对象的类，实现了Runnable接口
class DaemonThread implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.currentThread();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " is running" + i);
		}
	}
}