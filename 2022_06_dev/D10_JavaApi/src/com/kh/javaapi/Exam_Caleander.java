package com.kh.javaapi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Exam_Caleander {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);

		SimpleDateFormat trans = new SimpleDateFormat("yyyy�� mm�� dd�� HH�� mm�� ss��");
		String strDate = trans.format(date);
		System.out.println(strDate);

		Calendar today = Calendar.getInstance();
		// Caleander �߻�Ŭ���� -> ���󸶴� �ٸ��� ����϶�� �߻�Ŭ������
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		int day = today.get(Calendar.DATE);
		int ampm = today.get(Calendar.AM_PM);
		int hour = today.get(Calendar.HOUR_OF_DAY);
		int min = today.get(Calendar.MINUTE);
		int sec = today.get(Calendar.SECOND);
		
		String sAmPm= (ampm== Calendar.AM) ? "AM" : "PM";
		
		System.out.printf("%d�� %d�� %d�� \n%s %d:%d:%d", year, month, day, sAmPm, hour, min, sec);
		System.out.println();
		
		
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			System.out.println(calendar.getTime());
			String changed = trans.format(calendar.getTime());
			System.out.println("changed : "+ changed);
	}
}
