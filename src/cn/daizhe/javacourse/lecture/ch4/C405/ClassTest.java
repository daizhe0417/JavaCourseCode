package cn.daizhe.javacourse.lecture.ch4.C405;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import expe.ch2.EmployeeModel;

public class ClassTest {
	public void save(Object o){
		String sql="insert ";
		sql+=o.getClass().getName();
		Field[] fields = o.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
//			System.out.println(fields[i].getName());
			sql+=" "+fields[i].getName()+",";

		}
	}
	public static void main(String args[]) {
		try {
			EmployeeModel em = new EmployeeModel();
			em.setYgno("1234");
			
//			Comparable c;
//			c.compareTo(cc);
			
			
			// em.getClass();
			Class c = Class.forName("expe.ch2.EmployeeModel");
			Constructor[] cons = c.getDeclaredConstructors();
			Class[] params = cons[0].getParameterTypes();// 察看构造器的参数信息
			Object[] paramValues = new Object[params.length];// 构建数组传递参数
			for (int i = 0; i < params.length; i++) {
				if (params[i].isPrimitive()) {// 判断class对象表示是否是基本数据类型
					paramValues[i] = new Integer(i);
				} else {
					paramValues[i] = "";
				}
			}
			Object o = cons[0].newInstance(paramValues);// 创建一个对象的实例

			Method[] ms = c.getDeclaredMethods();// 调用方法
//			em.getYgno();
			ms[0].invoke(o, null);// 用指定的参数调用（output方法没有参数，null）
//			o.ms[0]();
			Field[] fields = c.getDeclaredFields();
			String sql="insert ";
			sql+=em.getClass().getName();
			for (int i = 0; i < fields.length; i++) {
//				System.out.println(fields[i].getName());
				sql+=" "+fields[i].getName()+",";

			}
			System.out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
