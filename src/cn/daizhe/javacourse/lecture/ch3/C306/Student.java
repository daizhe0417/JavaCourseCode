package cn.daizhe.javacourse.lecture.ch3.C306;

public class Student extends Person{
	private String name;
	private String number;
	private String speciality;
	private static int count=0;
	private static int max=0;
	
	public Student(String name,MyDate birthday,String spec){
		// 如果有super调用父类构造方法，必须在第一行
		super(name,birthday);
		this.name=name;
		super.name=name;
		this.speciality=spec;
		this.count++;
	}
	public Student(String name,MyDate birthday){
		this(name,birthday,"");
	}
	public Student(String name){
		this(name,new MyDate(),"");
	}
	public Student(){
		this("",new MyDate(),"");
	}
	public Student(Person p,String spec){
		this(p.name,p.birthday,spec);
	}
	public Student(Student s){
		this(s.name,s.birthday,s.speciality);
	}
	public void finalize(){
		super.finalize();
		this.count--;
	}
	public void set(String name,MyDate birthday,String spec){
		super.set(name, birthday);
		this.setSpeciality(spec);
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	//public String toString(){}
	
	public String toString(){
		return super.toString()+"Stu.toString";
	}
//	public String toString(String str){
//		return number+","+name+","+birthday.toString()+","+speciality+"专业";
//	}
	public static void howMany(){
		Person.howMany();
		System.out.println(count+"个student对象");
	}
	public static void main(String args[]){
		Person p1=new Person("李小明",new MyDate(1979,3,15));
		Student s1=new Student(p1,"计算机");
		Student s3=new Student(s1);
		s3.set("胡东东",new MyDate(1982,4,3),"电子信息工程");
		s3.howMany();
		System.out.print("p1:"+p1+"\ns1:"+s1.toString()+"\ns2:"+s3);
		System.out.println(s1.getName()+"比"+s3.getName()+"大"+s1.olderThen(s3)+"岁");
		s1.finalize();
		Student.howMany();
		
		System.out.println("aaa:"+s3);
	}
}

