package com.kh.javaapi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Exam_Caleander {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);

		SimpleDateFormat trans = new SimpleDateFormat("yyyy년 mm월 dd일 HH시 mm분 ss초");
		String strDate = trans.format(date);
		System.out.println(strDate);

		Calendar today = Calendar.getInstance();
		// Caleander 추상클래스 -> 나라마다 다르게 사용하라고 추상클래스임
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		int day = today.get(Calendar.DATE);
		int ampm = today.get(Calendar.AM_PM);
		int hour = today.get(Calendar.HOUR_OF_DAY);
		int min = today.get(Calendar.MINUTE);
		int sec = today.get(Calendar.SECOND);
		
		String sAmPm= (ampm== Calendar.AM) ? "AM" : "PM";
		
		System.out.printf("%d년 %d월 %d일 \n%s %d:%d:%d", year, month, day, sAmPm, hour, min, sec);
		System.out.println();
		
		
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			System.out.println(calendar.getTime());
			String changed = trans.format(calendar.getTime());
			System.out.println("changed : "+ changed);
	}
}
