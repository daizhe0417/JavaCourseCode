package cn.daizhe.javacourse.lecture.ch9.C901;

import java.io.*;

public class KeyboardInput {
	// 抛出异常交由Java虚拟机处理
	public static void main(String args[]) throws IOException {
		System.out.print("Input: ");
		byte buffer[] = new byte[512]; // 以字节数组作为缓冲区
		int count = System.in.read(buffer); // 从标准输入流中读取若干字节到指定缓冲区，返回实际读取的字节数

		System.out.print("Output1: ");
		for (int i = 0; i < count; i++)
			// 按字节方式输出buffer元素值
			System.out.print(" " + buffer[i]);
		System.out.println();

		System.out.print("Output2: ");
		for (int i = 0; i < count; i++)
			// 按字符方式输出buffer元素值
			System.out.print((char) buffer[i]);

		System.out.print("Output3: ");
		System.out.println(new String(buffer, 0, count));
		// 按字符串方式输出

		System.out.println("count = " + count); // 实际读取的字节数
	}
}
