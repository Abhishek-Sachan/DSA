package dynamicProgram;

public class BuyandSell2 {
	
	public static int solve(int index,int p[],int buy) {
	
		if(index == p.length) {
			return 0;
		}
		int profit=0;
		// buy allowed if buy==1
		if(buy==1) {
			profit=Math.max(-p[index]+solve(index+1, p, 0), 0+solve(index+1, p, 1));
			
		}else {
			/// sell allowed
			profit=Math.max(+p[index]+solve(index+1, p, 1),0+solve(index+1, p, 0));
		}
		return profit;
	}
	
	public static int solveMemo(int index,int p[],int buy,int dp[][]) {
		
		if(index == p.length) {
			return 0;
		}
		if(dp[index][buy]!=-1) {
			return dp[index][buy];
		}
		int profit=0;
		// buy allowed if buy==1
		if(buy==1) {
			int buynow=-p[index]+solveMemo(index+1, p, 0, dp);
			int buynot=0+solveMemo(index+1, p, 1, dp);
			profit=Math.max(buynow, buynot);
			
		}else {
			/// sell allowed
			int sellnow=+p[index]+solveMemo(index+1, p, 1, dp);
			int sellnot=0+solveMemo(index+1, p, 0, dp);
			profit=Math.max(sellnow,sellnot);
		}
		return dp[index][buy]=profit;
	}
	
	public static int maxProfit(int d[]) {
		int n=d.length;
		int dp[][]= new int[n][2];
		for(int p=0;p<n;p++) {
			for(int s=0;s<2;s++) {
				dp[p][s]=-1;
			}
		}
		return solveMemo(0, d, 1,dp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int prices[]= {7,1,5,3,6,4};
   System.out.println(solve(0, prices, 1));
   System.out.println(maxProfit(prices));
	}

}
