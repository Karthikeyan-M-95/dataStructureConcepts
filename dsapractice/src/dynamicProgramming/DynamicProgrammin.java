package dynamicProgramming;

public class DynamicProgrammin {

	public int fibonacci(int n) { // implemented by Bottom-Up Approach
		
		int[] table = new int[n+1];
		table[0]=0;
		table[1]=1;
		for(int i=2;i<=n;i++) {
			table[i]=table[i-1]+table[i-2];
		}
		return table[n];
	}
	
	public int fibonacci2(int[] memo, int n) { // implemented by Top-Down Approach
		
		if(memo[n]==0) {
			if(n<2) {
				memo[n]=n;
			}else {
				int left = fibonacci2(memo, n-1);
				int right = fibonacci2(memo, n-2);
				memo[n]= left+right;
			}
		}
		return memo[n];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicProgrammin dp = new DynamicProgrammin();
		System.out.println(dp.fibonacci(10));
		System.out.println(dp.fibonacci2(new int[10+1], 10));

	}

}
