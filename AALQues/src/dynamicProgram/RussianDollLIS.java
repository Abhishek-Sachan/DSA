package dynamicProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RussianDollLIS {
	
	public static int solve(int e[][]) {
		Arrays.sort(e, (a,b) -> (a[0]!=b[0])?a[0]-b[0]:b[1]-a[1]);
		int n=e.length;
		if(n==0) {
			return 0;
		}
		
		List<Integer> ans= new ArrayList<>();
		ans.add(e[0][1]);
		for(int i=1; i<n;i++) {
			if(e[i][1]>ans.get(ans.size()-1)) {
				ans.add(e[i][1]);
				
			}
			else {
				// find index of just big element int ans
				int index=Collections.binarySearch(ans, e[i][1]);
				if(index<0) {
					index=-(index+1);
				}
				ans.set(index, e[i][1]);
				
			}
		}
		
		return ans.size();
		
	}
	
//	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// {width, height } of a envelope
    int envelopes[][]= {{5,4},
    		{6,4},
    		{6,7},
    		{2,3}};
    System.out.println(solve(envelopes));
    
    
    		
    
	}

}
