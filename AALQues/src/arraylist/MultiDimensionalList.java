package arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MultiDimensionalList {

	public static void main(String[] args) {
	ArrayList<ArrayList<Integer>> mainList= new ArrayList<>();
	ArrayList<ArrayList<Integer>> mainList2= new ArrayList<>();

	ArrayList<Integer> list= new ArrayList<>();
	
	list.add(1);
	list.add(2);
	mainList.add(list);
	
	ArrayList<Integer> list2= new ArrayList<>();
	list2.add(3);
	list2.add(4);
	mainList.add(list2);

	for( int i=0;i<mainList.size();i++) {
		ArrayList<Integer> currList= mainList.get(i);
		for( int j=0; j<currList.size();j++) {
			System.out.print(currList.get(j)+" ");
		}
		System.out.println();
	}
	System.out.println(mainList);
	
	ArrayList<Integer> list3= new ArrayList<>();
	ArrayList<Integer> list4= new ArrayList<>();
	ArrayList<Integer> list5= new ArrayList<>();

	for(int i=1;i<5;i++) {
		list3.add(1*i);
		list4.add(2*i);
		list5.add(3*i);
	}
	mainList2.add(list3);
	mainList2.add(list4);
	mainList2.add(list5);
	list3.remove(2);
	list4.remove(3);
	System.out.println(mainList2);
	
	for( int i=0;i<mainList2.size();i++) {
		ArrayList<Integer> currList1= mainList2.get(i);
		for( int j=0; j<currList1.size();j++) {
			System.out.print(currList1.get(j)+" ");
		}
		System.out.println();
	}
	}

}
