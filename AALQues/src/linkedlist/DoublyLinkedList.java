package linkedlist;

public class DoublyLinkedList {
	
	class Node{
		int data;
		Node next;
		Node prev;
		
		Node(int d){
			this.data=d;
			this.next=null;
			this.prev=null;
		}
	}
	
	public  void print(Node head) {
		Node temp= head;
		while(temp!= null) {
			System.out.print(temp.data+" ");
			temp= temp.next;
		}
		System.out.println();
	}
	
	public int getlength(Node head) {
		int length=0;
		Node temp= head;
		while(temp!= null) {
			length++;
			temp= temp.next;
		}
		return length;
	}
	
	// add first at head
	public void addhead(Node head,int data) {
		Node temp= new Node(data);
		if(head==null) {
			head=temp;
		}
		temp.next=head;
		
		head.prev=temp;
		head=temp;
		
	}
	//add last or tail
	
	public void addlast(Node tail,int data) {
		Node temp= new Node(data);
		while(tail.next!=null) {
			tail=tail.next;
		}
		tail.next=temp;
		temp.prev=tail;
		tail=temp;
		
	}

	public static void main(String[] args) {
		DoublyLinkedList list= new DoublyLinkedList();
    Node node1=list. new Node(10);
    Node head= node1;
    Node tail= node1;
    list.print(head);
    
    System.out.println(list.getlength(head));
    
    list.addhead(head, 14);
    list.addhead(head, 15);
    list.addhead(head, 17);
    list.print(head);
    System.out.println(list.getlength(head));
    
    list.addlast(tail, 16);
    list.print(head);
    list.addlast(tail, 19);
    list.print(head);
    list.addlast(tail, 21);
    list.print(head);
    System.out.println(list.getlength(head));
     
	}

}
