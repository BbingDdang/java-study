package chapter04;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		//printDate01(now);
		printatDate02(now);

	}

	private static void printDate01(Date now) {
		// 2024-02-29 13:10:20 format
		//SimpleDataFormat sdf = new SimpleDataFormat("yyyy-MM-dd hh:mm:ss");
//		sdf.format(now);
//		String date = sdf.format(now);
//		System.out.println(date);
		
	}
	
	private static void printatDate02(Date now) {
		// 년도(+1990)
		int year = now.getYear();
		// 월(0~11, +1)
		int month = now.getMonth();
		// 일
		int date = now.getDate();
		// 시
		int hour = now.getHours();
		// 분
		int minute = now.getMinutes();
		// 초
		int seconds = now.getSeconds();
		System.out.println("2024-10-04- 11:11:11");
		System.out.println(
				(year + 1900) + "-" +
				(month + 1) + "-" +
				date + " " + 
				hour + ":" + 
				minute + ":" +
				seconds);
	}

}
