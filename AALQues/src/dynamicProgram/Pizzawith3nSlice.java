package dynamicProgram;

public class Pizzawith3nSlice {
	
	
	public static int solve(int index,int endIndexint ,int a[],int n) {
		
		// base case
		if(n==0 || index>endIndexint) {
			return 0;
		}
		// eat current slice
		int include= a[index]+solve(index+2,endIndexint, a, n-1);
		// does not eat current slice
		int exclude= 0+solve(index+1,endIndexint, a, n);
		return Math.max(include, exclude);
		
	}
	
public static int solveMemo(int index,int endIndexint ,int a[],int n,int dp[][]) {
		
		// base case
		if(n==0 || index>endIndexint) {
			return 0;
		}
		if(dp[index][n] !=-1) {
			return dp[index][n];
		}
		// eat current slice
		int include= a[index]+solveMemo(index+2,endIndexint, a, n-1, dp);
		// does not eat current slice
		int exclude= 0+solveMemo(index+1,endIndexint, a, n, dp);
		return dp[index][n]=Math.max(include, exclude);
		
	}
	
	public static int maxSlices(int b[]) {
		int k=b.length;
		// k/3 is total no of slices which you want to eat
		// case 1, first  slice eat  by me
		// k-2 == ending index because lat index is not included
		int case1= solve(0,k-2,b,k/3);
		
		// case 2, last slice eat by me
		// here last index called but first not take 
		int case2= solve(1,k-1,b,k/3);
		    return Math.max(case1, case2);
	
	}
	
	
	public static int maxSlicesMemo(int b[]) {
		int k=b.length;
		
		
		
		// memoization
		
	int dp[][]= new int[k][k];
	for(int p=0;p<k;p++) {
		for(int s=0;s<k;s++) {
			dp[p][s]=-1;
		}
	}
	
	int dp1[][]= new int[k][k];
	for(int p=0;p<k;p++) {
		for(int s=0;s<k;s++) {
			dp1[p][s]=-1;
		}
	}
	int caseMemo1= solveMemo(0,k-2,b,k/3,dp);
	int caseMemo2= solveMemo(1,k-1,b,k/3,dp1);
	
		return Math.max(caseMemo1, caseMemo2);
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
  int slices[]= {1,2,3,4,5,6};
  
  
  System.out.println(maxSlices(slices));
  System.out.println(maxSlicesMemo(slices));
	}

}
