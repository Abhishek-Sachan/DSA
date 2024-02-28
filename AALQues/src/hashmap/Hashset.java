package hashmap;

import java.util.HashSet;
import java.util.Iterator;

public class Hashset {

	public static void main(String[] args) {
		/// set does not allow duplicates
		/// create
		HashSet<Integer> set= new HashSet<>();
		
		// insert or add
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		System.out.println(set);
		set.add(2);
		System.out.println(set);  // no duplicates add
		
		//  search
		
		System.out.println(set.contains(1));
		System.out.println(set.contains(6));
	
	/// delete or remove
		set.remove(1);
		System.out.println(set);
		
		// size
		System.out.println("size"+ " "+set.size());
		
		/// Iterator
		// not printed in ordered , may or may not be
		Iterator it= set.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	
	}

}
