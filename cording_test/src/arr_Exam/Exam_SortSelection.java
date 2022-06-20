package arr_Exam;

public class Exam_SortSelection {

	public static void main(String[] args) {
		int[] arrs = { 2, 3, 4, 1, 3 };
		int min;
		for (int i = 0; i < arrs.length; i++) {
			min = 1;
			for (int j = i + 1; j < arrs.length; j++) {
				if (arrs[min] > arrs[j]) {
					min=j;
				}
			}
			int temp=arrs[min];
			arrs[min]= arrs[i];
			arrs[i]=temp;
		}
		for(int i=0;i<arrs.length;i++) {
		System.out.println(arrs[i]);
		}
	}

}
