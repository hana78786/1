package co_te;

public class average {
//	문제 설명
//
//	정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.
//	제한사항
//
//	    arr은 길이 1 이상, 100 이하인 배열입니다.
//	    arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.
	double[] arr= {1,2,3,4,5,7,8,9,10,30,200};
	double solution;
	
	public double solution() {
		double sum_arr=0;
		for(int i=0;i<arr.length;i++) {
			sum_arr+=arr[i];
		}

		double solution=sum_arr/arr.length;	
		System.out.println(solution);
		return solution;
		
	}

	public static void main(String[] args) {
		average av=new average();
		av.solution();

	}

}
