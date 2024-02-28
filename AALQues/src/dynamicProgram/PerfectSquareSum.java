package dynamicProgram;

public class PerfectSquareSum {

	public static int solve(int n) {
		if(n==0) {
			return 0;
		}
		int ans=n;
		for(int i=1;i*i<=n;i++) {
			ans=Math.min(ans, 1+solve(n-i*i));
		}
		return ans;
	}
	
	public static int solveMemo(int n,int dp[]) {
		if(n==0) {
			return 0;
		}
		
		if(dp[n]!=-1) {
			return dp[n];
		}
		int ans=n;
		for(int i=1;i*i<=n;i++) {
			ans=Math.min(ans, 1+solveMemo(n-i*i,dp));
		}
		dp[n]=ans;
		return dp[n];
	}
	
	public static int minsquare(int n) {
		
		
		int dp[]=new int[n+1];
		for(int i=0; i<=n;i++) {
			dp[i]=-1;
		}
		return solveMemo(n, dp);
		//return solve(n);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int n=6;
   
   System.out.println(minsquare(n));
	}

}
