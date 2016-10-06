package cn.daizhe.javacourse.lecture.ch1.C101;

/**
 * 第一个Java程序 类声明，带有public修饰的类必须与所在文件同名
 * 
 * @author daizhe
 *
 */
// Java程序的所有语句都必须在类中

// 类声明，带有public修饰的类必须与所在文件同名
public class Hello {
	// 可以运行的java程序要包含main函数，main含义也需要存在于某个类中
	public static void main(String args[]) {
		System.out.println("Hello World!");
	}
}
/*
 * 编译和运行方法： 1、先编译：执行下面命令 javac Hello.java 生成Hello.class字节码文件 2、再运行：执行下面命令 java
 * Hello 注意不是Hello.class
 * 
 * 可能出现的错误： 1、javac或者java不是内部或外部命令 path环境变量设置有误 2、NoDefClassFoundError
 * 要执行的字节码文件路径或文件名有误
 * 
 * 解决办法请参考课件的jdk安装和配置部分
 */