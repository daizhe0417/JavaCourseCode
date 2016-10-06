package cn.daizhe.javacourse.lecture.ch9.C901;

import java.io.*;

public class IntFile {
	private String filename;

	public IntFile(String filename) {
		this.filename = filename;
	}

	// 将Fibonacci序列值写入指定文件
	public void writeToFile() throws IOException {
		FileOutputStream fout = new FileOutputStream(this.filename);
		DataOutputStream dout = new DataOutputStream(fout);

		int i = 0, j = 1, count = 0;
		while (count < 20) {
			dout.writeInt(i); // 向输出流写入一个整数
			dout.writeInt(j);
			i = i + j;
			j = i + j;
			count += 2;
		}
		dout.close(); // 先关闭数据流
		fout.close(); // 再关闭文件流
		System.out.println("Write Fibonacci to File " + this.filename);
	}

	// 从指定文件中读取整数
	public void readFromFile() throws IOException {
		FileInputStream fin = new FileInputStream(this.filename);
		DataInputStream din = new DataInputStream(fin);

		System.out.println("readFromFile " + this.filename);

		while (true)
			// 输入流未结束时
			try {
				int i = din.readInt(); // 从输入流中读取一个整数
				System.out.print(i + "  ");
			} catch (EOFException ioe) {
				break;
			}

		System.out.println();
		din.close(); // 先关闭数据流
		fin.close(); // 再关闭文件流
	}

	public static void main(String args[]) throws IOException {
		IntFile afile = new IntFile("FibIntFile.dat");
		afile.writeToFile();
		afile.readFromFile();
	}
}