package javaApi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calender {
	public static void main(String[] args) {
		//�Ϲ� �޷� ����ϱ�
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date();
			String a=	sdf.format(date);
		System.out.println(a);
		
		//Ķ���� �޼ҵ�� �޷� ����ϱ�
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day= cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int am_pm=cal.get(Calendar.AM_PM);
		String ap= (am_pm==Calendar.AM)? "Am":"Pm";
		
		System.out.println(year+"-"+month+"-"+day+" "+hour+":"+min+" "+ap);
	
		

		
		
		//�׷����� �޷����� ����ϱ�
	
		Calendar cal1 = new GregorianCalendar();
	
		
		
		System.out.println(sdf.format(cal.getTime()));
		
		
		
		
		
				
		
	}

}
