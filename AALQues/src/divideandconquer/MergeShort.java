package divideandconquer;

public class MergeShort {
// MERGE SORT
	public static void mergeSort(int arr[], int si, int ei) {
		//int si=0; // starting index
		// int ei=arr.length-1;  //  ending index
	if(si>=ei) {
		return;
	}
		///  mid 
		int mid=si+(ei-si)/2;  // (si+ei)/2
		mergeSort(arr,si,mid);  // left part
		mergeSort(arr, mid+1, ei); // right part
		merge(arr, si, mid, ei);
		
	}
	
	/// for merge
	public static void merge(int arr[],int si,int mid,int ei) {
		
		int temp[]= new int[ei-si+1];
		int i= si;// iterator for left part
		int j=mid+1;  // iterator for right
		int k=0;  // iterator for temp
		while(i<=mid && j<=ei) {
			if(arr[i]<arr[j]) {
				temp[k]=arr[i];
						i++;
				
			}else {
				temp[k]=arr[j];
				j++;
				
			}
			k++;
		}
		/// left part remain
		while(i<=mid) {
			temp[k++]=arr[i++];
		}
		// right part remain
		while(j<=ei) {
			temp[k++]=arr[j++];
		}
		
		/// copy temp to original arr
		for(k=0,i=si;k<temp.length;k++,i++) {
		arr[i]=	temp[k];
		}
	}
	public static void printArray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
int arr[]= {6,3,9,5,2,8,-2}; 
mergeSort(arr, 0, arr.length-1);
printArray(arr);
	}

}
