package cn.daizhe.javacourse.lecture.ch2.C203;

/**
 * 关于Java中的数据类型和变量常量定义
 * 
 * @author venice
 * @version 2012-02-25
 */
public class TypeTest {
	public static void main(String args[]) {

		// =================================
		// 标识符命名规则
		int _max_score = 10;// 可以下划线开头
		// int 2stName=1;//不可以数字开头

		// =================================
		// 数据的取值范围
//		 byte b=129;//赋值超过变量范围byte型-128~127
		byte b = 126;
		// double f=3.14;//3.14默认是double类型的，超出float的长度
		float f = 3.14f;

		// =================================
		// 变量的作用域
		{
			int x = 0;
			{
				// int x = 10;// 这里不能再重复定义x，这与C++不同，C++中允许在此处定义x，此时x覆盖外边的x
			}
		}

		int x = 0;// 这里可以再定义int x，27行的x的作用域只在其代码块内

		// =================================
		// 运算符的结合性
		// Java中的++运算符与C++中的区别
		int i = 1, j = 1;// 同时定义两个变量且给变量初始值
		// 注意变量的声明不一定在最开始
		i = i++;
		j = ++j;
		System.out.println("i=" + i + "   j=" + j);

		// =================================
		// 类型兼容和表达式的数据类型自动提升
//		 b=b+(byte)1;//表达式b+1中1是int型，计算结果也是int型，将int型赋值给byte型显然超限，需强制类型转换
		b = (byte) (b + 3);
		i=b;
		System.out.println("b=" + b);// 字符串与数值变量的+是连接运算，而不是相加运算
		System.out.println('b' + 1);// 字符与数值的+是加法运算

		// 输出转义字符
		final char c = '\u0009';
		int d = 1, r;
		r = d + c;// 通过，说明字符变量可以和整型变量做加法
		System.out.println("\'" + "\u0009" + "\\");
		System.out.println(r);
	}
}
