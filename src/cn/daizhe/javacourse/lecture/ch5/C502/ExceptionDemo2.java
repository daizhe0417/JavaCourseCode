package cn.daizhe.javacourse.lecture.ch5.C502;

//关于异常
import java.io.*;

class ExceptionDemo2 {
	public static void main(String args[]) // throws IOException
	{
		FileInputStream fis = null;
		// 划定程序出所可能产生的异常范围
		try {
			// System.out.println("0");
			System.out.println("first argument is:  " + args[0]);
			// System.out.println("1");
			fis = new FileInputStream(args[0]);
			// System.out.println("2");
			System.out.println("content of text is：");
			// System.out.println("3");
			int b;
			while ((b = fis.read()) != -1) {
				System.out.print((char) b);
			}
			System.out.println("4");
//		}catch (Exception e){
			
		} catch (FileNotFoundException e)
		// 捕获程序中所可能产生的各种异常
		{
			System.out.println("my exception: s" + e);
		} catch (IOException e)
		// 注意各个catch的摆放的前后位置的要求
		{
			System.out.println("my exception: " + e);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("my exception: " + e);
		} finally
		// 统一的出口
		{
			System.out.println("Finally");
			if (fis != null) {
				System.out.println("Closing file…");
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("FileInputStream not Open !");
			}
		}
		System.out.println("out");
	}
}
