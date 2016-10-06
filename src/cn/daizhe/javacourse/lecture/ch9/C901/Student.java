package cn.daizhe.javacourse.lecture.ch9.C901;

public class Student implements java.io.Serializable // 序列化
{
	private int number;
	private String name;
	private static int count = 0;

	public Student(String name) {
		this.count++;
		this.number = this.count;
		this.name = name;
	}

	public String toString() {
		return this.number + "  " + this.name;
	}
	public String getName(){
		return name;
	}
}