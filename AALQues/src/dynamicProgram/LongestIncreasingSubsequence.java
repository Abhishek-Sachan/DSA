package dynamicProgram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
	
	public static int solve(int arr[],int n,int curr,int prev) {
		
		/// base case
		if(curr==n) {
			return 0;
		}
		// include
		int include=0;
		if(prev==-1 || arr[curr]>arr[prev]) {
			include=1+solve(arr, n, curr+1, curr);
		}
		
		// exclude
		
		int exclude= 0+solve(arr, n, curr+1, prev);
	
	return Math.max(include, exclude);
	}
	
public static int solveMemo(int arr[],int n,int curr,int prev,int dp[][]) {
		
		/// base case
		if(curr==n) {
			return 0;
		}
		// include
		if(dp[curr][prev+1]!=-1) {
			return dp[curr][prev+1];
		}
		int include=0;
		if(prev==-1 || arr[curr]>arr[prev]) {
			include=1+solveMemo(arr, n, curr+1, curr,dp);
		}
		
		// exclude
		
		int exclude= 0+solveMemo(arr, n, curr+1, prev,dp);
	/// since prev=-1 so that prev+1
	return dp[curr][prev+1]=Math.max(include, exclude);
	}


///DP WITH BINARY SEARCH FOR O(N*LOG N)  

public static int solvewithbinary(int n,int arr[]) {
	if(n==0) {
		return 0;
	}
	
	List<Integer> ans= new ArrayList<>();
	ans.add(arr[0]);
	for(int i=1; i<n;i++) {
		if(arr[i]>ans.get(ans.size()-1)) {
			ans.add(arr[i]);
			
		}
		else {
			// find index of just big element int ans
			int index=Collections.binarySearch(ans, arr[i]);
			if(index<0) {
				index=-(index+1);
			}
			ans.set(index, arr[i]);
			
		}
	}
	
	return ans.size();
	
}
	
	public static int LIS(int arr[], int n, int curr, int prev) {
		int dp[][]=new int[n][n+1];
		for(int p=0;p<n;p++) {
			for(int s=0;s<=n;s++) {
				dp[p][s]=-1;
			}
		}
		return solveMemo(arr, n, curr, prev,dp);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  int arr[]= {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
	int n=arr.length;
	int curr=0;  // currindex
	int prev=-1;   // prev index
  System.out.println(solve(arr,n,curr,prev));
  System.out.println(LIS(arr, n, curr, prev));
  System.out.println(solvewithbinary(n, arr));
	
	}

}
