package dynamicProgram;

import java.util.Queue;

public class MiniCostForTickets {
	
	
	public static int solve(int n,int days[],int daycost[],int index) {
		
		// base case
		if(index>=n) {
			return 0;
		}
		// 1 day pass
		int option1= daycost[0]+solve(n, days, daycost, index+1);
		
		
		// 7 day pass
		int i;
		int option2 = 0;
		for(i=index;i<n && days[i]<days[index]+ 7;i++ ) {
			 option2= daycost[1]+solve(n, days, daycost, i);
		}
		
		// 30 day pass
		int option3 = 0;
		for(i=index;i<n && days[i]<days[index]+ 30;i++ ) {
			 option3= daycost[2]+solve(n, days, daycost, i);
		}
		return Math.min(option1, Math.min(option2, option3));
		
	}
	
	///  memoization
	

	public static int solveMemo(int n,int days[],int daycost[],int index,int dp[]) {
		
		// base case
		if(index>=n) {
			return 0;
		}
		
		if(dp[index]!=-1) {
			return dp[index];
		}
		// 1 day pass
		int option1= daycost[0]+solveMemo(n, days, daycost, index+1,dp);
		
		
		// 7 day pass
		int i;
		int option2 = 0;
		for(i=index;i<n && days[i]<days[index]+ 7;i++ ) {
			 option2= daycost[1]+solveMemo(n, days, daycost, i,dp);
		}
		
		// 30 day pass
		int option3 = 0;
		for(i=index;i<n && days[i]<days[index]+ 30;i++ ) {
			 option3= daycost[2]+solveMemo(n, days, daycost, i,dp);
		}
		dp[index]= Math.min(option1, Math.min(option2, option3));
		
		
		return dp[index];
	}
	
	
	/// tabulation
	
public static int solveTabu(int n,int days[],int daycost[],int index) {
		
		// base case
	int dp[]= new int[n+1];
	for(int i=0; i<=n;i++) {
		dp[i]=-1;
	}
	
	dp[n]=0;
	
	for(int k=n-1;k>=0;k--) {
		
		// 1 day pass
				int option1= daycost[0]+dp[k+1];
				
				
				// 7 day pass
				int i;
				int option2 = 0;
				for(i=k;i<n && days[i]<days[k]+ 7;i++ ) {
					 option2= daycost[1]+dp[i];
				}
				
				// 30 day pass
				int option3 = 0;
				for(i=k;i<n && days[i]<days[k]+ 30;i++ ) {
					 option3= daycost[2]+dp[i];
				}
				dp[k]= Math.min(option1, Math.min(option2, option3));
				
	}
	
	return dp[0];
		
	}



//public static int solveSpace(int n, int days[],int daycost[]) {
	
	//int ans=0;
//	Queue<pair<Integer,Integer>> month;
//	Queue<pair<Integer,Integer>> week;
//	
//	for(int day:days) {
//		
//		// remove expired days
//		while(!month.isEmpty()&& month.peek().first+30<=day) {
//			month.poll();
//		}
//		
//		while(!week.isEmpty()&& week.peek().first+7<=day) {
//			week.poll();
//		}
//		
//		/// add cost for current day
//		week.push(make_pair(day,ans+daycost[1]));
//		month.push(make_pair(day,ans+daycost[2]));
//		
//		// ans update
//		
//		ans=Math.min(ans+daycost[0], Math.min(week.front().second, month.front().second));
//	
	
//	}
//	
//    return ans;
//   }
	
	public static int miniCost(int n, int days[],int daycost[]) {
		int dp[]= new int[n+1];
		for(int i=0; i<=n;i++) {
			dp[i]=-1;
		}
		//return solveMemo(n, days, daycost, 0,dp);
		// 0 mean index of i
		//return solve(n,days,daycost,0);
		return solveTabu(n, days, daycost, 0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int days[]= {2,5};
		int n=2;
		int daycost[]= {1,4,7};
		System.out.println(miniCost(n, days, daycost));
		
	}

}
