package dynamicProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumHeightinCuboid {
	
	public static boolean check(int base[], int newBox[]) {
		if(newBox[0]<=base[0] && newBox[1]<=base[1] && newBox[2]<=base[2]) {
			return true;
		}
		else {
			return false;
		}
	}
	public static int LisTabu(int n, int a[][]) {
		int currRow[]=new int[n+1];
		int nextRow[]=new int[n+1];
		
		for(int curr=n-1;curr>=0;curr--) {
			for(int prev =curr-1;prev>=-1;prev--) {
				// include 
				int include=0;
				if(prev==-1 || check(a[curr],a[prev])) {
					include= a[curr][2]+nextRow[curr+1];
				}
				
				// exclude
				int exclude= 0+nextRow[prev+1];
				currRow[prev+1]= Math.max(include, exclude);
			}
			nextRow= currRow;
		}
		return nextRow[0];
	}
	
	public static int solve(int cube[][]) {
		// sort all dimension for every cube
		
	for(int ele[]:cube) {
		Arrays.sort(ele);
		
	}
	
	// sort all cube basis on width or length(which you want)
		// but i am sorting basis on width
	Arrays.sort(cube,(a,b) ->a[0]!=b[0]?a[0]-b[0] :0);
		// LIS logic
	return LisTabu(cube.length, cube);
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int cube[][]= {{50,45,20},
				{95,37,53},
				{45,23,12}};
		System.out.println(solve(cube));
		

	}

}
