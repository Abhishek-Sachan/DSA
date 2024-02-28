package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Heap {
	
	// heap follows perfect(complete) binary tree means already each node should have 2 children except last leaf node(it can have 1 children)
	
	//   2 types-  max(already parent value is greater than both children) and min(already parent value is lower than both children) heap
	// it is implemented by dynamic array
	//    node --- ith index
	//  parent ---- |i/2|index, floor value of i/2
	//  left child--- 2*i index
	// right  child  --- 2*i+1 index
	
	// creating heap(heapify), insert and delete element

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		PriorityQueue<Integer> pq= new PriorityQueue<>();
		pq.add(2);
		pq.add(5);
		pq.add(4);
		pq.add(8);
		pq.add(6);
		pq.add(9);
		
		int k=6;
		System.out.println(pq.size()+"size");
		while(!pq.isEmpty()) {
			if(pq.size()==k) {
				System.out.print(pq.poll()+"poll2");
				break;
			}
			System.out.print(pq.peek()+"peek");
			System.out.println();
			System.out.print(pq.poll()+"poll");
			System.out.println();
			System.out.println(pq.size()+"size");
			
			
			
			
			
			
			
			
			
		}

	}

}
