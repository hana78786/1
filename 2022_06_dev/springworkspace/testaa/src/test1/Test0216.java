package test1;



public class Test0216 {
	public static void main(String[] args) {

		int n = 0;
		String b = String.valueOf(1000);
		while(n<1000) {
			int[] c = new int[b.length()];
			for(int i=0;i<c.length;i++) {
				c[i]=Integer.parseInt(b.substring(i, i+1));
			}
			for(int i=0; i<c.length; i++) {
				n+=c[i];
				System.out.println(n);
			}
		}
	}
	

}
