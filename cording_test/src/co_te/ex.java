package co_te;

public class ex {

	int[][] arr1= new int[][] {{1,2},{3,4}};
	int[][] arr2=new int[][] {{5,6},{7,8}};
	int[][] arr=add(arr1,arr2);
	
	public int[][] solution(int[][] arr1, int[][] arr2) {

		int[][] answer = {};
	        return answer;
	    }
	
	private int[][] add(int[][] arr12, int[][] arr22) {
		int length=arr12.length<arr22.length?arr12.length
				: arr2.length;
		
		for(int i=0;i<length;i++) {
			length[i]= arr1[i] + arr2[i];
		}
		return null;
	}
}
