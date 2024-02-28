package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hasmap {

	public static void main(String[] args) {
		
		// country(key), population(values)
		HashMap<String,Integer> map= new HashMap<>();
		
		/// insertion
		map.put("India", 120);
		map.put("Us", 30);
		map.put("China", 150);
		System.out.println(map);
		/// unordered print not acsending or descending
		map.put("China", 170);
		System.out.println(map);
		
		/// search
		System.out.println(map.containsKey("China"));
	
		System.out.println(map.get("China")); // key exist
		System.out.println(map.get("America"));   // key doesnot exist
		
		/// Iteration
		
		int arr[]= {12,15,16};
		
		for(int val: arr) {
			System.out.println(val+" ");
		}
		
		// for hashmap
		
		for(Map.Entry<String, Integer> e:map.entrySet()) {
			System.out.println(e.getKey()+" ");
			System.out.println(e.getValue()+" ");
		}
		// second way
		Set<String> keys= map.keySet();
		for(String key:keys) {
			System.out.println(key+" "+map.get(key));
		}
		/// remove a pair
		
		map.remove("China");
		System.out.println(map);
		System.out.println(map.size());
		
	}

}
