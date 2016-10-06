package cn.daizhe.javacourse.lecture.ch4.C407;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {
	public static void main(String[] args) {

		Map map = new HashMap();

		map.put("a", "aaa");

		map.put("b", "bbb");

		map.put("c", "ccc");

		map.put("d", "ddd");

		Iterator iterator = map.keySet().iterator();

		while (iterator.hasNext()) {

			Object key = iterator.next();

			System.out.println("map.get(key) is :" + map.get(key));

		}

		Hashtable tab = new Hashtable();

		tab.put("a", "aaa");

		tab.put("b", "bbb");

		tab.put("c", "ccc");

		tab.put("d", "ddd");

		Iterator iterator_1 = tab.keySet().iterator();

		while (iterator_1.hasNext()) {

			Object key = iterator_1.next();

			System.out.println("tab.get(key) is :" + tab.get(key));

		}

		TreeMap<String,String> tmp = new TreeMap<String,String>();

		tmp.put("a", "aaa");

		tmp.put("b", "bbb");

		tmp.put("c", "ccc");

		tmp.put("d", "ddd");

		Iterator iterator_2 = tmp.keySet().iterator();

		while (iterator_2.hasNext()) {

			Object key = iterator_2.next();

			System.out.println("tmp.get(key) is :" + tmp.get(key));

		}

	}
}
