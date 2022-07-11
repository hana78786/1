package javaApi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calender {
	public static void main(String[] args) {
		//일반 달력 출력하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date= new Date();
		System.out.println(sdf.format(date));
		
		
		//캘린더 메소드로 달력 출력하기
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int Month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE);
		
		System.out.println(year+"-"+Month+"-"+day);
		

		
		
		//그레고리안 달력으로 출력하기
		Calendar today = new GregorianCalendar();
//		today.setTime(date);
		System.out.println(sdf.format(today.getTime()));
		
		
		
		
				
		
	}

}
