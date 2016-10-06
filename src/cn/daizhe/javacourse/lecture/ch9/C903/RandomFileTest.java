package cn.daizhe.javacourse.lecture.ch9.C903;

//RandomAccessFile类实例
import java.io.*;

public class RandomFileTest {
	public static void main(String args[]) throws Exception {
		Employee e1 = new Employee("wang", 23);
		Employee e2 = new Employee("zhanglin", 20);
		Employee e3 = new Employee("li", 22);
		// dos下\是路径分隔符，但必须使用转义字符
		// 绝对路径，注意使用\作为转义字符
		RandomAccessFile rf = new RandomAccessFile("text.txt", "rw");
		rf.write(e1.name.getBytes());
		rf.writeInt(e1.age);
		rf.write(e2.name.getBytes());
		rf.writeInt(e2.age);
		rf.write(e3.name.getBytes());
		rf.writeInt(e3.age);
		rf.seek(0);
		int len = 8;
		rf.skipBytes(12);
		System.out.println("第二个员工信息：");
		String str = "";
		for (int i = 0; i < len; i++)
			str = str + (char) rf.readByte();
		System.out.println("name: " + str);
		System.out.println("age  : " + rf.readInt());

		System.out.println("第一个员工信息：");
		rf.seek(0);
		str = "";
		for (int i = 0; i < len; i++)
			str = str + (char) rf.readByte();
		System.out.println("name: " + str);
		System.out.println("age  : " + rf.readInt());

		System.out.println("第三个员工信息：");
		rf.skipBytes(12);
		str = "";
		for (int i = 0; i < len; i++)
			str = str + (char) rf.readByte();
		System.out.println("name: " + str);
		System.out.println("age  : " + rf.readInt());

		rf.close();
	}
}

class Employee {
	String name;
	int age;
	final static int LEN = 8;

	public Employee(String name, int age) {
		if (name.length() > LEN) {
			name = name.substring(0, LEN);
		} else {
			while (name.length() < LEN)
				name = name + "\u0000";
		}
		this.name = name;
		this.age = age;
	}
}