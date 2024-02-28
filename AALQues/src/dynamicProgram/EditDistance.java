package dynamicProgram;

public class EditDistance {
	
	public static int solve(String s1, String s2, int i,int j) {
		
		// base case
		if(i==s1.length()) {
			// length of s1 < length of s2
			// like s1= ros   and  s2= horse
			return s2.length()-j;
		}
		if(j==s2.length()) {
			// length of s2<length of s1
			return s1.length()-i;
		}
		
		int ans=0;
		if(s1.charAt(i)==s2.charAt(j)) {
			// current character at index i, j will match same
			return solve(s1, s2, i+1, j+1);
		}
		else {
			// insert
			// 1 add for , i have done 1 operation
			int insert=1+solve(s1, s2, i, j+1);
			// delete
			int delete= 1+solve(s1, s2, i+1, j);
			// replace
			int replace= 1+solve(s1, s2, i+1, j+1);
			
			ans= Math.min(insert, Math.min(delete, replace));
		}
		return ans;
	}
	
	
public static int solveMemo(String s1, String s2, int i,int j,int dp[][]) {
		
		// base case
		if(i==s1.length()) {
			// length of s1 < length of s2
			// like s1= ros   and  s2= horse
			return s2.length()-j;
		}
		if(j==s2.length()) {
			// length of s2<length of s1
			return s1.length()-i;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int ans=0;
		if(s1.charAt(i)==s2.charAt(j)) {
			// current character at index i, j will match same
			return solveMemo(s1, s2, i+1, j+1, dp);
		}
		else {
			// insert
			// 1 add for , i have done 1 operation
			int insert=1+solveMemo(s1, s2, i, j+1, dp);
			// delete
			int delete= 1+solveMemo(s1, s2, i+1, j, dp);
			// replace
			int replace= 1+solveMemo(s1, s2, i+1, j+1, dp);
			
			ans= Math.min(insert, Math.min(delete, replace));
		}
		return dp[i][j]=ans;
	}


public static int solveTabu(String s1, String s2) {
	
	int k=s1.length();
	int d=s2.length();
	int dp[][]= new int[k+1][d+1];
	for(int p=0;p<=k;p++) {
		for(int s=0;s<=d;s++) {
			dp[p][s]=0;
		}
	}
	// base case
	for(int j=0; j<s2.length();j++) {
		// for  that case i== s1.length()
		dp[k][j]=d-j;
	}
	
	for(int i=0; i<s1.length();i++) {
		// for  that case j== s2.length()
		dp[i][d]=k-i;
	}
	
	
	for(int i=k-1;i>=0;i--) {
		for(int j=d-1;j>=0;j--) {
	
	
	int ans=0;
	if(s1.charAt(i)==s2.charAt(j)) {
		// current character at index i, j will match same
		ans= dp[i+1][ j+1];
	}
	else {
		// insert
		// 1 add for , i have done 1 operation
		int insert=1+dp[i][ j+1];
		// delete
		int delete= 1+dp[i+1][ j];
		// replace
		int replace= 1+dp[i+1][ j+1];
		
		ans= Math.min(insert, Math.min(delete, replace));
	}
	 dp[i][j]=ans;
		}
	}
	return dp[0][0];
}


public static int solveOpti(String s1, String s2) {
	/// give wrong ans 
	int k=s1.length();
	int d=s2.length();
	int curr[]= new int[k+1];
	int next[]= new int[k+1];
	
		for(int s=0;s<=k;s++) {
			curr[s]=0;
			next[s]=0;
		}
	
	// base case
	for(int j=0; j<s2.length();j++) {
		// for  that case i== s1.length()
		next[j]=d-j;
	}
	
//	for(int i=0; i<s1.length();i++) {
//		// for  that case j== s2.length()
//		dp[i][d]=k-i;
//	}
	
	
	for(int i=k-1;i>=0;i--) {
		for(int j=d-1;j>=0;j--) {
	/// catch for j==s2.length()
			curr[s2.length()]=s1.length()-i;
	
	int ans=0;
	if(s1.charAt(i)==s2.charAt(j)) {
		// current character at index i, j will match same
		ans= next[ j+1];
	}
	else {
		// insert
		// 1 add for , i have done 1 operation
		int insert=1+curr[ j+1];
		// delete
		int delete= 1+next[ j];
		// replace
		int replace= 1+next[ j+1];
		
		ans= Math.min(insert, Math.min(delete, replace));
	}
	 curr[j]=ans;
		}
		next=curr;
	}
	return next[0];
}
	
	public static int miniNoOperation(String s1, String s2) {
		int k=s1.length();
		int d=s2.length();
		int dp[][]= new int[k][d];
		for(int p=0;p<k;p++) {
			for(int s=0;s<d;s++) {
				dp[p][s]=-1;
			}
		}
		
		return solveMemo(s1, s2, 0, 0,dp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   String s1="horse";
   String s2="ros";
   // you have to make from s1 to s2
   // you can only insert,delete, replace a character
	// int i=  start of s1 from 0 index
   // int j,  start of s2 string from 0 index
   
   System.out.println(solve(s1, s2, 0, 0));
   System.out.println(miniNoOperation(s1, s2));
	System.out.println(solveTabu(s1, s2));
	System.out.println(solveOpti(s1, s2));
	}

}
