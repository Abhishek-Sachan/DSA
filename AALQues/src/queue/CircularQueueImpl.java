package queue;

import queue.QueueImpl.Queue;

public class CircularQueueImpl {

	// circular queue using array
	
	static class CircularQueue{
		static int arr[];
		static int size;
		static int rear=-1;
		static int front=-1;
		CircularQueue(int n){
			arr= new int[n];
			this.size=n;
		}
		
		// is empty
		public static boolean isEmpty() {
			return rear==-1 && front==-1;  // this is for empty
		}
		
		// when queue is full
		public static boolean isFull() {
			return (rear+1)%size == front;
		}
		// add function(enqueue)
		public static void add(int data) {
			if(isFull()) {
				System.out.println("full Circular queue");
			}
			// add 1st element
			if(front ==-1) {
				front=0;
			}
			rear=(rear+1)%size;
			arr[rear]= data;
		}
		
		// remove function(dequeue)
		// Time comlexity (o(1))
		
		public static int remove() {
			if(isEmpty()) {
				return -1;
			}
			int result= arr[front];
			if(rear== front) {
				rear= front =-1;
			}else {
				front=(front+1)%size;
			}
			
			return result;
		}
		
		// peek
		
		public static int peek() {
			if(isEmpty()) {
				return -1;
			}
			return arr[front];	
		}
	}
	public static void main(String[] args) {
		CircularQueue q= new CircularQueue(5);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		System.out.println("remove"+q.remove());
		q.add(6);
		System.out.println("remove"+q.remove());
		q.add(7);
		while(!q.isEmpty()) {
			System.out.println(q.peek());
			q.remove();
		}

	}

}
