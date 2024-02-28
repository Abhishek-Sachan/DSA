package arrays;


public class BinarySearch {

	public static int binaySearch(int arrays[],int key) {
		
		int start=0;
		int end= arrays.length-1;
		while(start<=end) {
			int mid=(start+end)/2;
			
			// comparasion 
			if(arrays[mid] ==key) { // found
			return mid;
			}
			if(arrays[mid]<key) {/// right
				start= mid+1;
			} else {  // left
				end=mid-1;
			}
			
		}
		return -1;
	}
	
	/// Reverse array
	
	public static void reverseArray(int arrays[]) {
		int first=0;
		int last=arrays.length-1;
		
		while(first<last) {
			int temp= arrays[last];
			arrays[last]=arrays[first];
			arrays[first]= temp;
			first++;
			last--;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/// always works for sorted array
		int arrays[]= {2,4,6,8,10,12,14};
		int key=10;
		System.out.println("index for key is"+ binaySearch(arrays, key));
	// reverse array
		reverseArray(arrays);
		for(int i=0; i<arrays.length;i++) {
			System.out.print(arrays[i]+" ");
		}
		
	}

}
