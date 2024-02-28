package dynamicProgram;

public class CountDerangements {

	
	public static int solve(int n) {
		int  mod=1000000007;
		if(n==1) { // only 1 no
			return 0;
		}
		if(n==2) {
			return 1;
		}
		int ans= ((n-1)%mod)*(solve(n-1)%mod+(solve(n-2)%mod)%mod);
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int n=3;
System.out.println(solve(n));
	}

}
