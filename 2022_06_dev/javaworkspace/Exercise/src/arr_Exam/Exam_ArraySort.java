package arr_Exam;

public class Exam_ArraySort {

	public static void mian(String args[]) {
		int num1 = 24;
		int num2 = 22;
		int temp = num1;
		 num2 = temp;
		 num1 = num2;
		 
		 int[] nums= {1,2,3};
		 int temp1=0;
		 temp1=nums[0];
		 nums[0]=nums[1];
		 nums[1]=nums[2];
		 nums[2]=temp1;
		
		 int[] arr= {2,5,4,1,3};
		 for(int i=1; i<arr.length;i++) {
			 for(int j=1;j>0;j--) {
				 if(arr[j-1]>arr[j]) {
				 int temp2 = arr[j-1];
				 arr[j-1]=arr[j];
				 arr[j]=temp2;
			 }
			 }
		 }

			 System.out.println(arr);
		 

		 
		 }
		 

	}

