package dynamicProgram;

import java.util.Arrays;

public class ReducingDishes {
	
	public static int solve(int sat[],int index,int time) {
		
		// base case
		if(index==sat.length) {
			return 0;
		}
		int include=sat[index]*(time+1)+solve(sat, index+1, time+1);
		
		int exclude= 0+solve(sat, index+1, time);
		
		return Math.max(include, exclude);
		
		
	}
	
	
	// memo
	
public static int solveMemo(int sat[],int index,int time,int dp[][]) {
		
		// base case
		if(index==sat.length) {
			return 0;
		}
		if(dp[index][time]!=-1) {
			return dp[index][time];
		}
		int include=sat[index]*(time+1)+solveMemo(sat, index+1, time+1, dp);
		
		int exclude= 0+solveMemo(sat, index+1, time, dp);
		
		return dp[index][time]=Math.max(include, exclude);
		
		
	}
	
	
	public static int maxSatisfaction(int sat[]) {
		Arrays.sort(sat);
		int n= sat.length;
		int dp[][]= new int[n+1][n+1];
		for(int p=0;p<=n;p++) {
			for(int s=0;s<=n;s++) {
				dp[p][s]=-1;
			}
		}
		for(int i=0; i<sat.length;i++) {
			System.out.print(sat[i]+"   ");
		}
		System.out.println(  );
		return solveMemo(sat, 0, 0,dp);
		//return solve(sat, 0, 0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int satisfaction[]= {-1,-8,0,5,-9};
   
   System.out.println(maxSatisfaction(satisfaction));
	}

}
