package dynamicProgram;

public class UniqueBinarySearchTree {
	
	public static int solve(int n) {
		if(n<=1) {
			return 1;
		}
		int ans=0;
		// think i as root node
		for(int i=1; i<=n;i++) {
			ans+=solve(i-1)*solve(n-i);
			
		}
		return ans;
	}
	
	public static int solveMemo(int n,int dp[]) {
		if(n<=1) {
			return 1;
		}
		if(dp[n]!=-1) {
			return dp[n];
		}
		int ans=0;
		// think i as root node
		for(int i=1; i<=n;i++) {
			ans+=solveMemo(i-1,dp)*solveMemo(n-i,dp);
			
		}
		return dp[n]=ans;
	}
	/// direct you can direct print catalan number series
	
	
	public static int structTree(int n) {
		 int dp[]= new int[n+1];
		 for(int i=0; i<=n;i++) {
			 dp[i]=-1;
		 }
		 return solveMemo(n,dp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=8;
		System.out.println(solve(n));
		System.out.println(structTree(n));

	}

}
