package hashmap;

import java.util.HashSet;

public class IntersectionOf2Array {

	/// intersection of 2 array
	public static int interSectionOfArray(int arr1[],int arr2[]) {
		int count=0;
		HashSet<Integer> set= new HashSet<>();
		for(int i=0; i<arr1.length;i++) {
			set.add(arr1[i]);
		}
		for(int j=0;j<arr2.length;j++) {
			if(set.contains(arr2[j])) {
				count++;
				System.out.println(arr2[j]);
				set.remove(arr2[j]);
			}
		}
		return count;
		
	}
	
	public static void main(String[] args) {
		 int arr1[]= {7,3,9};
		 int arr2[]= {6,3,9,2,9,4};
System.out.println(interSectionOfArray(arr1, arr2));
	}

}
