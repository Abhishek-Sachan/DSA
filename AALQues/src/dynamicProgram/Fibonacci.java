package dynamicProgram;

import java.util.Scanner;

public class Fibonacci {
	
	// find nth fibonacci number
	/// top- down approach
	
	
	
	public static  int fib(int n, int dp[]) {
		if(n<=1) {
			return n;
		}
		if(dp[n]!=-1) {
			return dp[n];
		}
		dp[n]= fib(n-1,dp)+fib(n-2,dp);
		return dp[n];
		
	}
	
	// bottom-up approach
	
	public static int fib2(int n,int dp[]) {
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<=n;i++) {
			dp[i]= dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	
	// space optimization
	
	public static int fib3(int n) {
		int prev2=0;
		int prev1=1;
		
		if(n==0) {
			return 0;
		}
		for(int i=2;i<=n;i++) {
			int curr= prev1+prev2;
			prev2=prev1;
			prev1=curr;
		}
		return prev1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc= new Scanner(System.in);
		System.out.println("give n input");
		int n=sc.nextInt();
		System.out.println("no is"+ n);
		int dp[]= new int[n+1];
		for(int i=0; i<=n;i++) {
			dp[i]=-1;
		}
		System.out.println(fib(n, dp));
		System.out.println(fib2(n, dp));
		System.out.println(fib3(n));
		

	}

}
