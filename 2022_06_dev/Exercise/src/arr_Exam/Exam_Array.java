package arr_Exam;

public class Exam_Array {

	public static void main(String[] args) {
		int[] kors = new int[3];
		kors[0] = 10;
		kors[1] = 20;
		kors[2] = 30;
		System.out.println("첫번째: "+ kors[0] + " 두번째 : "+ kors[1]+" 세번째 : "+kors[2]);
		System.out.println("배열의 크기 : "+ kors.length);
		System.out.println();
		int [] engs = {50,66,70};
		System.out.println("첫번쨰 : "+ engs[0] + " 두번째: "+ engs[1] + " 세번째 : " + engs[2]);
			for (int i =0; i <3; i++) {
				System.out.println("배열의 값 " +engs[i] );
			}
			for(int i=0; i<3; i++) {
				engs[i] = 51+i;
				
			}
			System.out.println("첫번쨰 : "+engs[0] + " 두번째 : " + engs[1] + " 새번째 : " +engs[2] );

	
	
	}
	
}
