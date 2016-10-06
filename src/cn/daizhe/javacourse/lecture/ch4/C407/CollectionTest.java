package cn.daizhe.javacourse.lecture.ch4.C407;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {
	public static void main(String args[]) {
		int b = 0;
		List al = new ArrayList();
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
				al.add(new Integer(num));
			}
		}
		int sum = 0;
		Iterator itr = al.iterator();
		while (itr.hasNext()) {
//			al.get(8);
			Integer intObj = (Integer) itr.next();
			System.out.println(intObj.toString());
			sum += intObj.intValue();
		}
		if(al!=null&&!al.isEmpty())
		for(int i=0;i<al.size();i++){
			al.get(i);
		}
		System.out.println(sum);
	}
}
