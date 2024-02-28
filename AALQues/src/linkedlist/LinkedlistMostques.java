package linkedlist;


public class LinkedlistMostques {
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
			
	public static  Listnode removeNthFromLast(Listnode head, int n) {
		
		if(head.next== null) {
			return null;
		}
		int size=0;
		Listnode curr=head;
		while(curr!=null) {
			curr=curr.next;
			size++;	
		}
		
		if(n== size) {
			return head.next;
		}
		int indexToSearch= size-n; // previous node of which i want to delete node
		/// because from start to find last nth node=  size-n+1
		// so previous node= size-n
		Listnode prev= head;
		int i=1;
		while(i<indexToSearch) {
			prev=prev.next;
			i++;
		}
		System.out.println(prev.data+ " "+prev.next.data);
		prev.next=prev.next.next;
		return head;
	}
	
	// check linklist is palindrome
	
	// reverse second half linklist 
public static Listnode reverse(Listnode head) {
	Listnode prev= null;
	Listnode curr= head;
	while(curr!= null) {
		Listnode next= curr.next;
		curr.next=prev;
		prev= curr;
		curr= next;
	}
	return prev;
}
// find middle node of linklist
public static  Listnode findMiddle(Listnode head) {
	Listnode sp= head;  // slow pointer
	Listnode fp=head;  // fast pointer
	while(fp.next!=null && fp.next.next!=null) {
		fp=fp.next.next;
		sp=sp.next;
	}
	return sp;
}
	public static boolean isPalindrome(Listnode head) {
		
		if(head== null || head.next== null) {
			return true;
		}
		Listnode middle =findMiddle(head);  // return first half end
		// so first half of end.next will be start of second half
		Listnode secondHalf=reverse(middle.next);  //  reverse linklist of second half
		Listnode firstHalfStart= head;
		while(secondHalf!=null) {
			if(firstHalfStart.data != secondHalf.data) {
				return false;
			}
			firstHalfStart=firstHalfStart.next;
			secondHalf=secondHalf.next;
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		LinkedlistMostques list= new LinkedlistMostques();
	list.addLast(1);
	list.addLast(2);
	list.addLast(3);
	list.addLast(4);
	list.addLast(5);
	list.printList();
	removeNthFromLast(list.head,2);
	list.printList();
/// palindrome linklist
	LinkedlistMostques list2= new LinkedlistMostques();
	list2.addLast(1);
	list2.addLast(2);
	list2.addLast(2);
	list2.addLast(1);
	list2.printList();
	System.out.println(isPalindrome(list2.head));
	
	}

}
