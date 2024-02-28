package dynamicProgram;

public class BuySell3 {
	
	
	public static int solve(int index,int p[],int buy,int limit) {
		
		if(index == p.length) {
			return 0;
		}
		if(limit==0) {
			return 0;
		}
		int profit=0;
		// buy allowed if buy==1
		if(buy==1) {
			profit=Math.max(-p[index]+solve(index+1, p, 0,limit), 0+solve(index+1, p, 1,limit));
			
		}else {
			/// sell allowed
			profit=Math.max(+p[index]+solve(index+1, p, 1,limit-1),0+solve(index+1, p, 0,limit));
		}
		return profit;
	}
	
public static int solveMemo(int index,int p[],int buy,int limit,int dp[][][]) {
		
		if(index == p.length) {
			return 0;
		}
		if(limit==0) {
			return 0;
		}
		if(dp[index][buy][limit]!=-1) {
			return dp[index][buy][limit];
		}
		int profit=0;
		// buy allowed if buy==1
		if(buy==1) {
			int buynow=-p[index]+solveMemo(index+1, p, 0,limit, dp);
			int buynot=0+solveMemo(index+1, p, 1,limit, dp);
			profit=Math.max(buynow, buynot);
			
		}else {
			/// sell allowed
			int sellnow=+p[index]+solveMemo(index+1, p, 1,limit-1, dp);
			int sellnot=0+solveMemo(index+1, p, 0,limit, dp);
			profit=Math.max(sellnow,sellnot);
		}
		return dp[index][buy][limit]=profit;
	}
	
	public static int maxProfit(int d[]) {
		int n=d.length;
		int dp[][][]= new int[n][2][3];
		for(int p=0;p<n;p++) {
			for(int s=0;s<2;s++) {
				for(int e=0;e<3;e++) {
				dp[p][s][e]=-1;
			}
		}
	}
		int limit=2;
		return solveMemo(0, d, 1,limit,dp);
	}

	
	
	public static void main(String[] args) {
  int prices[]= {3,3,5,0,0,3,1,4};
 int limit=2  ;/// only 2 transaction is possible
  System.out.println(solve(0, prices, 1,limit));
  System.out.println(maxProfit(prices));
}
	
}
