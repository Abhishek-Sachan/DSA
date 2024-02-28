package arrays;

public class PrefixSubarraySum {

	public static void printSubarraysum(int numbers[]) {
		int largest=Integer.MIN_VALUE;
		int currSum=0;
		int prefix[]=new int[numbers.length];
		
		prefix[0]=numbers[0];
		///   calculate prefix array
		for(int i=1;i<prefix.length;i++) {
			prefix[i]=prefix[i-1]+numbers[i];
		}
		
		for(int i=0;i<numbers.length;i++) {
			int start=i;
			for(int j=i;j<numbers.length;j++) {
		int end=j;
				
		currSum= start == 0 ? prefix[end] : prefix[end]-prefix[start-1];
		if(largest<currSum) {
			largest=currSum;
		}
			
			}
				
		}
		System.out.println(largest +" ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numbers[]= {2,4,6,8,10};
		printSubarraysum(numbers);
	}

}
