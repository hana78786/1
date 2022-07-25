package arr_Exam;

public class arr_1 {

		public static void main(String[] args) {
			int[][] arr = { { 5, 5, 5, 5, 5 }, { 10, 10, 10, 10, 10 },
					{ 20, 20, 20, 20, 20 }, { 30, 30, 30, 30, 30 } };

			int total = 0;
			float average = 0;
			int sum1=0;
			float d=0;
			
			System.out.println(arr.length);
			for (int j = 0; j<arr.length;j++) {
				for (int i =0; i<arr[j].length;i++) {
					total+=arr[j][i];
					
				}
				d+=arr[j].length;
				
			}
			average=total/d;
			System.out.println("total=" + total);
			System.out.println("average=" + average);
		} // end of main

	} // end of class

//	실행결과 :
//	total=325 
//	average=16.25
//		
//	

