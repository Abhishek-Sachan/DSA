package dynamicProgram;

public class MaximalSquare {
	public static int solve(int mat[][],int i,int j, int max) {
	
	if(i>=mat.length || j>=mat[0].length)	{
		return 0;
	}
	
	int right= solve(mat, i, j+1,max);
	int diagonal=solve(mat, i+1, j+1,max);
	int down= solve(mat, i+1, j,max);
	
	if(mat[i][j]==1) {
		int ans=1+Math.min(right, Math.min(diagonal, down));
	max=Math.max(max, ans);
	}
	else {
		return 0;
	}
	return max;	
}
	
	public static int solvememo(int mat[][],int i,int j, int max,int dp[][]) {
		
		if(i>=mat.length || j>=mat[0].length)	{
			return 0;
		}
		
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int right= solvememo(mat, i, j+1,max,dp);
		int diagonal=solvememo(mat, i+1, j+1,max,dp);
		int down= solvememo(mat, i+1, j,max,dp);
		
		if(mat[i][j]==1) {
			dp[i][j]=1+Math.min(right, Math.min(diagonal, down));
		max=Math.max(max, dp[i][j]);
		
		}
		else {
			return 0;
		}
		return max;
			
	}
	
	public static int maxSquare(int n, int m,int mat[][]) {
	int dp[][]= new int[n+1][m+1];
	
	for(int i=0; i<n+1;i++) {
		for(int j=0; i<m+1;j++) {
			dp[i][j]=-1;
			System.out.println(i+" "+j);
		}
			
		System.out.println(" ram");
			}
	int max=0;
	  return solvememo(mat, 0,0,max,dp);
	  
		
		
		
	//return solve(mat,0,0,max);
	  
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int n=2;
int m=2;
int mat[][]= {{1,1},
		{1,1}
		
       };
		
		System.out.println(maxSquare(n, m, mat));

	}

}
