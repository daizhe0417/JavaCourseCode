package cn.daizhe.javacourse.lecture.ch4.C405;

//关于String类
public class ReadLine {
	public static void main(String args[]) {
		int x=10;
		
		Integer xx=new Integer(x);
		
		String ss=String.valueOf(x);
		
		String sss=xx.toString();
		
		Integer xxx=new Integer(sss);
		
		double dd=3.14;
		
		Double ddd=new Double(dd);
		
		ddd.doubleValue();
		
		
		// byte buf[]=new byte[1024];
		char buf[] = new char[1024];// 字符数组，长度1024
		String strInfo = null;// 字符串型引用
		int pos = 0;
		int ch = 0;
		System.out.println("please inmput info,input exit for exit:");
		while (true) {
			try {
				ch = System.in.read();// 接收数据
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			switch (ch) {
			case '\r':// 回车
				// System.out.print("this is r");
				// break;
			case '\n':// 换行
				// 用字符数组创建字符串，buf表示字符数组，0表示起始位置，pos表示长度
				// System.out.print("this is n");
				strInfo = new String(buf, 0, pos);
				if (strInfo.equals("exit"))
					return;
				else
					System.out.println(strInfo);
				pos = 0;
				break;
			default:
				// buf[pos++]=(byte)ch;
				buf[pos++] = (char) ch;
			}
		}
	}
}