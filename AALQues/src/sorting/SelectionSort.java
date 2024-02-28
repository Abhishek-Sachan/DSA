package sorting;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SelectionSort {

	public static void selectionSort(int arr[]) {
		
		for(int turn=0;turn<arr.length-1;turn++) {
			int minPos=turn;
			for(int j=turn+1;j<arr.length;j++) {
				if(arr[minPos]>arr[j]) {
					minPos=j;
					
				}
			}
			int temp=arr[minPos];
			arr[minPos]=arr[turn];
			arr[turn]=temp;
		}
	}
	
	/// INSERTION SORT
	public static void insertionSort(int arr[]) {
		for(int i=1;i<arr.length;i++) {
			int curr=arr[i];
			int prev=i-1;
			/// finding correct pos to insert
			while(prev>=0 && arr[prev]>curr) {
				arr[prev+1]=arr[prev];
				prev--;
			}
			// insertion
			arr[prev+1]=curr;
		}
	}
	
	public static void printArray1(Integer[] arr1) {
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
	}
	
	public static void printArray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int arr[]= {5,4,1,3,2};
		Integer arr1[]= {1,3,5,2,6};
		//selectionSort(arr);
		//insertionSort(arr);
		//Arrays.sort(arr);
		//Arrays.sort(arr, 0, 3);
		Arrays.sort(arr1,Collections.reverseOrder());
		printArray1(arr1);
		printArray(arr);
	}

}
