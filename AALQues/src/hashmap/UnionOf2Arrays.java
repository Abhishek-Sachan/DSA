package hashmap;

import java.util.HashSet;
import java.util.Iterator;

public class UnionOf2Arrays {

	/// union of 2 arrays
	public static int unionOfArray(int arr1[],int arr2[]) {
		
		HashSet<Integer> set= new HashSet<>();
		for(int i=0; i<arr1.length;i++) {
			set.add(arr1[i]);
		}
		for(int j=0;j<arr2.length;j++) {
			set.add(arr2[j]);
		}
		Iterator<Integer> it= set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		return set.size();
		
	}
	public static void main(String[] args) {
		 int arr1[]= {7,3,9};
		 int arr2[]= {6,3,9,2,9,4};
System.out.println(unionOfArray(arr1, arr2));
	}

}
