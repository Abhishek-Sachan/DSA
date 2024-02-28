package dynamicProgram;

public class MaxSumNonAdjacent {

	
	public static int solve(int arr[], int n) {
		if(n<0) {
			return 0;
		}
		if(n==0) {  /// 1 element
			return arr[0];
		}
		// right to left
		
		int include= solve(arr,n-2)+arr[n];
		int exclude= solve(arr,n-1)+0;
		return Math.max(include, exclude);
	}
	
// memonization
	public static int solvememo(int arr[], int n,int dp[]) {
		if(n<0) {
			return 0;
		}
		if(n==0) {  /// 1 element
			return arr[0];
		}
		// right to left
		if(dp[n]!=-1) {
			return dp[n];
		}
		int include= solvememo(arr,n-2,dp)+arr[n];
		int exclude= solvememo(arr,n-1,dp)+0;
		dp[n]= Math.max(include, exclude);
		return dp[n];
	}
	
	public static int maxSum(int arr[]) {
		int n= arr.length;
		int dp[]= new int[n+1];
		for(int i=0; i<=n;i++) {
			dp[i]=-1;
		}
		int ans=solve(arr,n-1);
		int ans1= solvememo(arr,n-1,dp);
		return ans1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[ ]= {9,9,8,2};
		System.out.println(maxSum(arr));

	}

}
