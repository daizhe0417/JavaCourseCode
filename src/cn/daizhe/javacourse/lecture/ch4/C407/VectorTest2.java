package cn.daizhe.javacourse.lecture.ch4.C407;

import java.util.Vector;

public class VectorTest2 {
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
		/*
		 * Enumeration e=v.elements(); while(e.hasMoreElements()) { Integer
		 * intObj=(Integer)e.nextElement(); sum+=intObj.intValue(); }
		 */
		for (int i = 0; i < v.size(); i++) {
			Integer intObj = (Integer) v.elementAt(i);
			sum += intObj.intValue();
		}
		System.out.println(sum);
	}
}
