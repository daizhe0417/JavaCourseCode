package cn.daizhe.javacourse.lecture.ch3.C306;

public class MyDate {
	private int year, month, day;
	private static int thisYear;
	static {
		thisYear = 2013;
	}

	public MyDate(int year, int month, int day) {
		this.set(year, month, day);
	}

	public MyDate() {
		this(1970, 1, 1);
	}

	public MyDate(MyDate d) {
		this.set(d);
	}

	public void set(int y, int m, int d) {
		this.year = y;
		this.month = ((m >= 1) & (m <= 12)) ? m : 1;
		this.day = ((d >= 1) & d <= 31) ? d : 1;
	}

	public void set(MyDate d) {
		set(d.year, d.month, d.day);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String toString() {
		return this.year + "年" + this.month + "月" + this.day + "日";
	}

	public static int getThisYear() {
		return thisYear;
	}

	public static boolean isLeapYear(int year) {
		return year % 400 == 0 || year % 100 != 0 && year % 4 == 0;
	}

	public boolean isLeapYear() {
		return isLeapYear(this.year);
	}

	public boolean equals(MyDate d) {
		return this == d || d != null && this.year == d.year
				&& this.month == d.month && this.day == d.day;
	}

	public static int daysOfMonth(int year,int month){
		switch(month){
		case 1:case 3:case 5:case 7:case 8:case 10:case 12:return 31;
		case 4:case 6:case 9:case 11:return 30;
		case 2:return isLeapYear(year)?29:28;
		default:return 0;
		}
	}

	public int daysOfMonth() {
		return daysOfMonth(this.year, this.month);
	}

	public void tomorrow() {
		this.day++;
		if (day > this.daysOfMonth()) {
			day = 1;
			month++;
			if (month > 12) {
				month = 1;
				year++;
			}
		}
	}

	public MyDate yesterday() {
		MyDate yes = new MyDate(this);
		yes.day--;
		if (yes.day == 0) {
			yes.month--;
			if (yes.month == 0) {
				yes.month = 12;
				yes.year--;
			}
			yes.day = daysOfMonth(yes.year, yes.month);
		}
		return yes;
	}

	public static void main(String args[]) {
		System.out.println("今年是：" + MyDate.getThisYear() + ",闰年？"
				+ MyDate.isLeapYear(MyDate.getThisYear()));
		MyDate d1=new MyDate(2012,3,20);
		MyDate d2=new MyDate(d1);
		System.out.println(d2+"，闰年？"+d2.isLeapYear());
		System.out.print(d2+" 的昨天是 "+d2.yesterday()+"\n"+d2+" 的明天是 ");
		d2.tomorrow();
		System.out.println(d2);
	}
}
