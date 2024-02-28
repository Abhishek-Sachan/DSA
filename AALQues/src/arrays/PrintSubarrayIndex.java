package arrays;

public class PrintSubarrayIndex {

	
	public static void printSubarrayIndexForParticulatSum(int numbers[]) {
		int sum2=18;
		for(int i=0;i<numbers.length;i++) {
			int sum= numbers[i];
			for(int j=i+1;j<numbers.length;j++) {
		if(sum2==sum) {
			int start= i;
			int end=j-1;
			System.out.println(start+" "+end);
			break;
		}
				
				sum=sum+numbers[j];
			}
		}
	}
	
	public static void main(String[] args) {
		int numbers[]= {2,4,6,8,10};
		printSubarrayIndexForParticulatSum(numbers);
	}

}
