package dynamicProgram;

import java.util.HashMap;



import java.util.*;


public class MiniCostTreeLeafValue {
	
	public static int solve(int a[] ){
		 int ans = 0;
		 
		    // Stack
		    Vector<Integer> st = new Vector<Integer>();
		    st.add(Integer.MAX_VALUE);
		 
		    // Loop to traverse the array elements
		    for (int i = 0; i < a.length; i++) {
		         
		        // Keep array elements 
		        // in decreasing order by popping out
		        // the elements from stack till the top
		        // element is less than current element
		        while (st.get(st.size()-1) <= a[i]) {
		             
		            // Get top element
		            int x = st.get(st.size()-1);
		 
		            // Remove it
		            st.remove(st.size()-1);
		 
		            // Get the minimum cost to remove x
		            ans += x * Math.min(st.get(st.size()-1), a[i]);
		        }
		 
		        // Push current element
		        st.add(a[i]);
		    }
		 
		    // Find cost for all remaining elements
		    for (int i = 2; i < st.size(); i++)
		        ans += st.get(i) * st.get(i-1);
		 
		    return ans;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int arr[]= {6,2,4};
        System.out.println(solve(arr));
       
	}

}
