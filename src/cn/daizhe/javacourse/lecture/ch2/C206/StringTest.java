package cn.daizhe.javacourse.lecture.ch2.C206;

/**
 * 字符串的使用，包括声明和创建，字符串运算，字符串类的常用方法，equals和==
 * 
 * @author venice
 * @version 2012-03-05
 */
public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// =================================
		// 字符串的声明及使用

		// 声明并创建字符串变量
		String str1;
		str1 = new String("abc");

		// 声明和创建同时完成，用构造方法
		String str2 = new String("cde");

		// 声明时赋初值
		String str3 = "fgh";

		// 从字符数组创建字符串
		char c[] = { 'i', 'l', 'k' };
		String str4 = new String(c);

		// =================================
		// 字符串运算

		// 赋值运算
		str4 = "abc";
		String str5 = str3;

		// 字符串的连接运算
		String strall = str1 + str2;

		// Java中字符串不是字符数组，下面语句语法错误
		// str4[1] = 'b';

		// =================================
		// 字符串类的常用方法

		// 返回字符串最后两个字符
		String str6 = "Hello and test method of String class";
		System.out.println("返回最后两个字符:"
				+ str6==null&&str6.equals("")?"":str6.substring(4,8));
		// 返回字符串指定位置的字符
		System.out.println("返回字符串指定位置的字符" + str6.charAt(10));

		System.out.println(str6.endsWith("ass"));
		System.out.println(str6.startsWith("ass"));
		System.out.println(str6.contains("ass"));
		
		// 以指定字符分割字符串
		String s6[] = str6.split(";");
		System.out.println("以指定字符分割字符串");
		for (int i = 0; i < s6.length; i++) {
			System.out.println(s6[i]);
		}

		// 格式化字符串
		System.out.println(String.format("格式化字符串：%14d", 10));

		// =================================
		// Java中的equals和==
		String s = "hello";
		String t = "hello";
		char cc[] = { 'h', 'e', 'l', 'l', 'o' ,'\\','0'};
		
		System.out.println("equals and ==");

		System.out.println("s.equals(t): "+s.equals(t));// 
		System.out.println("t.equals(cc): "+t.equals(cc));// 
		System.out.println("t.equals(new String(\"hello\")): "+t.equals(new String("hello")));
		System.out.println("s == t: "+(s == t));// s和t指向同一对象，这是编译器优化的结果
 
		// 实际上两个引用指向不同对象时，==的结果应该是false，只有两个引用指向同一个对象时==才返回true
		// 而equals是判读两个对象的内容是否相同
		Person p1 = new Person("张三","139"), p2 = new Person("张三","151");
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		if(p1==null){
			
		}
	}
}

/**
 * 测试用类，包括构造方法，equals方法
 * 
 * @author venice
 * @version 2012-03-05
 */
class Person {
	private String name;
	private String mobile ;

	Person() {
		this.name = "";
	}

	Person(String name) {
		this.name = name;
	}
	
	Person(String name,String mobile) {
		this.name = name;
		this.mobile=mobile;
	}

	public boolean equals(Person p) {
		if (this.name.equals(p.name)&&this.mobile.equals(p.mobile)) {
			return true;
		}
		return false;
	}
}
