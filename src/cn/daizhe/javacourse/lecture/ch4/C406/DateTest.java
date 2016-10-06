package cn.daizhe.javacourse.lecture.ch4.C406;

import cn.daizhe.javacourse.lecture.ch3.C306.MyDate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public String toString(){
//		Date d=new Date();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
		.format(new Date()));

		Calendar now=Calendar.getInstance();
		int year=now.get(Calendar.YEAR);
		int month=now.get(Calendar.MONTH)+1;
		now.set(year,month-1, 1);
		int week=now.get(Calendar.DAY_OF_WEEK)-1;
		String str=year+"年"+month+"月的月历\n	日	一	二	三	四	五	六\n";
//		str+=String.format("%1c", " ");
		for(int i=0;i<week;i++){
			str+="\t ";
		}
		int days= MyDate.daysOfMonth(year, month);
		for(int i=1;i<=days;i++){
//			str+=String.format("%4d",i);
			str+="\t"+i;
			if((week+i)%7==0){
				str+="\n";
			}
		}
		return str;
	}

	public static void main(String args[]) {
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd日EEEEE a hh时mm分ss秒");
		System.out.println(sdf.format(new Date()));
		System.out.println(new DateTest().toString());
	}
}
