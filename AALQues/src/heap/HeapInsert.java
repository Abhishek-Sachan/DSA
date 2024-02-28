package heap;



public class HeapInsert {
	
	// max heap insert
	//  o(logn)
	
	
		int arr[]= new int[100];
		int size=0;
		
		HeapInsert(){
			 arr[0]=-1;
			 size=0;
		}
		
		void insert(int val) {
			
			// add in last index 
			size=size+1;
			int index= size;
		 arr[index]=val;
		 
		 while(index>1) {
			 int parent=index/2;
			 if(arr[parent]<arr[index]) {
				int temp=arr[parent];
				arr[parent]=arr[index];
				arr[index]=temp;
				 index=parent;
			 }
			 else {
				 return;
			 }
		 }
			
		}
		
		void print() {
			for(int i=1; i<=size; i++) {
				System.out.print(arr[i]+" ");
			}
		}
		
		// deletion in heap (root node delete)
		// o(logn)
		
		void delete() {
			if(size==0) {
				System.out.println("no delete happen");
			}
			// last index value , put in place in 1st index 
			arr[1]=arr[size];
			size--;
			
			int i=1;
			while(i<size) {
				int leftIndex=2*i;
				int rightIndex=2*i+1;
				if(leftIndex<size && arr[leftIndex]>arr[i]) {
					int temp=arr[i];
					arr[i]=arr[leftIndex];
					arr[leftIndex]=temp;
					 i=leftIndex;
				}
				
				else if(rightIndex<size && arr[rightIndex]>arr[i]) {
					int temp=arr[i];
					arr[i]=arr[rightIndex];
					arr[rightIndex]=temp;
					 i=rightIndex;
				}
				else {
					return;
				}
			}
			
			
		}
		
		/// HEAPIFY ALGORITHM
		// leaf node index in complete binary tree , from (n/2+1) to n
		// log(n)
		
		
		void heapify(int arr[], int n,int i) {
			
			int largest=i;
			int left=2*i;
			int right=2*i+1;
			// for 1 based indexing, left<=n otherwise in 0 based indexing always left<n
			
			if(left<=n && arr[largest]<arr[left]) {
				largest=left;
			}
			
			if(right<=n && arr[largest]<arr[right]) {
				largest=right;
			}
			
			if(largest!=i) {
				int temp=arr[i];
				arr[i]=arr[largest];
				arr[largest]=temp;
				heapify(arr, n, largest);
			}
			
		}
		
		// HEAP SORT
		//o(nlogn)
		
		void heapSort(int arr[],int n) {
			int size=n;
			while(size>1) {
				// swap last element to first element
				int temp=arr[1];
				arr[1]=arr[size];
				arr[size]=temp;
				// 1 size less
				size--;
				
				// fill element in right position as heap
				heapify(arr, size, 1);
			}
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HeapInsert h= new HeapInsert();
	
	h.insert(50);
	h.insert(55);
	h.insert(53);
	h.insert(52);
	h.insert(54);
	h.print();
	System.out.println();
	h.delete();
	h.print();
	System.out.println();
	int arr[]= {-1,54,53,55,52,50};
	int n=5;
	// heap creation
	for(int i=n/2;i>0;i--) {
		h.heapify(arr, n, i);
	}
	System.out.println("print heapify");
	
	for(int i=1; i<=n; i++) {
		System.out.print(arr[i]+" ");
	}
	System.out.println();
	System.out.println("sort array");
	h.heapSort(arr, n);
	for(int i=1; i<=n; i++) {
		System.out.print(arr[i]+" ");
	}

	}

}
