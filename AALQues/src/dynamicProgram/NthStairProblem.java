package dynamicProgram;

public class NthStairProblem {

	
	public static int solve(int cost[],int n,int dp[]) {
		if(n==0) {
			return cost[0];
			
		}
		if(n==1) {
			return cost[1];
		}
		
		if(dp[n]!=-1) {
			return dp[n];
		}
		dp[n]= cost[n]+Math.min(solve(cost,n-1,dp),solve(cost,n-2,dp));
	return dp[n];
	
	}
	
	
	public static int mincost(int cost[]) {
		int n=cost.length;
		int dp[]= new int[n+1];
		for(int i=0; i<=n;i++) {
			dp[i]=-1;
		}
		int ans= Math.min(solve(cost,n-1,dp),solve(cost,n-2,dp));
	
		return ans;
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int cost[]= {10,15,20};
int n=cost.length;
System.out.println(mincost(cost));
	}

}
