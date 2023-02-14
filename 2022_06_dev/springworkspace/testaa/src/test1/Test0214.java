package test1;

public class Test0214 {
	long sum(int[] a, int n) {
		long ans = 0;
		for(int i=0; i<n;i++) {
			ans += a[i];
		}
		return ans;
	}

}
