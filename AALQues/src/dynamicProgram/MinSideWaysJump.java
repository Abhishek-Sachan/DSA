package dynamicProgram;

public class MinSideWaysJump {
	
	public static int solve(int obstacles[],int currlane,int currpos) {
		int n= obstacles.length-1;
		// base case
		if(currpos==n) {
			return 0;
		}
		/// goind straight forward in same lane
		if(obstacles[currpos+1]!=currlane) {
			return solve(obstacles, currlane, currpos+1);
		}
		else {
			// sideways jump
			int ans=Integer.MAX_VALUE;
			for(int i=1;i<=3;i++) {
				if(currlane!=i && obstacles[currpos]!=i) {
				ans=Math.min(ans, 1+solve(obstacles, i, currpos));
				}
			}
			return ans;
		}
		
		
	}
	
	
	
	public static int solveMemo(int obstacles[],int currlane,int currpos,int dp[][]) {
		int n= obstacles.length-1;
		// base case
		if(currpos==n) {
			return 0;
		}
		if(dp[currlane][currpos]!=-1) {
			return dp[currlane][currpos];
		}
		/// goind straight forward in same lane
		if(obstacles[currpos+1]!=currlane) {
			return solveMemo(obstacles, currlane, currpos+1, dp);
		}
		else {
			// sideways jump
			int ans=Integer.MAX_VALUE;
			for(int i=1;i<=3;i++) {
				if(currlane!=i && obstacles[currpos]!=i) {
				ans=Math.min(ans, 1+solveMemo(obstacles, i, currpos, dp));
				}
				
			}
			dp[currlane][currpos]=ans;
			return ans;
		}
		
		
	}
	public static int minSidejump(int obstacles[],int currlane,int currpos) {
		
		int dp[][]= new int[4][obstacles.length];
		for(int p=0;p<4;p++) {
			for(int s=0;s<obstacles.length;s++) {
				dp[p][s]=-1;
			}
		}
		return solveMemo(obstacles, currlane, currpos,dp);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  int obstacles[]= {0,1,2,3,0};
  int currlane=2;
  int currpos= 0;
  
  System.out.println(solve(obstacles, currlane, currpos));
	
	System.out.println(minSidejump(obstacles, currlane, currpos));
	
	}
	
	

}
