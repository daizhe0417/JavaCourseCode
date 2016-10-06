package cn.daizhe.javacourse.lecture.ch4.C407;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
	public static void main(String args[]) {
		int b = 0;
		Vector v = new Vector();
		System.out.println("Please Enter Number:");
		while (true) {
			try {
				b = System.in.read();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			if (b == '\r' || b == '\n')
				break;
			else {
				int num = b - '0';
				v.addElement(new Integer(num));
			}
		}
		int sum = 0;
		Enumeration e = v.elements();
		while (e.hasMoreElements()) {
			Integer intObj = (Integer) e.nextElement();
			sum += intObj.intValue();
			System.out.print(intObj.intValue()+"  ");
		}
		System.out.println(sum);
	}
}
