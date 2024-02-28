package dynamicProgram;

public class KnapsackProblem {
	
	// 0/1 metrix
	public static int solve(int weight[],int value[],int index,int maxWeight) {
		/// index== last index or weight.length-1
		//base case
		if(index==0) {
		if(weight[0]<=maxWeight) {
			return value[0];
			
		}
		else {
			return 0;
		}
		}
		  
		  
		int include=0;
		if(weight[index]<=maxWeight) {
			  include=value[index]+ solve(weight, value, index-1, maxWeight-weight[index]);
		
		}
		int exclude=solve(weight, value, index-1, maxWeight);
	int ans=Math.max(include, exclude);
	return ans;
	
	}
	
	/// MEMOIZATION
	public static int solveMemo(int weight[],int value[],int index,int maxWeight,int dp[][]) {
		/// index== last index or weight.length-1
		//base case
		if(index==0) {
		if(weight[0]<=maxWeight) {
			return value[0];
			
		}
		else {
			return 0;
		}
		}
		  
		 if(dp[index][maxWeight]!=-1) {
			 return dp[index][maxWeight];
		 }
		int include=0;
		if(weight[index]<=maxWeight) {
			  include=value[index]+ solveMemo(weight, value, index-1, maxWeight-weight[index],dp);
		
		}
		int exclude=solveMemo(weight, value, index-1, maxWeight,dp);
	dp[index][maxWeight]=Math.max(include, exclude);
	return dp[index][maxWeight];
	
	}
	
	//TABULATION
	
	public static int solveTabu(int weight[],int value[],int index,int maxWeight) {
		/// index== last index or weight.length-1==row
		
int dp[][]= new int[index+1][maxWeight+1];
		
		for(int i=0;i<index+1;i++) {
			for(int j=0; j<maxWeight+1;j++) {
				dp[i][j]=-1;
				
			}
		}
		
		// base case
		
		for(int w=0;w<=maxWeight;w++) {
			if(weight[0]<=maxWeight) {
				dp[0][w]= value[0];
				
			}
			else {
				dp[0][w]=0;
			}
		}
		
		
		for(int idx=1; idx<=index;idx++) {
			for(int w=0; w<=maxWeight;w++) {
				int include=0;
				if(weight[idx]<=w) {
					  include=value[idx]+ dp[idx-1][w-weight[idx]];
				
				}
				int exclude=dp[idx-1][w];
			dp[idx][w]=Math.max(include, exclude);
				
			}
		}
		
		  
		 return dp[index][maxWeight];
		
	
	}
	
	///SPACE OPTIMIZATION
	
	public static int solveSpace(int weight[],int value[],int index,int maxWeight) {
		/// index== last index or weight.length-1==row
		
int prev[]= new int[maxWeight+1];
int curr[]= new int[maxWeight+1];
		
		
			for(int j=0; j<maxWeight+1;j++) {
			prev[j]=-1;
			curr[j]=-1;
			}
		
		
		// base case
		
		for(int w=0;w<=maxWeight;w++) {
			if(weight[0]<=maxWeight) {
				prev[w]= value[0];
				
			}
			else {
				prev[w]=0;
			}
		}
		
		
		for(int idx=1; idx<=index;idx++) {
			for(int w=0; w<=maxWeight;w++) {
				int include=0;
				if(weight[idx]<=w) {
					  include=value[idx]+ prev[w-weight[idx]];
				
				}
				int exclude=prev[w];
			curr[w]=Math.max(include, exclude);
				
			}
			prev=curr;
		}
		
		  
		 return prev[maxWeight];
		
	
	}
	
	
	public static int knapsack(int weight[],int value[],int index,int maxWeight) {
		
		int dp[][]= new int[index+1][maxWeight+1];
		
		for(int i=0;i<index+1;i++) {
			for(int j=0; j<maxWeight+1;j++) {
				dp[i][j]=-1;
				
			}
		}
		return solveMemo(weight, value, index, maxWeight,dp);
		
		
		//return solve(weight, value, index, maxWeight);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int weight[]= {1,2,4,5};
		int value[]= {5,4,8,6};
		int index=weight.length-1;
		int maxWeight=5;
		
System.out.println(knapsack(weight, value, index, maxWeight));
	System.out.println(solveTabu(weight, value, index, maxWeight));
	System.out.println(solveSpace(weight, value, index, maxWeight));
	}

}
