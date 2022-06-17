package co_te;

import java.util.List;

public class small_Num {

	public static void main(String[] args) {
//		정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, 
//		solution을 완성해주세요. 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
//		예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
		int arr[] = { 8, 9, 1 };
		int[] arr1 = new int[arr.length];
		int min = arr[0];
		int[] arr2 = new int[arr.length - 1];
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == min) {
				arr[j] = arr[j++];
			}

			arr1[j] = arr[j];
		}
		System.out.println(arr1[0]);
		System.out.println(arr1[arr1.length - 1]);
		for (int k = 0; k < arr.length - 1; k++) {
			arr2[k] = arr1[k];
		}
		System.out.println(arr2[0]);
		System.out.println(arr2[(arr2.length-1)]+" "+(arr2.length));

	}
}
