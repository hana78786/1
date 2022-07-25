package arr_Exam;

public class Exam_ArrayCopy {

	public static void main(String[] args) {
		int arr[]= {1,2,3,4};
		int arr2[]=arr;
		arr2[2] = 0;
		System.out.println(arr[2]);
		
		int ori[] = {1,2,3,4,5,6};
		int copy[] = new int[ori.length];
		for(int i =0; i<ori.length;i++) {		
			copy[i]=ori[i];
		}
		
		copy[5]=7;
		System.out.println();
		System.out.println(copy[5]);
		System.out.println(ori[5]);
		
		
		
	}

}
