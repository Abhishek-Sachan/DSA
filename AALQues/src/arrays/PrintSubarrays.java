package arrays;

public class PrintSubarrays {
// print all subarray and max sum and min sum
	public static void printSubarray(int numbers[]) {
		int count=0;
		int sum2=20;
		int largest=Integer.MIN_VALUE;
		int smallest=Integer.MAX_VALUE;
		for(int i=0;i<numbers.length;i++) {
			int start= i;
			for(int j=i;j<numbers.length;j++) {
				int end=j;
				int sum=0;
				for(int k=start;k<=end;k++) {
					
					sum= sum+numbers[k];
					
					System.out.print(numbers[k]+" " );
					
					if(largest<sum) {
						largest=sum;
					}
					
					if(smallest>sum) {
						smallest=sum;
					}
				}
				System.out.print(sum+" " );
			

				count++;

				System.out.println();
			}
			System.out.println();
		}
		System.out.println("total no"+ count);
		System.out.println("smallest sum"+ smallest);
		System.out.println("largest sum"+ largest);

	}
	public static void main(String[] args) {
		int numbers[]= {2,4,6,8,10};
		printSubarray(numbers);
	}

}
