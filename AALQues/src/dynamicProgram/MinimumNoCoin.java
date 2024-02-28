package dynamicProgram;

public class MinimumNoCoin {
	public static int solveRecursion(int coins[],int amount,int dp[]) {
		// base case
		if(amount==0) {
			return 0;
		}
		if(amount<0) {
			return Integer.MAX_VALUE;
		}
		
		if(dp[amount]!=-1) {
			return dp[amount];
		}
		int mini= Integer.MAX_VALUE;
		for(int i=0;i<coins.length;i++) {
			int ans=solveRecursion(coins, amount-coins[i],dp);
			if(ans!=Integer.MAX_VALUE) {
				mini=Math.min(mini, 1+ans);
			}
			dp[amount]=mini;
			
			
		}
		return mini;
	}
	
	// tabulation methhod
	
	
	public static int solvetabu(int coins[],int amount) {
		int dp[]= new int[amount+1];
		for(int i=0; i<=amount;i++) {
			dp[i]=Integer.MAX_VALUE;
		}
		dp[0]=0;
		for(int i=1; i<=amount;i++) {
			for(int j=0;j<coins.length;j++) {
				if((i-coins[j])>0 && dp[i-coins[j]]!=Integer.MAX_VALUE) {
				dp[i]= Math.min(dp[i], 1+dp[i-coins[j]]);
				System.out.print(dp[i]+" ");
				}
			}
		}
		
		if(dp[amount]==Integer.MAX_VALUE) {
			return -1;
		}
		return dp[amount];	
	}
	
	
	public static int minicoins(int coins[],int amount) {
		int dp[]= new int[amount+1];
		for(int i=0; i<=amount;i++) {
			dp[i]=-1;
		}
		int ans= solveRecursion(coins, amount,dp);
		if(ans==Integer.MAX_VALUE) {
			return -1;
		}
		return ans;
	}

	public static void main(String[] args) {
		int coins[]= {1,2,5};
		
		int Amount=11;
		System.out.println(minicoins(coins, Amount));
		System.out.println(solvetabu(coins, Amount));
		

	}

}
