package a;
public class gugudan6 {
	public static int[] calculate(int times) { //칼큘레이트를 함수 times로 지정함
		int[] result=new int[9];
		for(int i=0;i<result.length;i++) {
			result[i]=times*(i+1);
		}
		return result;
		
	}
	public static void print(int[] result) {
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}
	
	public static void main(String[]args) {
		for(int i=2;i<10;i++) {
			 int[] result=calculate(i);
			System.out.println(i+"단");
			print(result);
		}
	}
	
	}
	 

