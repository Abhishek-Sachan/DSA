package dynamicProgram;

public class PartitionWqualSubsetSum {
	
	public static int solve(int index,int n,int arr[],int target) {
		// base case
		if(index>=n) {
			return 0;
		}
		if(target<0) {
			return 0;
		}
		if(target==0) {
			return 1;
		}
		int include=solve(index+1, n, arr, target-arr[index]);
		int exclude= solve(index+1, n, arr, target-0);
		
	     return include|exclude;
	}
	
	public static int solveMemo(int index,int n,int arr[],int target,int dp[][]) {
		// base case
		if(index>=n) {
			return 0;
		}
		if(target<0) {
			return 0;
		}
		if(target==0) {
			return 1;
		}
		
		if(dp[index][target]!=-1) {
			return dp[index][target];
		}
		int include=solveMemo(index+1, n, arr, target-arr[index], dp);
		int exclude= solveMemo(index+1, n, arr, target-0, dp);
		
	     return dp[index][target]=include|exclude;
	}


	
	public static int equalPartition(int n, int arr[]) {
		/// 0 for false case, and 1 for true case
		
				int total=0;
				for(int i=0; i<arr.length;i++) {
					total=total+arr[i];
				}
				if(total%2==1) {  // if total is odd
					return 0;
				}
				int target= total/2;
				//return solve(0, n, arr,target);
				
				// memoization
				
				int dp[][]= new int[n][target+1];
				for(int p=0;p<n;p++) {
					for(int s=0;s<=target;s++) {
						dp[p][s]=-1;
					}
				}
				
				return solveMemo(0, n, arr,target,dp);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int n=4;
        int arr[]= {1,5,11,5};
      System.out.println(equalPartition(n, arr));
	}

}
