package arraylist;

import java.util.ArrayList;

public class Arraylist1 {

	public static void main(String[] args) {
		ArrayList<Integer> list= new ArrayList<>();
		ArrayList<Boolean> list2= new ArrayList<>();
		ArrayList<Float> list3= new ArrayList<>();
	list.add(1);  // o(1)
	list.add(4);
	list.add(6);
	list.add(8);
	list.add(7);
	list.add(8);
	System.out.println(list);
	System.out.println(list.get(1));
	System.out.println("remove"+list.remove(1)); // o(n)
	System.out.println(list.set(1, 5));
	System.out.println(list.contains(1));
	System.out.println(list.contains(7));
	System.out.println(list);
	System.out.println("size"+ list.size());
	// for loop
	for(int i=0;i<list.size();i++) {
		System.out.println(list.get(i)+" ");
	}
	
	// reverse list
	for(int i=list.size()-1;i>=0;i--) {
		System.out.print(list.get(i)+" ");
	}
	}

	
	
}
