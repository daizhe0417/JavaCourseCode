package cn.daizhe.javacourse.lecture.ch7.C701;

public class NumberRunnable implements Runnable {

	private int first;

	public NumberRunnable(int first) {
		super();
		this.first = first;
	}

	public NumberRunnable() {
		this(0);
	}

	@Override
	public void run() {
		System.out.println();
		for (int i = first; i < 50; i += 2) {
			System.out.print(i + " ");
			try {
				Thread.currentThread().sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("结束！");
	}

	public static void main(String args[]) {
		new Thread(new NumberRunnable(2), "偶数线程").start();
		NumberRunnable odd = new NumberRunnable(1);
		Thread thread_odd = new Thread(odd, "奇数线程");
		thread_odd.setPriority(10);
		thread_odd.start();
	}
}
