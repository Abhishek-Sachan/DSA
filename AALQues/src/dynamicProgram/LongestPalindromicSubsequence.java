package dynamicProgram;

public class LongestPalindromicSubsequence {
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="bbbab";
		// take reverse of s1 string
String s2="";
for(int i=s1.length()-1;i>=0;i--) {
	s2=s2+s1.charAt(i);
}
// then calculat longest common subsequence
System.out.println(s2+" reverse string of s1");
System.out.println(solveSpaceopti(s1, s2));



	}

}
