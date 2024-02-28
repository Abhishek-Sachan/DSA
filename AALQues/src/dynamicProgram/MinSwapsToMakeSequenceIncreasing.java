package dynamicProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSwapsToMakeSequenceIncreasing {
	
	public static int solve(int num1[],int num2[],int index,int swap) {
		
		// base case
		if(index==num1.length) {
			return 0;
		}
		int ans= Integer.MAX_VALUE;
		int prev1= num1[index-1];
		int prev2= num2[index-1];
		
		/// catch
		if(swap==1) {
			int temp=prev1;
			prev1=prev2;
			prev2=temp;
		}
		
		// no swap case
		if(num1[index]>prev1 &&  num2[index]>prev2) {
			ans=solve(num1, num2, index+1, 0);
		}
		
		// swap case 
		if(num1[index]>prev2 &&  num2[index]>prev1) {
			ans= Math.min(ans, 1+solve(num1, num2, index+1, 1));
		}
		
		return ans;
	}
	
	
public static int solveMemo(int num1[],int num2[],int index,int swap,int dp[][]) {
		
		// base case
		if(index==num1.length) {
			return 0;
		}
		
		if(dp[index][swap]!=-1) {
			return dp[index][swap];
		}
		int ans= Integer.MAX_VALUE;
		int prev1= num1[index-1];
		int prev2= num2[index-1];
		
		/// catch
		if(swap==1) {
			int temp=prev1;
			prev1=prev2;
			prev2=temp;
		}
		
		// no swap case
		if(num1[index]>prev1 &&  num2[index]>prev2) {
			ans=solveMemo(num1, num2, index+1, 0, dp);
		}
		
		// swap case 
		if(num1[index]>prev2 &&  num2[index]>prev1) {
			ans= Math.min(ans, 1+solveMemo(num1, num2, index+1, 1, dp));
		}
		
		return dp[index][swap]=ans; 
	}
	
	
	
	public static int minSwap(int num1[], int num2[]) {
		 
		// it means that previous index were swapped or not
		int swapped=0;
		//return solve(num1, num2,1,swapped);
		
		// memoization
		int k=2;
		int dp[][]= new int[num1.length][k];
		for(int p=0;p<num1.length;p++) {
			for(int s=0;s<k;s++) {
				dp[p][s]=-1;
			}
		}
		return solveMemo(num1, num2, k, swapped,dp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int num1[]= {1,3,5,4};
   int num2[]= {1,2,3,7};
   
   
  
   System.out.println(minSwap(num1, num2));
   
	}

}
