package cn.daizhe.javacourse.lecture.ch7.C702;

/**
 * 同步问题，生产者-消费者例子，未采用同步机制，可能出现发送和接收不同步的现象，如连续收到多个“1”
 * 
 * @author daizhe
 * @version 2013
 */
public class PCTest {
	public static void main(String args[]) {
		Buffer buffer = new Buffer();
		(new Sender(buffer)).start();// 生产者线程
		(new Receiver(buffer)).start();// 消费者线程
	}
}

// 缓冲区
class Buffer {

	private int value; // 共享变量

	// “存”方法
	public void put(int i) {
		value = i;
	}

	// “取”方法
	public int get() {
		return value;
	}
}

// 生产者线程类
class Sender extends Thread {
	private Buffer buffer; // 用于交换数据的缓冲区

	// 构造方法中指定缓冲区
	public Sender(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		// 连续向缓冲区发送若干数据
		for (int i = 1; i < 6; i++) {
			buffer.put(i);
			System.out.println("Sender  put : " + i);
			// 强制线程sleep，模拟线程运行中被打断的现象
			try {
				sleep(10);
			} catch (InterruptedException e) {
			}
		}
	}
}

// 消费者线程类
class Receiver extends Thread {
	private Buffer buffer;// 用于交换数据的缓冲区

	// 构造方法中指定缓冲区
	public Receiver(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		// 连续从缓冲区接收若干数据
		for (int i = 1; i < 6; i++) {
			System.out.println("\t\t\tReceiver get : " + buffer.get());
			// 强制线程sleep，模拟线程运行中被打断的现象
			try {
				sleep(10);
			} catch (InterruptedException e) {
			}
		}
	}
}