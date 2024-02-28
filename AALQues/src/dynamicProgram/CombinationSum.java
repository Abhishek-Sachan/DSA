package dynamicProgram;

public class CombinationSum {
	public static int solve(int arr[],int n,int target) {
		
		
		//base case
		if(target<0) {
			return 0;
		}
		if(target==0) {
			return 1;
		}
		int ans=0;
		for(int i=0; i<n;i++) {
			ans+=solve(arr, n, target-arr[i]);
		}
		return ans;
	}
	
	// memoization
	
public static int solveMemo(int arr[],int n,int target,int dp[]) {
		
		
		//base case
		if(target<0) {
			return 0;
		}
		if(target==0) {
			return 1;
		}
		if(dp[target]!=-1) {
			return dp[target];
		}
		int ans=0;
		for(int i=0; i<n;i++) {
			ans+=solveMemo(arr, n, target-arr[i],dp);
		}
		dp[target]=ans;
		return dp[target];
	}
	
	public static int findWays(int arr[],int n,int target) {
		
		
		int dp[]= new int[target+1];
		for(int i=0;i<=target;i++) {
			dp[i]=-1;
		}
		return solveMemo(arr, n, target,dp);
		
		//return solve(arr, n, target);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int arr[]= {1,2,5};
   int target=5;
   int n=3;
   
   
   System.out.println(findWays(arr, n, target));
	}

}
