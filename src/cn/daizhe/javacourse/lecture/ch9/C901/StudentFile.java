package cn.daizhe.javacourse.lecture.ch9.C901;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StudentFile {
	private String filename;

	public StudentFile(String filename) {
		this.filename = filename;
	}

	public void writeToFile() throws IOException // 向指定文件写入若干学生对象
	{
		FileOutputStream fout = new FileOutputStream(this.filename);
		ObjectOutputStream objout = new ObjectOutputStream(fout);
		objout.writeObject(new Student("杨柳")); // 写入一个对象
		objout.writeObject(new Student("明明"));
		objout.writeObject(new Student("小玲"));
		objout.close(); // 先关闭对象流
		fout.close(); // 再关闭文件流
		System.out.println("Write Student to File " + this.filename);
	}

	public void readFromFile() throws IOException // 从指定文件中读取若干学生对象
	{
		FileInputStream fin = new FileInputStream(this.filename);
		ObjectInputStream objin = new ObjectInputStream(fin);
		System.out.println("readFromFile " + this.filename);

		while (true)
			// 输入流未结束时
			try {
				Student stu = (Student) objin.readObject(); // 读取一个对象
				System.out.println(stu.getName() + "  ");
			} catch (Exception e) {
				break;
			}
		objin.close(); // 先关闭对象流
		fin.close(); // 再关闭文件流
	}

	public Student[] openFile() throws IOException // 返回从指定文件中读取的学生对象数组
	{
		FileInputStream fin = new FileInputStream(this.filename);
		ObjectInputStream objin = new ObjectInputStream(fin);

		Student[] students = new Student[20];
		int i = 0;
		while (true)
			try {
				students[i] = (Student) objin.readObject(); // 读取一个对象
				i++;
			} catch (Exception e) // 捕获IOException和ClassNotFoundException异常
			{
				break;
			}
		objin.close(); // 先关闭对象流
		fin.close(); // 再关闭文件流
		return students;
	}

	public static void main(String args[]) throws IOException {
		StudentFile afile = new StudentFile("StudentFile.dat");
		afile.writeToFile();
		afile.readFromFile();
	}
}
