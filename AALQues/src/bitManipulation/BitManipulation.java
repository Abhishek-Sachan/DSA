package bitManipulation;

public class BitManipulation {

	public static void oddOrEven(int n) {
		int bitMask=1;
		if((n & bitMask) ==0) {
			System.out.println("even no");
		}else {
			System.out.println("odd no");
		}
	}
	public static void main(String[] args) {
		System.out.println(5&6); // and
		System.out.println(5 | 6);  // or
		System.out.println(5 ^ 6);   // xor
		System.out.println(5 | 6);  // or
		System.out.println(~5);  // one's complement
		System.out.println(5<<2); // binary left shift
		System.out.println(6>>1);  // binary right shift
		oddOrEven(3);
		oddOrEven(4);
		System.out.println(2<<1);
		System.out.println((2<<1)|1);
	}

}
