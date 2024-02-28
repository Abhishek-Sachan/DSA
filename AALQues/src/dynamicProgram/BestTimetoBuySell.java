package dynamicProgram;

public class BestTimetoBuySell {
	
	public static int solve(int p[]) {
		int mini=p[0];
		int profit=0;
		for(int i=1;i<p.length;i++) {
			int diff=p[i]-mini;
			profit=Math.max(profit, diff);
			mini=Math.min(mini, p[i]);
		}
		return profit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int prices[]= {7,1,5,3,6,4};
    System.out.println(solve(prices));
	}

}
