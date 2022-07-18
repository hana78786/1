package javaApi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calender {
	public static void main(String[] args) {
		//일반 달력 출력하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date();
			String a=	sdf.format(date);
		System.out.println(a);
		
		//캘린더 메소드로 달력 출력하기
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day= cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int am_pm=cal.get(Calendar.AM_PM);
		String ap= (am_pm==Calendar.AM)? "Am":"Pm";
		
		System.out.println(year+"-"+month+"-"+day+" "+hour+":"+min+" "+ap);
	
		

		
		
		//그레고리안 달력으로 출력하기
	
		Calendar cal1 = new GregorianCalendar();
	
		
		
		System.out.println(sdf.format(cal.getTime()));
		
		
		
		
		
				
		
	}

}
