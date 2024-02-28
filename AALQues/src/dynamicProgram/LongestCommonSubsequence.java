package dynamicProgram;

public class LongestCommonSubsequence {
	
	public static int solve(String s1, String s2,int i, int j) {
		
		
		/// base case
		if(i==s1.length()) {
			return 0;
		}
		if(j==s2.length()) {
			return 0;
		}
		int ans=0;
		if(s1.charAt(i)==s2.charAt(j)) {
			// if in i and j have same character
			ans=1+solve(s1, s2, i+1, j+1);
		}else {
			ans=Math.max(solve(s1, s2, i+1, j), solve(s1, s2, i, j+1));
		}
		return ans;
	}
	
	
public static int solveMemo(String s1, String s2,int i, int j,int dp[][]) {
		
		/// base case
		if(i==s1.length()) {
			return 0;
		}
		if(j==s2.length()) {
			return 0;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int ans=0;
		
		if(s1.charAt(i)==s2.charAt(j)) {
			// if in i and j have same character
			ans=1+solveMemo(s1, s2, i+1, j+1, dp);
			
		}else {
			ans=Math.max(solveMemo(s1, s2, i+1, j, dp), solveMemo(s1, s2, i, j+1, dp));
		}
		
		return dp[i][j]=ans;
	}
	
public static int solveTabu(String s1, String s2) {
	
	int k=s1.length();
	int h=s2.length();
	int dp[][]= new int[k+1][h+1];
	for(int p=0;p<=k;p++) {
		for(int s=0;s<=h;s++) {
			dp[p][s]=0;
		}
	}
	for(int i=s1.length()-1;i>=0;i--) {
		for(int j=s2.length()-1;j>=0; j-- ) {
	
	int ans=0;
	if(s1.charAt(i)==s2.charAt(j)) {
		// if in i and j have same character
		ans=1+dp[i+1][j+1];
	}else {
		ans=Math.max(dp[i+1][j], dp[i][j+1]);
	}
	 dp[i][j]=ans;
		}
	}
	return dp[0][0];
}

public static int solveSpaceopti(String s1, String s2) {
	
	int k=s1.length();
	int h=s2.length();
	int curr[]= new int[h+1];
	int next[]= new int[h+1];
	for (int i=0;i<=h;i++) {
		curr[i]=0;
		next[i]=0;
	}
	
	for(int i=s1.length()-1;i>=0;i--) {
		for(int j=s2.length()-1;j>=0; j-- ) {
	
	int ans=0;
	
	if(s1.charAt(i)==s2.charAt(j)) {
		// if in i and j have same character
		ans=1+next[j+1];
		
	}else {
		ans=Math.max(next[j], curr[j+1]);
	}
	 curr[j]=ans;
		}
		next=curr;
	}
	return next[0];
}

	public static int maxLength(String s1, String s2) {
		int k=s1.length();
		int h=s2.length();
		int dp[][]= new int[k][h];
		for(int p=0;p<k;p++) {
			for(int s=0;s<h;s++) {
				dp[p][s]=-1;
			}
		}
		return solveMemo(s1, s2, 0, 0,dp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s1="abcde";
       String s2="ace";
       System.out.println(solve(s1, s2, 0, 0));
	System.out.println(maxLength(s1, s2));
	System.out.println(solveTabu(s1, s2));
	System.out.println(solveSpaceopti(s1, s2));
	}

}
