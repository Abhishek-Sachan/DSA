package dynamicProgram;

public class WildCardPattern {
	
	public static boolean solve(String s1, String s2, int i, int j) {
		
		// base case
		if(i<0 && j<0) {
			return true;
		}
		if(i>=0 && j<0) {
			/// s1=abcde   , s2= c?e
			return false;
		}
		if(i<0 && j>=0) {
			// s1=abc ,  s2= babc   , invalid
			// s1= abc   , s2=*abc    , valid pattern sice we can replace * with empty
			
			 for(int k=0;k<=j ;k++) {
				 if(s2.charAt(k)!='*') {
					 
					 return false;
				 }
			 }
			 return true;
		}
		
		/// match condition
		if(s1.charAt(i)==s2.charAt(j) || s2.charAt(j)=='?') {
			return solve(s1, s2, i-1, j-1);
		}
		else if(s2.charAt(j)=='*') {
			return (solve(s1, s2, i-1, j) || solve(s1, s2, i, j-1));
		}
		else 
			return false;
	}
	
	
public static boolean solveMemo(String s1, String s2, int i, int j, boolean[][] dp) {
		
		// base case
		if(i<0 && j<0) {
			return true;
		}
		if(i>=0 && j<0) {
			/// s1=abcde   , s2= c?e
			return false;
		}
		if(i<0 && j>=0) {
			// s1=abc ,  s2= babc   , invalid
			// s1= abc   , s2=*abc    , valid pattern sice we can replace * with empty
			
			 for(int k=0;k<=j ;k++) {
				 if(s2.charAt(k)!='*') {
					 
					 return false;
				 }
			 }
			 return true;
		}
		
		if(dp[i][j]!=false) {
			return dp[i][j];
		}
		
		/// match condition
		if(s1.charAt(i)==s2.charAt(j) || s2.charAt(j)=='?') {
			return dp[i][j]=solveMemo(s1, s2, i-1, j-1, dp);
		}
		else if(s2.charAt(j)=='*') {
			return dp[i][j]=(solveMemo(s1, s2, i-1, j, dp) || solveMemo(s1, s2, i, j-1, dp));
		}
		else 
			return false;
	}
	
	public static boolean validPattern(String s1, String s2) {
		
		int d=s1.length();
		int r=s2.length();
		boolean dp[][]= new boolean[d][r];
		for(int p=0;p<d;p++) {
			for(int s=0;s<r;s++) {
				dp[p][s]=false;
			}
		}
		return solveMemo(s1, s2, d-1, r-1,dp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1="abcde";
		String s2="a*c?e";
		int d=s1.length();
		int p=s2.length();
		System.out.println(solve(s1, s2, d-1, p-1));
		System.out.println(validPattern(s1, s2));

	}

}
