package tree;



public class CountOfNodes {

	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	
	static class BinaryTree{
		static int idx=-1;
		public static Node buildTree(int nodes[]) {
			idx++;
			if(nodes[idx]==-1) {
				return null;
			}
			Node newNode= new Node(nodes[idx]);
			newNode.left=buildTree(nodes);
			newNode.right=buildTree(nodes);
			
			return newNode;
		}
	}
	
	// count of nodes
	public static int countNodes(Node root) {
		if(root==null) {
			return 0;
		}
		int leftNodes= countNodes(root.left);
		int rightNodes=countNodes(root.right);
		return leftNodes+rightNodes+1;
	}
	
	// sum of nodes of data
	
	public static int sumOfNodes(Node root) {
		if(root==null) {
			return 0;
		}
		int leftsum=sumOfNodes(root.left);
		int rightsum=sumOfNodes(root.right);
		return leftsum+rightsum+root.data;
	}
	
	// height of tree
	public static int height(Node root) {
		if(root==null) {
			return 0;
		}
		int leftHeight= height(root.left);
		int rightHeight=height(root.right);
		
		int myHeight= Math.max(leftHeight, rightHeight)+1;
	return myHeight;
	}
	
	// Diameter of tree
	 // means, most no of nodes between any two nodes
	
	//Approach 1- O(N^2)
	
	// max(left subtree diameter,right subtree diameter,height(left+rightsubtree+1))
	
	public static int diameter(Node root) {
		if(root==null) {
			return 0;
		}
		int diam1=diameter(root.left);
		int diam2=diameter(root.right);
		int diam3=height(root.left)+height(root.right)+1;
		return Math.max(diam3, Math.max(diam1, diam2));
	}
	
	//Approach 2- O(N)
	static class TreeInfo{
		int hei;
		int diam;
		
		TreeInfo(int hei,int diam){
			this.hei=hei;
			this.diam=diam;
		}
	}
	public static TreeInfo diameter2(Node root) {
		if(root==null) {
			return new TreeInfo(0,0);
		}
		TreeInfo left=diameter2(root.left);
		TreeInfo right=diameter2(root.right);
		
		int myHeight=Math.max(left.hei, right.hei)+1;
		int diam1=left.diam;
		int diam2=right.diam;
		int diam3=left.hei+right.hei+1;
		
		int mydiam= Math.max(diam3, Math.max(diam1, diam2));
		
		TreeInfo myInfo= new TreeInfo(myHeight,mydiam);
		return myInfo;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		
		BinaryTree tree= new BinaryTree();
		Node root= tree.buildTree(nodes);
		System.out.println(root.data);
		System.out.println(countNodes(root));
		System.out.println( );
		System.out.println("sum of nodes");
		System.out.println(sumOfNodes(root));
		System.out.println( );
		System.out.println("height of tree");
		System.out.println(height(root));
		System.out.println( );
		System.out.println("diameter of tree");
		System.out.println(diameter(root));
		System.out.println( );
		System.out.println("diameter of tree approch 2");
		System.out.println(diameter2(root).diam);
	}

}
