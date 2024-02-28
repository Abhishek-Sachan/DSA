package dynamicProgram;

public class BuyAndSell5 {

	public static int solve(int index, int buy,int p[], int fee) {

		if(index == p.length) {
			return 0;
		}
		
		int profit=0;
		// buy allowed if buy==1
		if(buy==1) {
			int buynow=-p[index]+solve(index+1, 0, p, fee);
			int buynot=0+solve(index+1, 1, p, fee);
			profit=Math.max(buynow, buynot);
			
		}else {
			/// sell allowed
			int sellnow=+p[index]-fee+solve(index+1, 1, p, fee);
			int sellnot=0+solve(index+1, 0, p, fee);
			profit=Math.max(sellnow,sellnot);
		}
		return profit;
	}

//	public static int maxProfit(int a[], int fee) {
//
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[] = { 1, 3, 2, 8, 4, 9 };
		int fee = 2;
		System.out.println(solve(0, 1, prices, fee));
	}

}
