package test1;

public class Test0214 {
	long sum(int[] a) {
		long ans = 0;
		for(int i=0; i<a.length;i++) {
			ans += a[i];
		}
		return ans;
	}

}
