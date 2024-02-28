package dynamicProgram;

public class CutRod {
	
	public static int solve(int n,int x,int y,int z) {
		if(n==0) {
			return 0;
		}
		
		if(n<0) {
			return Integer.MIN_VALUE;
		}
		int a= solve(n-x,x,y,z)+1;// use 1 piece of x length
		int b= solve(n-y,x,y,z)+1;
		int c= solve(n-z,x,y,z)+1;
		
		int ans= Math.max(a, Math.max(b, c));
		return ans;
	}
	
	public static int solveMemo(int n,int x,int y,int z,int dp[]) {
		if(n==0) {
			return 0;
		}
		
		if(n<0) {
			return Integer.MIN_VALUE;
		}
		if(dp[n]!=-1) {
			return dp[n];
		}
		int a= solveMemo(n-x,x,y,z,dp)+1;// use 1 piece of x length
		int b= solveMemo(n-y,x,y,z,dp)+1;
		int c= solveMemo(n-z,x,y,z,dp)+1;
		
		dp[n]= Math.max(a, Math.max(b, c));
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=7;// rod length
		int x=5;
		int y=2;
		int z=2; // different length of pieces
		int dp[]= new int[n+1];
		for(int i=0; i<=n;i++) {
			dp[i]=-1;
		}
		int ans1=solveMemo(n, x, y, z,dp);
		int ans=solve(n,x,y,z);
		if(ans1<0) {
			System.out.println(0);
		}else {
			System.out.println(ans1);
		}

	}

}
