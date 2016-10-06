package cn.daizhe.javacourse.lecture.ch4.C405;

public class RuntimeTest {
	public String getinfo(Object obj) {
		String result = "值为 " + obj.toString();
		if (obj instanceof Integer) {
			Integer intobj = (Integer) obj;
			int i = intobj.intValue();
			result += "  二进制值为 " + Integer.toBinaryString(i) + "  十六进制值为 "
					+ Integer.toHexString(i) + "\n";
		}

		result += "  本类为 " + obj.getClass().getName() + "  父类为 "
				+ obj.getClass().getSuperclass().getName() + "  包为 "
				+ obj.getClass().getPackage().getName() + "\n";

		result += "  操作系统为 " + System.getProperty("os.name") + "  Java版本为 "
				+ System.getProperty("java.vm.version") + "\n";

		result += "  内存总量为 " + Runtime.getRuntime().totalMemory() + "  剩余空间为 "
				+ Runtime.getRuntime().freeMemory() + "\n";

		return result;
	}

	public static void main(String args[]) {
		RuntimeTest rt = new RuntimeTest();
		System.out.println(rt.getinfo(new Integer(123)));
		System.out.println(rt.getinfo(new String("abc")));
	}
}

/*
 * 程序运行结果如下：
 * 
 * 值为 123 二进制值为 1111011 十六进制值为 7b 本类为 java.lang.Integer 父类为 java.lang.Number 包为
 * java.lang 操作系统为 Windows XP Java版本为 1.5.0-b64 内存总量为 2031616 剩余空间为 1771272
 * 
 * 值为 abc 本类为 java.lang.String 父类为 java.lang.Object 包为 java.lang 操作系统为 Windows
 * XP Java版本为 1.5.0-b64 内存总量为 2031616 剩余空间为 1760464
 */