package co_te;

public class arr_min {

	public arr_min() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		  int [] arr = {10,8,765,1,54,3,-85,0,-1,5,2,4};
		int a =0;
	        if(arr.length==1) {
				a=1;
			}
			else {
				a=arr.length-1;
			}
	        int[] answer = new int[a];
			int min = 0;

			for (int j = 0; j < arr.length; j++) {
			if (arr[min] > arr[j]) {
				min = j;
				} } 
			
	        System.out.println(arr[min]);
	        
	        
				for(int i=min ;i<arr.length-1;i++) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				}	
	        
				for (int i = 0; i < arr.length - 1; i++) {
				answer[i] = arr[i];	}	
	        if (a == 1) {
	            answer[0] = -1;
	        }
	        for(int i =0 ; i <answer.length;i++) {
	        System.out.println(answer[i]);
	        }
	}

}
