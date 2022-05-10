package co_te;

public class hashad {


	
    public boolean solution(int x) {
    	String str_x=Integer.toString(x);
        int a=str_x.length();
     String[] y = new String[a];
		for(int i=0;i<a;i++) {	
		y[i]=str_x.substring(i,i+1);
		};
		int[] str_y=new int[a];
		for (int d=0;d<a;d++) {
		str_y[d]=Integer.parseInt(y[d]);
		};

		int sum=0;
		for(int f=0;f<a;f++) {
			sum+=str_y[f];
		
		boolean answer;
		if(x%sum==0) {answer=true;}
		else { answer=false;}
        return answer;
    }}}

