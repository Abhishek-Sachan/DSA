package dynamicProgram;

public class GuessNoHigherorLower {
	
	public static int solve(int start,int end) {
		
		if(start>=end) {
			return 0;
		}
		int maxi=Integer.MAX_VALUE;
		for(int i=start; i<=end;i++) {
			maxi=Math.min(maxi, i+Math.max(solve(start,i-1), solve(i+1, end)));
		}
		return maxi;
		
		
	}
	
public static int solveMemo(int start,int end,int dp[][]) {
		
		if(start>=end) {
			return 0;
		}
		if(dp[start][end]!=-1) {
			return dp[start][end];
		}
		int maxi=Integer.MAX_VALUE;
		for(int i=start; i<=end;i++) {
			maxi=Math.min(maxi, i+Math.max(solveMemo(start,i-1, dp), solveMemo(i+1, end, dp)));
		}
		return dp[start][end]=maxi;
		
		
	}
	
	public static int higherOrLower(int n) {
		
		
		int dp[][]= new int[n+1][n+1];
		for(int p=0;p<=n;p++) {
			for(int s=0;s<=n;s++) {
				dp[p][s]=-1;
			}
		}
		
		return solveMemo(1, n,dp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int n=10;

System.out.println(solve(1, n));
System.out.println(higherOrLower(n));
	}

}
