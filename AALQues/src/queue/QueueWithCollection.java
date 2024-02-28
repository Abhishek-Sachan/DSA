package queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueWithCollection {

	public static void main(String[] args) {
		//Queue<Integer> q= new LinkedList<>();
		/// in java queue is interface not class
		// queue will be implements by arraydeque and linkedlist
		Queue<Integer> q= new ArrayDeque<>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		
		while(!q.isEmpty()) {
			System.out.println(q.peek());
			q.remove();
		}

	}

}
