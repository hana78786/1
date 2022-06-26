package Exam;

public class wrapper {

	public wrapper() {
		
	}
	public static void main(String[] args ) {
		Integer num = new Integer(3);
//		Interger num = 3;

		int n = num.intValue();
//		int n = num;

		
	    byte B = Byte.parseByte("1");
	    Short B1 = Short.parseShort("1");
	    int i = Integer.parseInt("1");
	    long l = Long.parseLong("9999999");
	    float f = Float.parseFloat("3.14");
	    double d = Double.parseDouble("3.14");
	    boolean b = Boolean.parseBoolean("true");
	    char c = "abc".charAt(0);

	    String b1 = Byte.valueOf((byte)1).toString();
	   String s = Short.valueOf((short)1).toString();
	    String i1 = Integer.valueOf(1).toString();
	    String l1 = Long.valueOf(9999999).toString();
	   String f1 = Float.valueOf((float) 3.14).toString();
	    String d1 = Double.valueOf(3.14).toString();
	    String c1 = Character.valueOf('a').toString();
	    String boo=Boolean.valueOf(true).toString();
	    
	 System.out.println(B);
	 System.out.println(B1);
	 System.out.println(i);
	 System.out.println(l);
	 System.out.println(f);
	 System.out.println(d);
	 System.out.println(b);
	 System.out.println(c);
	 
	 System.out.println(b1); System.out.println(s); System.out.println(i1); System.out.println(l1); 
	 System.out.println(f1); System.out.println(d1); System.out.println(c1); System.out.println(boo);
	 
		
	}

}
