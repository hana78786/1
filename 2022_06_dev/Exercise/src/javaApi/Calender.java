package javaApi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calender {
	public static void main(String[] args) {
		//�Ϲ� �޷� ����ϱ�
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date= new Date();
		System.out.println(sdf.format(date));
		
		
		//Ķ���� �޼ҵ�� �޷� ����ϱ�
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int Month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE);
		
		System.out.println(year+"-"+Month+"-"+day);
		

		
		
		//�׷����� �޷����� ����ϱ�
		Calendar today = new GregorianCalendar();
//		today.setTime(date);
		System.out.println(sdf.format(today.getTime()));
		
		
		
		
				
		
	}

}
