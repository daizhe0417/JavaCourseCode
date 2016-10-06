package cn.daizhe.javacourse.lecture.ch3.C305;

/**
 * 为什么需要类成员
 * 
 * @author venice
 * @version 2013
 */
public class StaticTest1 {
	public static void main(String args[]) {
		System.out.println("number of students:" + Student.num);

		// 创建3个学生实例，Student类中num是否是static的效果不同
//		Student s1 = new Student("zhang");
//		Student s2 = new Student("wang");
//		Student s3 = new Student("wang");
//		System.out.println("number of students:" + s1.getNum());
//		System.out.println("number of students:" + s2.getNum());
//		System.out.println("number of students:" + s3.getNum());
//		System.out.println("id of s1 is " + s1.getID());
//		System.out.println("id of s2 is " + s2.getID());
//		System.out.println("id of s3 is " + s3.getID());
	}
}

class Student {
	private int id;
	private String name;

	// 学生计数，希望每创建学生实例，num++
	// 但是不带static的情况下，num是实例成员，每个实例各自一个num
	// private int num;
	// 带static的num是类成员，所以类的实例使用同一个num
	public static int num = 0;

	public Student(String name) {
		num++;
		this.id = num;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public int getNum() {
		return num;
	}
}