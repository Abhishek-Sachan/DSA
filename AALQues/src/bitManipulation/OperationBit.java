package bitManipulation;

public class OperationBit {
public static int getIthBit(int n,int i) {
	int bitMask= 1<<i;
if((n&bitMask)==0) {
	return 0;
}else {
	return 1;
}
}

// set ith bit
public static int setIthBit(int n, int i) {
	int bitMask=1<<i;
	return n |bitMask;
}
// clear ith bit
public static int clearIthBit(int n, int i) {
	int bitMask=~(1<<i);
	return n &bitMask;
}

// update ith bit
public static int updateIthBit(int n, int i, int newBit) {
	 n=clearIthBit(n,i);
	 int bitMask= newBit<<i;
	 return n|bitMask;
}
/// clear last ith bit
public static int clearLastIthBit(int n, int i) {
	 
	 int bitMask= (~0)<<i;
	 return n &bitMask;
}

// clear range of bits

public static int clearIBitsRange(int n, int i, int j) {
	int a=((~0)<<(j+1));
	int b=(1<<i)-1;
	int bitMask= a|b;
	return n&bitMask;
}
/// no is power of 2 or not 

public static boolean isPowerOfTwo(int n) {
	return (n&(n-1))==0;
}
// count set bits in a no
public static int countsetBits(int n) {
	int count=0;
	while(n>0) {
		if((n&1) !=0) {
			count++; 
		}
		n=n>>1;
	}
	return count;
}
// fast exponent
public static int fastExpo(int a, int n) {
	int ans=1;
	while(n>0) {
		if((n&1) !=0) {   // check lsb
			ans=ans*a;
		}
		a=a*a;
		n=n>>1;
	}
	return ans;
}
	public static void main(String[] args) {
		System.out.println(getIthBit(10,2));
		System.out.println(setIthBit(10,2));
		System.out.println(clearIthBit(10,1));
		System.out.println(updateIthBit(10,2,1));
		System.out.println(clearLastIthBit(15,2));
		System.out.println(clearIBitsRange(10,2,4));
System.out.println(isPowerOfTwo(4));
System.out.println(countsetBits(10));
System.out.println(fastExpo(5,3));
	}

}
