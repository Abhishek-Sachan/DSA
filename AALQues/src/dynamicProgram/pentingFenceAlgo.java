package dynamicProgram;

public class pentingFenceAlgo {
	
	 private static final int mod=1000000007;
	public static int add(int a, int b) {
		return (a%mod+b%mod)%mod;
	}
	
	public  static int multi(int a, int b) {
		return ((a%mod)*(b%mod))%mod;
	}
	
	public static int penting(int n, int k) {
		
		if(n==1) {
			return k;
		}
		if(n==2) {
			return add(k,multi(k,k-1));
		}
		
		int ans= add(multi(penting(n-2,k),k-1),multi(penting(n-1,k),k-1));
		return ans;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=3;
		int k=3;
		System.out.println(penting(n, k));

	}

}
