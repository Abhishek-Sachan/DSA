package dynamicProgram;

public class DiceThrowWithdistinctWays {
	
	public static long noofWays(int m,int n,int x) {
		
	// base case
		if(x<0) {
			return 0;
		}
		if(n==0 && x!=0 || x==0 && n!=0) {
			return 0;
		}
		if(n==0 && x==0) {
			return 1;
		}
		long ans=0;
		for(int i=1;i<=m;i++) {
			ans=ans+noofWays(m, n-1, x-i);
		}
		return ans;
	}
	
	
	public static long solveMemo(int m,int n,int x,long dp[][]) {
		
		// base case
			if(x<0) {
				return 0;
			}
			if(n==0 && x!=0 || x==0 && n!=0) {
				return 0;
			}
			if(n==0 && x==0) {
				return 1;
			}
			if(dp[n][x]!=-1) {
				return dp[n][x];
			}
			long ans=0;
			for(int i=1;i<=m;i++) {
				ans=ans+solveMemo(m, n-1, x-i,dp);
			}
			return dp[n][x]=ans;
		}
	
	
	public static long ways(int m,int n,int x) {
		long dp[][]= new long[n+1][x+1];
		for(int p=0;p<=n;p++) {
			for(int s=0;s<=x;s++) {
				dp[p][s]=-1;
			}
		}
		return solveMemo(m, n, x, dp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int n= 3;  // no of dice
int m=6;  // no of faces from 1 to m
int x=12;  // // target sum
System.out.println(noofWays(m, n, x));
System.out.println(ways(m, n, x));
	}

}
