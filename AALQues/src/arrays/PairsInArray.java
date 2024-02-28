package arrays;

public class PairsInArray {
/// o(n^2)
	public static void Printpairs(int numbers[]) {
		int count=0;
		for(int i=0;i<numbers.length;i++) {
			int curr=numbers[i];
			for(int j=i+1;j<numbers.length;j++) {
				System.out.println("("+curr+","+numbers[j]+")");
			count++;
			System.out.println(count);
			}
		}
	}
	public static void main(String arg[]) {
		int numbers[]= {2,4,6,8,10};
		Printpairs(numbers);
	}
}
