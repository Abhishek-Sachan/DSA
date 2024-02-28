package arraylist;

import java.util.ArrayList;


///   same code for like pairsum1 in bruteforce case



public class PairSum2 {
	
	// optimised  code  , 2 pointer 
	public static boolean pairSum4(ArrayList<Integer> list, int target) {
int bp=-1;
int n= list.size();
	for(int i=0;i<list.size();i++) {
		if(list.get(i)>list.get(i+1)) { // breaking point
			bp=i;
			break;
		}
	}

int lp=bp+1;  /// smallest
int rp= bp;   // largest
while(lp !=rp) { /// lp<rp
	/// case:1 
	if(list.get(lp)+list.get(rp)== target) {
		return true;
	}
	
	/// case:2 
	if(list.get(lp)+list.get(rp) <  target) {
		lp=(lp+1) %n;
	}
	
	/// case:3
	if(list.get(lp)+list.get(rp) > target) {
		rp=(n+rp-1)%n;
	}
}
 return false;
	}

	public static void main(String[] args) {
		/// sorted and rotated,  not repeteted value 
		ArrayList<Integer> list= new ArrayList<>();
		list.add(11);
		list.add(15);
		list.add(6);
		list.add(8);
		list.add(9);
		list.add(10);
		int target=16;
		System.out.println(pairSum4(list, target));

	}

}
