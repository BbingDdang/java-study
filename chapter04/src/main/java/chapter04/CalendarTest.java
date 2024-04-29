package chapter04;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarTest {

	public static void main(String[] args) {
		
		// locale & Timezone 지정 해주면 한국달력 return , (ko_KR, UTF-8)
		//Calendar cal = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
//		Locale aLocale = Locale.getDefault(Locale.Category.FORMAT);
//		TimeZone tz = TimeZone.getDefault();
//		System.out.println(aLocale + ":" + tz);
		printDate(cal);
		
		cal.set(Calendar.YEAR, 2024);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DATE, 25);
		printDate(cal);
		
		cal.set(2024, 05, 12);
		cal.add(Calendar.DATE, -100);
		printDate(cal);
		
		
		
	}

	private static void printDate(Calendar cal) {
		final String[] DAYS = {"일", "월", "화", "수", "목", "금", "토"};
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); // 1(sun) ~ 7(sat) , sunday first
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(
				(year) + "년 " +
				(month + 1) + "월 " +
				date + "일 " +
				DAYS[day-1] + "요일 " +
				hour + "시 " + 
				minute + "분 " +
				second + "초");
	}

}
