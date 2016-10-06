package cn.daizhe.javacourse.lecture.ch3.C306;

public class Person {
	protected String name;
	protected MyDate birthday;
	private static int count = 0;

	public Person(String name, MyDate birthday) {
		this.name = name;
		this.birthday = birthday;
		count++;
	}

	public Person(String name) {
		this(name, new MyDate());
	}

	public Person() {
		this("", new MyDate());
	}

	public Person(Person p) {
		// this(p.name, new MyDate(p.birthday));
		this(p.name, p.birthday);
	}

	public void set(String name) {
		this.name = name;
	}

	public void set(MyDate birthday) {
		this.birthday = birthday;
	}

	public void set(String name, MyDate birthday) {
		this.set(name);
		this.set(birthday);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyDate getBirthday() {
		return birthday;
	}

	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}

	public String toString() {
		return "Person.toString" + this.name + "," + this.birthday.toString() + "," + this.getAge() + "岁";
	}

	public int getAge(int year) {
		return year - this.birthday.getYear();
	}

	public int getAge() {
		return getAge(MyDate.getThisYear());
	}

	public int olderThen(Person p) {
		return p.birthday.getYear() - this.birthday.getYear();
	}

	public static void howMany() {
		System.out.println(count + "个Person对象");
	}

	public void finalize() {
		System.out.println("释放对象(" + this.toString() + ")");
		this.count--;
	}

	public static void main(String args[]) {
		Person p1 = new Person("李小明", new MyDate(1979, 3, 15));
		Person p2 = new Person(p1);

		p2.set(p2.getName().substring(0, 2) + "东");

		MyDate d = p2.getBirthday();
		d.set(d.getYear() + 2, d.getMonth(), d.getDay());
		p2.set(d);

		Person.howMany();

		System.out.println("p1:" + p1.toString() + ",p2:" + p2);
		System.out.println(p1.getName() + "比" + p2.getName() + "大" + p1.olderThen(p2) + "岁");

		p1.finalize();
		p1 = null;
		System.gc();
		Person.howMany();
		System.out.println(p2.count + "");

	}
}
