package backtracking;

import java.util.ArrayList;

public class RatInMaze {
	
	ArrayList<String> searchMaze(int arr[][], int n){
		String path=" ";
		ArrayList<String> ans= new ArrayList<>();
		if(arr[0][0]==0) {
			return ans;
		}
		boolean vis[][] =new boolean[n][n];
		for (int i=0; i<n;i++) {
			for(int j=0; j<n;j++) {
				 vis[i][j]=false;
			}
		}
		
		solve( arr, n, vis, 0, 0, path,ans);
		
		return ans;
		
	}
	
	void solve(int arr[][],int n,boolean vis[][],int x,int y,String path,ArrayList<String> ans) {
		
		
		// base case
		
		if(x==n-1 && y==n-1) {
			ans.add(path);
			return;
		}
		
		vis[x][y]=true;
		
		// movement
		//D, L, R, U--DOWN, LEFT---
		
		// down
		if(isSafe(x+1,y,vis,arr,n)) {
		
			solve(arr, n, vis, x+1, y, path+'D', ans);
			
		}
		
		// left
				if(isSafe(x,y-1,vis,arr,n)) {
					
					solve(arr, n, vis, x, y-1, path+'L', ans);
					
				}
				
				// right
				if(isSafe(x,y+1,vis,arr,n)) {
					
					solve(arr, n, vis, x, y+1, path+'R', ans);
					
				}
				
				// up
				if(isSafe(x-1,y,vis,arr,n)) {
					
					solve(arr, n, vis, x-1, y, path+'U', ans);
					
				}
				vis[x][y]=false;
	}
	
	
	boolean isSafe(int newx, int newy,boolean vis[][],int arr[][],int n) {
		
		if((newx>=0 && newx<n) &&(newy>=0 && newy<n) && vis[newx][newy]==false && arr[newx][newy]==1 ) {
			return true;
		}
		else {
			return false;
		}
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		int n=4;
		int arr[][]= {
				{1,0,0,0},
				{1,1,0,0},
				{1,1,0,0},
				{0,1,1,1}
		
	} ;
		RatInMaze r= new RatInMaze();
		
	System.out.println(r.searchMaze(arr, n));
	}
	}


