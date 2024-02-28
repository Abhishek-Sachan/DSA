package hashmap;

import java.util.HashMap;

public class SubarraySumK {

	public static void main(String[] args) {
		int arr[]= {10,2,-2,-20,10};
		int k=-10;
		HashMap<Integer, Integer> map= new HashMap<>();
		map.put(0, 1); // this is empty aubarray before j=0;
		// 0 is key or sum till index(here i=-1) and 1 is value as frequency
int ans=0;
int sum=0;
for(int j=0;j<arr.length;j++) {
	sum +=arr[j];
	
	if(map.containsKey(sum-k)) {
		ans +=map.get(sum-k);
	}
	
	if(map.containsKey(sum)) {
		map.put(sum, map.get(sum)+1);
	}else {
		map.put(sum,1); /// first time occur 
	}
}
System.out.println(ans);
	}

}
