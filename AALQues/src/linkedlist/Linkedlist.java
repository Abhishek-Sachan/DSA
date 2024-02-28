package linkedlist;

public class Linkedlist {
	Node head;
	// node class
	class Node{
		String data;
		Node next;
		
		Node(String data){
			this.data=data;
			this.next=null;
		}
		Node head;	
	}
	/// add - first, last
			// add first
			
	public void addFirst(String data) {
		Node newNode= new Node(data);
		if(head== null ) {
			head= newNode;
			return;
		}
		newNode.next=head;
		head=newNode;
		
	}
	
	
	// add last
	public void addLast(String data) {
		Node newNode= new Node(data);
		if(head== null ) {
			head= newNode;
			return;
		}
		Node currNode= head;
		while(currNode.next!=null) {
			currNode= currNode.next;
		}
		currNode.next=newNode;
	}
	
	// print list
	public void printList() {
		if(head== null) {
			System.out.println("list is empty");
		}
		Node currNode= head;
		while(currNode!=null) {
			System.out.print(currNode.data+"->");
			currNode= currNode.next;
		}
		System.out.println("NULL");
	}
	
	/// delete 
	// delete first
	public void deleteFirst() {
		if(head== null) {
			System.out.println("list is empty");
			return;
		}
		head=head.next;
	}
	
	// delete last
	public void deleteLast() {
		if(head== null) {
			System.out.println("list is empty");
			return;
		}
		if(head.next== null) {
			head= null;
			return;
		}
		Node secondLast= head;
		Node lastNode= head.next;
		while(lastNode.next!= null) {
			lastNode=lastNode.next;
			secondLast=secondLast.next;
		}
		secondLast.next=null;
	}
	
	// size
	
	public int getSize() {
		Node temp= head;
		int i=1;
		
		while(temp.next!=null) {
			i++;
			temp=temp.next;
		}
		return i;
	}
	

	public static void main(String[] args) {
		Linkedlist list= new Linkedlist();
		list.addFirst("a");
		System.out.println(list.getSize());
		list.addFirst("is");
		list.printList();
		list.addLast("list");
		list.printList();
		list.addFirst("This");
		System.out.println(list.getSize());
		list.printList();
		list.deleteFirst();;
		list.printList();
		list.deleteLast();;
		list.printList();
		System.out.println(list.getSize());
	}

}
