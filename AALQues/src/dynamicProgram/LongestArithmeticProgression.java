package dynamicProgram;
import java.util.*;

public class LongestArithmeticProgression {
	
	public static int solve(int index,int diff,int a[]) {
		
		
		if(index<0) {
			return 0;
		}
		int ans=0;
		for(int j=index-1;j>=0;j--) {
			if(a[index]-a[j]==diff) {
				ans=Math.max(ans, 1+solve(j, diff, a));
			}
		}
		return ans;
	}
	
	public static int maxAP(int set[], int n) {
		if(n<=2) {
			return n;
		}
		int ans=0;
		/// since at one index, it have multiple difference so use map
		//HashMap<Integer,Integer> dp[n+1] = new HashMap<>();

		// here we found last 2 no of AP
		for(int i=0; i<n;i++) {
			for(int j=i+1;j<n;j++) {
				// 2+solve(), because 2 values of set[i] and set[j]
				ans=Math.max(ans, 2+solve(i,set[j]-set[i],set));
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int n=6;
int set[]= {1,7,10,13,14,19};

System.out.println(maxAP(set, n));
	}

}
