package linkedlist;

import java.util.LinkedList;

public class LinkedlistCollection {

	public static void main(String[] args) {
		LinkedList<String> list= new LinkedList<>();
		list.addFirst("a");
		list.addFirst("is");
		System.out.println(list);
		list.addLast("list");
		list.addFirst("This");
		list.add("dt"); // always add in last
		System.out.println(list);
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+"->");
		}
		System.out.println("null");
		
		list.removeFirst();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		list.remove(2);  // remove from index
		System.out.println(list);
		
	}
	
	

}
