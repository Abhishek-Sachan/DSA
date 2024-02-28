package linkedlist;



public class FloyidsAlgorithm {

	Listnode head;
	// node class
	 class Listnode{
		int data;
		Listnode next;

		 Listnode(int data){
			this.data=data;
			this.next=null;
		}
			
	}
	// add last
			public void addLast(int data) {
				Listnode newNode= new Listnode(data);
				if(head== null ) {
					head= newNode;
					return;
				}
				Listnode currNode= head;
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
					Listnode currNode= head;
					while(currNode!=null) {
						System.out.print(currNode.data+"->");
						currNode= currNode.next;
					}
					System.out.println("NULL");
				}
				
			// find cycle in link list
				public static boolean hasCycle(Listnode head) {
					if(head== null) {
						return false;
					}
					
					Listnode sp=head;  // slow pointer as turtle
					Listnode fp= head; // fast pointer  as hare
				while(fp!= null &&fp.next!= null) {
					fp=fp.next.next;
					sp=sp.next;
					if(sp== fp) {
						return true;
					}
				}
				
				return false;
				}
				
				// add in nth node
				public   Listnode addNth(Listnode head, int n,int data) {
					
					Listnode newnode = new Listnode( data);
					
					Listnode curr= head;
					Listnode next= head.next;
					
					int i=1;
					while(i<n-1) {
						curr= curr.next;
						next=next.next;
						i++;
					}
					
					curr.next=newnode;
					newnode.next=next;
					
					
					return newnode;
				}
	public static void main(String[] args) {
		FloyidsAlgorithm list1= new FloyidsAlgorithm();
		list1.addLast(1);
		list1.addLast(2);
		list1.addLast(3);
		list1.addLast(4);
		list1.printList();
		System.out.println(hasCycle(list1.head));
		list1.addNth(list1.head, 1, 6);
		list1.printList();
		list1.addNth(list1.head, 6, 7);
		list1.printList();
	}

}
