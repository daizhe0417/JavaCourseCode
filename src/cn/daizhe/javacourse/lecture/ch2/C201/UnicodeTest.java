package cn.daizhe.javacourse.lecture.ch2.C201;

import java.io.UnsupportedEncodingException;

/**
 * 查看Java的字符编码方式 每字符用2字节编码表示 存储时时默认UTF-8编码，英文字母占1个字节，汉字占3个字节
 * 
 * @author venice
 * @version 2012-02-25
 */
public class UnicodeTest {

	/**
	 * 将字符串转换为16进制形式
	 * 
	 * @param s
	 * @return 转换后的字符串
	 */
	public static String stringToUnicode(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			if (ch > 255)
				str += "\\u" + Integer.toHexString(ch);
			else
				str += "\\" + Integer.toHexString(ch);
		}
		return str;
	}

	/**
	 * 将char数组转换成16进制形式并输出
	 * 
	 * @param c
	 */
	public static void toHex(char[] c) {
		for (int i = 0; i < c.length; i++) {
			System.out.print(Integer.toHexString(c[i]) + "\t");
		}
	}

	/**
	 * 将byte数组转换成16进制形式并输出
	 * 
	 * @param c
	 */
	public static void toHex(byte[] c) {
		System.out.print("length:" + c.length + "\t");
		for (int i = 0; i < c.length; i++) {
			System.out.print(Integer.toHexString(c[i]) + " ");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String name = "I am 戴喆";
		System.out.println("对应的编码:");
		for (int i = 0; i < name.length(); i++) {
			System.out.print(name.charAt(i) + "\t");
		}
		System.out.println("");
		toHex(name.toCharArray());
		System.out.println("");

		try {
			System.out.println("各种存储方式的值:");
			byte[] defaultbyte = name.getBytes();
			System.out.print("默认编码方式:\t");
			toHex(defaultbyte);
			System.out.println("");
			byte[] iso8859 = name.getBytes("ISO-8859-1");
			System.out.print("iso8859-1:\t");
			toHex(iso8859);
			System.out.println("");
			byte[] gb2312 = name.getBytes("GB2312");
			System.out.print("gb2312:\t\t");
			toHex(gb2312);
			System.out.println("");
			byte[] gbk = name.getBytes("GBK");
			System.out.print("gbk:\t\t");
			toHex(gbk);
			System.out.println("");
			byte[] utf16 = name.getBytes("UTF-16");
			System.out.print("utf16:\t\t");
			toHex(utf16);
			System.out.println("");
			byte[] utf8 = name.getBytes("UTF-8");
			System.out.print("utf8:\t\t");
			toHex(utf8);
			System.out.println("");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
