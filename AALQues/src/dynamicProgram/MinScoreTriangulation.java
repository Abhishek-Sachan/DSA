package dynamicProgram;

public class MinScoreTriangulation {
	
	
	public static int solve(int v[],int i, int j) {
		if(i+1==j) {
			return 0;
		}
		int ans= Integer.MAX_VALUE;
		for(int k=i+1; k<j;k++) {
			ans= Math.min(ans, v[i]*v[j]*v[k]+solve(v, i, k)+solve(v, k, j));
		}
		return ans;
	}
	
	
	// memoization 
	
	public static int solveMemo(int v[],int i, int j,int dp[][]) {
		if(i+1==j) {
			return 0;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int ans= Integer.MAX_VALUE;
		for(int k=i+1; k<j;k++) {
			ans= Math.min(ans, v[i]*v[j]*v[k]+solveMemo(v, i, k,dp)+solveMemo(v, k, j,dp));
		}
		dp[i][j]=ans;
		return dp[i][j];
	}
	
	public static int minScore(int v[],int i, int j) {
		int n= v.length;
		int dp[][]= new int[n][n];
		for(int p=0;p<n;p++) {
			for(int s=0;s<n;s++) {
				dp[p][s]=-1;
			}
		}
		return solveMemo(v, i, j, dp);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int vertex[]= {5,3,7,4};
      int i=0;
      int j=vertex.length-1;
      System.out.println(solve(vertex, i, j));
      System.out.println(minScore(vertex, i, j));
	

}
}
