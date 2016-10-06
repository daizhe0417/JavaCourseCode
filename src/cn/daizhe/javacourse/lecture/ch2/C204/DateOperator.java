package cn.daizhe.javacourse.lecture.ch2.C204;

/**
 * 日期操作类
 * 
 * @author venice
 * @version :2012-02-25
 */
public class DateOperator {

	/**
	 * 返回日期之间的间隔
	 * 
	 * @param type
	 *            间隔的类型，y,m,d等
	 * @param startTime
	 *            开始时间，格式2012-02-02
	 * @param endTime
	 *            结束时间，格式2012-02-02
	 * @return
	 */
	public static int dateDiff(String type, String startTime, String endTime) {
		int result = 0;
		String startStr[] = startTime.split("-");
		String endStr[] = endTime.split("-");
		try {
			int sYear = Integer.parseInt(startStr[0]), sMonth = Integer
					.parseInt(startStr[1]), sDay = Integer
					.parseInt(startStr[2]);
			int eYear = Integer.parseInt(endStr[0]), eMonth = Integer
					.parseInt(endStr[1]), eDay = Integer.parseInt(endStr[2]);

			int sdays = 0, edays = 0;

			if (sYear > 2000) {
				for (int i = 2001; i < sYear; i++) {
					if (isLeapYear(i)) {
						sdays += 366;
					} else {
						sdays += 365;
					}
				}
			} else {
				for (int i = sYear; i <= 2000; i++) {
					if (isLeapYear(i)) {
						sdays -= 366;
					} else {
						sdays -= 365;
					}
				}
			}

			for (int i = 1; i < sMonth; i++) {
				if (i == 2) {
					if (isLeapYear(sYear)) {
						sdays += 29;
					} else {
						sdays += 28;
					}
				} else if (isBigMonth(i)) {
					sdays += 31;
				} else {
					sdays += 30;
				}
			}
			sdays += sDay;

			if (eYear > 2000) {
				for (int i = 2001; i < eYear; i++) {
					if (isLeapYear(i)) {
						edays += 366;
					} else {
						edays += 365;
					}
				}
			} else {
				for (int i = eYear; i <= 2000; i++) {
					if (isLeapYear(i)) {
						edays -= 366;
					} else {
						edays -= 365;
					}
				}
			}
			for (int i = 1; i < eMonth; i++) {
				if (i == 2) {
					if (isLeapYear(eYear)) {
						edays += 29;
					} else {
						edays += 28;
					}
				} else if (isBigMonth(i)) {
					edays += 31;
				} else {
					edays += 30;
				}
			}
			edays += eDay;

			result = edays - sdays;

		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 返回指定日期的前一月
	 * @param riqi
	 * @return
	 */
	public static String getPreMonth(String riqi) {
		String preMonth = "";
		int year = 0;
		int month = 0;
		try {
			year = Integer.parseInt(riqi.substring(0, 4));
			month = Integer.parseInt(riqi.substring(5, 7));
		} catch (NumberFormatException e) {
			return preMonth;
		}
		year = year - 1 + (month - 1 + 12) / 13;
		month = month == 1 ? 12 : (month - 1);
		preMonth = String.valueOf(year) + "-" + (month < 10 ? "0" : "")
				+ String.valueOf(month);
		return preMonth;
	}

	/**
	 * 返回指定日期的下一月
	 * @param riqi
	 * @return
	 */
	public static String getNextMonth(String riqi) {
		String nextMonth = "";
		int year = 0;
		int month = 0;
		try {
			year = Integer.parseInt(riqi.substring(0, 4));
			month = Integer.parseInt(riqi.substring(5, 7));
		} catch (NumberFormatException e) {
			return nextMonth;
		}
		month++;
		if (month == 13) {
			month = 1;
			year++;
		}
		nextMonth = String.valueOf(year) + "-" + (month < 10 ? "0" : "")
				+ String.valueOf(month);
		return nextMonth;
	}

	/**
	 * 返回指定日期的下一日
	 * @param riqi
	 * @return
	 */
	public static String getNextDay(String riqi) {
		String nextDay = "";
		int year = 0;
		int month = 0;
		int day = 0;
		try {
			year = Integer.parseInt(riqi.substring(0, 4));
			month = Integer.parseInt(riqi.substring(5, 7));
			day = Integer.parseInt(riqi.substring(8, 10));
		} catch (NumberFormatException e) {
			return nextDay;
		}
		day++;
		if (day == 32) {
			month++;
			day = 1;
		} else if (day == 31 && (!isBigMonth(month))) {
			month++;
			day = 1;
		} else if (day == 30 && month == 2) {
			month++;
			day = 1;
		} else if (day == 29 && month == 2 && (!isLeapYear(year))) {
			month++;
			day = 1;
		}
		if (month > 12) {
			year++;
			month = 1;
		}

		nextDay = String.valueOf(year) + "-" + (month < 10 ? "0" : "")
				+ String.valueOf(month) + "-" + (day < 10 ? "0" : "")
				+ String.valueOf(day);
		return nextDay;
	}

	/**
	 * 返回是否是大月
	 * @param month
	 * @return
	 */
	private static boolean isBigMonth(int month) {
		int[] bigmonth = { 1, 3, 5, 7, 8, 10, 12 };
		for (int i = 0; i < bigmonth.length; i++) {
			if (month == bigmonth[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 返回是否是闰年
	 * @param year
	 * @return
	 */
	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			return true;
		}
		return false;
	}

	/**
	 * 返回指定日期所在月的第一天
	 * @param riqi
	 * @return
	 */
	public static String getFirstDay(String riqi) {
		return riqi.substring(0, 7) + "-01";
	}

	/**
	 * 返回指定日期所在月的最后一天
	 * @param riqi
	 * @return
	 */
	public static String getLastDay(String riqi) {
		int month = Integer.parseInt(riqi.substring(5, 7));
		if (month == 2) {
			return riqi.substring(0, 7)
					+ "-"
					+ (isLeapYear(Integer.parseInt(riqi.substring(0, 4))) ? "29"
							: "28");
		}
		int bigmonth[] = { 1, 3, 5, 7, 8, 10, 12 };
		for (int i = 0; i < bigmonth.length; i++) {
			if (month == bigmonth[i]) {
				return riqi.substring(0, 7) + "-31";
			}
		}
		return riqi.substring(0, 7) + "-30";
	}

	public static void main(String[] args) {
		// System.out.println(DateOperator.getPreMonth("2008-01-01"));
		// System.out.println(DateOperator.getNextMonth("2008-12-01"));
		// System.out.println(DateOperator.getNextDay("2008-02-28"));
		// System.out.println(DateOperator.getNextDay("2008-01-28"));
		// System.out.println(DateOperator.getNextDay("2008-01-30"));
		// System.out.println(DateOperator.getNextDay("2008-01-31"));
		// System.out.println(DateOperator.getNextDay("2004-02-28"));
		// System.out.println(DateOperator.getNextDay("2004-02-29"));
		// System.out.println(DateOperator.getNextDay("2008-04-30"));

		System.out.println(DateOperator
				.dateDiff("", "2012-01-04", "2012-02-05"));
		System.out.println(DateOperator
				.dateDiff("", "2012-01-04", "2012-05-05"));

		System.out.println(DateOperator
				.dateDiff("", "2011-01-04", "2012-05-05"));

		System.out.println(DateOperator
				.dateDiff("", "2002-01-04", "2012-02-05"));
		System.out.println(DateOperator
				.dateDiff("", "2002-01-04", "2012-09-05"));
		System.out.println(DateOperator
				.dateDiff("", "1979-03-04", "2012-02-05"));
		System.out.println(DateOperator
				.dateDiff("", "1980-03-04", "2012-09-15"));
		// sql�������
		// select datediff(d,'2012-01-04', '2012-02-05')
		// select datediff(d,'2012-01-04', '2012-05-05')
		// select datediff(d,'2011-01-04', '2012-05-05')
		// select datediff(d,'2002-01-04', '2012-02-05')
		// select datediff(d,'2002-01-04', '2012-09-05')
		// select datediff(d,'1979-03-04', '2012-02-05')
		// select datediff(d,'1980-03-04', '2012-09-15')
		// ���
		// 32
		// 122
		// 487
		// 3684
		// 3897
		// 12026
		// 11883

	}
}
