package dynamicProgram;

import java.util.HashMap;
import java.util.Map.Entry;

public class LongestArithmeticSubsequencewithDiff {
	
	
	
	public static int apwithdiff(int a[],int diff) {
		HashMap<Integer,Integer> dp= new HashMap<>();
		int ans=0;
		for(int i=0;i<a.length;i++) {
			int temp=a[i]-diff;
			int tempAns=0;
			// check answer in previous part of arr exist for temp already or not
			if(dp.containsKey(temp)) {
				tempAns= dp.get(temp);
				tempAns=tempAns+1;
				dp.put(a[i],tempAns);
				
			}else {
				dp.put(a[i], 1);
			}
			
		}
		
		for(Entry<Integer, Integer> val: dp.entrySet())
	    {
	        if (ans < val.getValue())
	            ans = val.getValue();
	    }
	    return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int arr[]= {1,5,7,8,5,3,4,2,1};
    int difference=-2;
    
    System.out.println(apwithdiff(arr, difference));
	}

}
