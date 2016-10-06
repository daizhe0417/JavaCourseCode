package cn.daizhe.javacourse.lecture.ch9.C901;

import java.io.*;

public class ByteFile {
	private String filename; // 文件名
	
	// 构造方法，指定文件名
	public ByteFile(String filename) {
		this.filename = filename;
	}

	// 将缓冲区数据写入指定文件
	public void writeToFile(byte[] buffer) throws IOException {
		FileOutputStream fout = new FileOutputStream(this.filename); // 为指定文件创建文件输出流对象
		fout.write(buffer); // 将指定字节缓冲区中数据写入输出流
		fout.close(); // 关闭输出流

		System.out.println("Write to File " + this.filename);
	}

	// 将指定文件中的数据读到缓冲区
	public void readFromFile() throws IOException {
		FileInputStream fin = new FileInputStream(this.filename); // 为指定文件创建文件输入流对象
		System.out.println("readFromFile " + this.filename);
		byte[] buffer = new byte[512]; // 字节缓冲区
		int count = 0;
		do {
			count = fin.read(buffer); // 读取输入流
			System.out.println("count = " + count);
			for (int i = 0; i < count; i++)
				System.out.print(buffer[i] + "  ");
			System.out.println();
		} while (count != -1); // 输入流未结束时
		fin.close(); // 关闭输入流
	}

	// 复制文件
	// 将当前文件内容复制到filename2指定文件中，append指定添加或重写方式
	public void copyFile(String filename2, boolean append) throws IOException {

		FileInputStream fin = new FileInputStream(this.filename); // 创建文件输入流对象
		FileOutputStream fout = new FileOutputStream(filename2, append); // 创建文件输出流对象

		byte[] buffer = new byte[512]; // 字节缓冲区
		int count = 0;
		do {
			count = fin.read(buffer); // 读取输入流
			if (count != -1)
				fout.write(buffer); // 写入输出流
		} while (count != -1);
		fin.close(); // 关闭输入流
		fout.close(); // 关闭输出流

		System.out.println("Copyfile from " + this.filename + " to "
				+ filename2);
	}

	// 重写方式复制文件，方法重载
	public void copyFile(String filename2) throws IOException {
		copyFile(filename2, false);
	}

	public static void main(String args[]) throws IOException {
		byte[] buffer1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] buffer2 = "大家好testing file input and output stream".getBytes();
		ByteFile aFile = new ByteFile("ByteFile1.dat");
		aFile.writeToFile(buffer1);
		aFile.readFromFile();
		aFile.copyFile("ByteFile2.dat");
		aFile.copyFile("ByteFile2.txt");

		ByteFile bFile = new ByteFile("ByteFile1.txt");
		bFile.writeToFile(buffer2);
		bFile.readFromFile();
		bFile.copyFile("ByteFile2.txt", true);

	}
}
