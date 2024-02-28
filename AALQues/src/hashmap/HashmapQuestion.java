package hashmap;

import java.util.HashMap;

public class HashmapQuestion {

	// find majority element which appears in array in more than n/3
	public static void majorityElement(int nums[]) {
		// create hashmap
		/// key(nums[i])  ,  frequency(value)
		HashMap<Integer, Integer> map= new HashMap<>();
	int n= nums.length;
	for(int i=0;i<n;i++) {
		if(map.containsKey(nums[i])) {   // if key exist in map
			map.put(nums[i], map.get(nums[i])+1);
		}else {  // not exist in map
			map.put(nums[i], 1);
		}
	}
	
	for(int key:map.keySet()) {
		if(map.get(key)>n/3) {
			System.out.println(key);
		}
	}
	}
	
	public static void main(String[] args) {
		int nums[]= {1,3,2,5,1,3,1,5,1};
majorityElement(nums);
	}

}
