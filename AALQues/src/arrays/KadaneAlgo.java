package arrays;

public class KadaneAlgo {
	
	public static void kadanes(int arr[]) {
	
		int maximumSum=Integer.MIN_VALUE;
		int currentSum=0;
		int start=0;
		int end=0;
		
		for(int i=0;i<arr.length;i++) {
			currentSum=currentSum+arr[i];
			
			//maximumSum=Math.max(currentSum, maximumSum);
			if(maximumSum<currentSum) {
				maximumSum= currentSum;
              end = i;
			}
             if(currentSum<0) {
 				currentSum=0;
 				 start=i+1;
 			}
		}
		System.out.println(maximumSum);	
		System.out.println(start+" "+end);
	}

	public static void main(String[] args) {
int arr[]= {-2,-3,4,-1,-2,1,5,-3};
///int arr1[]= {-1,-2,-3,-4,-5,-6};  // for this you have to find biggest no like here , -1
kadanes(arr);
///kadanes(arr1);
	}

}
