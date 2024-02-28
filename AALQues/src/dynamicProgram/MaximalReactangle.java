package dynamicProgram;

import java.util.Stack;

public class MaximalReactangle {
	
	
	
	public static int area(int m[][]) {
		// give wrong ans
		int maxi=Integer.MIN_VALUE;
		// create different histogram
		int height[]= new int[m[0].length];
		for(int j=0;j<m[0].length;j++) {
			height[j]=0;
		}
		for(int i=0;i<m.length;i++) {
			for(int p=0;p<height.length;p++) {
				if(m[i][p]==1) {
					height[p]++;
				}
				else {
					height[p]=0;
				}
			}
			maxi=Math.max(maxi,largestArea(height));
		}
		
		return maxi;
		
	}

	private static int largestArea(int[] height) {
		int prev[]=prevSmaller(height);
		int next[]=nextSmaller(height);
		
		int maxArea=Integer.MIN_VALUE;
		for(int i=0;i<height.length;i++) {
			int length= height[i];
			int breadth= next[i]-prev[i]-1;
			int newArea= length*breadth;
			maxArea=Math.max(maxArea,newArea);
			
		}
		return maxArea;
	}

	private static int[] nextSmaller(int[] h) {
		Stack<Integer> s= new Stack<>();
		s.push(-1);
		int n=h.length;
		int ans[]= new int[n];
		for(int i=n-1;i>=0;i--) {
			int item=h[i];
			while(s.peek()!=-1 && h[s.peek()]>=item) {
				s.pop();
			}
			// push in ans
			if(s.peek()==-1) {
				ans[i]=n;
			}
			else {
				ans[i]=s.peek();
			}
			s.push(i);
		}
		return ans;
	}

	private static int[] prevSmaller(int[] h) {
		Stack<Integer> s= new Stack<>();
		s.push(-1);
		int n=h.length;
		int ans[]= new int[n];
		for(int i=n-1;i>=0;i--) {
			int item=h[i];
			while(s.peek()!=-1 && h[s.peek()]>=item) {
				s.pop();
			}
			// push in ans
			
				ans[i]=s.peek();
			
			s.push(i);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  int mat[][]= {{0,1,1,0},
		     {1,1,1,1},
		  {1,1,1,1},
		  {1,1,0,0}};
  int mat1[][]= {{0,1,1},
		     {1,1,1},
		  {0,1,1}};
		  
  System.out.println(area(mat1));
	}
	

}
