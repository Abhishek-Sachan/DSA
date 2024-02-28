package arraylist;

import java.util.ArrayList;

public class PairSum1 {

	// bruteforce   , working for all condition
	// sorted or not, rotated or not 
	public static boolean pairSum(ArrayList<Integer> list, int target) {
		
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				
				if(list.get(i)+list.get(j)==target) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	// optimal solution on 2 pointer  O(n)
	// working for sorted list
	public static boolean pairSum4(ArrayList<Integer> list, int target) {
		int lp=0;
		int rp=list.size()-1;
		while(lp !=rp) { /// lp<rp
			/// case:1 
			if(list.get(lp)+list.get(rp)== target) {
				return true;
			}
			
			/// case:2 
			if(list.get(lp)+list.get(rp) <  target) {
				lp++;
			}
			
			/// case:3
			if(list.get(lp)+list.get(rp) > target) {
				rp--;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		/// sorted arraylist
		ArrayList<Integer> list= new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);
list.add(4);
list.add(5);
list.add(6);
int target=5;

System.out.println(pairSum(list, target));
System.out.println(pairSum4(list, target));
	}

}
