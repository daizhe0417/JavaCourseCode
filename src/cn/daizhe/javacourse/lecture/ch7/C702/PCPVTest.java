package cn.daizhe.javacourse.lecture.ch7.C702;

/**
 * 同步问题，生产者-消费者例子，采用同步机制保证数据一致性，即不论生产者和消费者线程到达、执行的顺序和时间如何，都能保证数据依次发送和接收
 * 
 * @author daizhe
 * @version 2013
 */
public class PCPVTest {
	public static void main(String args[]) {
		BufferLock buffer = new BufferLock();
		(new Sender2(buffer)).start();// 生产者线程
		(new Receiver2(buffer)).start();// 消费者线程
	}
}

// 增加同步机制的缓冲区
// 类似于《操作系统》课程中的”管程“，同步的信号量和同步操作get、put方法都放在一个类中
class BufferLock {
	private int value; // 共享变量
	private boolean isEmpty = true; // value是否为空的信号量

	// 同步的”存“方法
	// 注意是互斥synchronized的方法,如果不互斥，也不能保证同步
	public synchronized void put(int i) {
		// 当value不空时，等待
		while (!isEmpty) {
			try {
				this.wait(); // 使调用该方法的当前线程等待，即阻塞自己
			} catch (InterruptedException e) {
			}
		}

		value = i; // 当value空时，value获得值
		isEmpty = false; // 设置value为不空状态
		notify(); // 唤醒其他等待线程
	}

	// 同步的”取“方法
	// 注意是互斥synchronized的方法,如果不互斥，也不能保证同步
	public synchronized int get() {
		// 当value空时，等待
		while (isEmpty) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}

		isEmpty = true; // 设置value为空状态，并返回值
		notify();
		return value;
	}
}

// 生产者线程类
class Sender2 extends Thread {
	private BufferLock buffer;

	public Sender2(BufferLock buffer) {
		this.buffer = buffer;
	}

	public void run() {
		for (int i = 1; i < 6; i++) {
			buffer.put(i);// 调用方法与之前一样，无需修改
			System.out.println("Sender  put : " + i);
			try {
				sleep(3);
			} catch (InterruptedException e) {
			}
		}
	}
}

// 消费者线程类
class Receiver2 extends Thread {
	private BufferLock buffer;

	public Receiver2(BufferLock buffer) {
		this.buffer = buffer;
	}

	public void run() {
		for (int i = 1; i < 6; i++) {
			int buf = buffer.get();
			System.out.println("\t\t\tReceiver get : " + buf);
			try {
				sleep(1);
			} catch (InterruptedException e) {
			}
		}
	}
}