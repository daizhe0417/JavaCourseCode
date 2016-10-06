package cn.daizhe.javacourse.lecture.ch9.C903;

import java.io.*;

public class SendCard // 发牌程序
{
	public SendCard(int n) throws IOException // n指定多少人玩牌
	{
		PipedInputStream[] in = new PipedInputStream[n]; // 管道输入流对象数组
		PipedOutputStream[] out = new PipedOutputStream[n]; // 管道输出流对象数组

		for (int i = 0; i < in.length; i++) {
			in[i] = new PipedInputStream(); // 创建一个管道输入流对象
			out[i] = new PipedOutputStream(in[i]); // 创建一个管道输出流对象并建立连接
		}

		new Sender(out, 12).start(); // 启动一个发送线程
		for (int i = 0; i < in.length; i++)
			// 启动多个接收线程
			new Receiver(in[i]).start();
	}

	public SendCard() throws IOException {
		this(4); // 默认是4个人玩牌
	}

	public static void main(String args[]) throws IOException {
		new SendCard(); // 4个人玩牌
	}
}

class Sender extends Thread // 发送线程
{
	private PipedOutputStream[] out;
	private int max;

	public Sender(PipedOutputStream[] out, int max) {
		this.out = out;
		this.max = max; // 最大牌数
	}

	public Sender(PipedOutputStream[] out) {
		this(out, 52);
	}

	public void run() // 线程体
	{
		System.out.print("Sender:  ");
		int k = 1;
		try {
			while (k <= this.max) {
				for (int i = 0; k <= this.max && i < out.length; i++) {
					this.out[i].write(k);
					System.out.print(k + "  ");
					k++;
				}
			}

			for (int i = 0; i < out.length; i++)
				this.out[i].close(); // 关闭管道输出流
			System.out.println();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}

class Receiver extends Thread // 接收线程
{
	private PipedInputStream in;

	public Receiver(PipedInputStream in) {
		this.in = in;
	}

	public void run() {
		System.out.print("Receiver: " + this.getName() + "  ");
		try {
			int i = -1;
			do // 输入流未结束时
			{
				i = this.in.read();
				if (i != -1)
					System.out.print(i + "  ");
			} while (i != -1);

			System.out.println();
			this.in.close(); // 关闭管道输入流
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}