package tree;

import tree.Buildtreepreorder.BinaryTree;
import tree.Buildtreepreorder.Node;

public class SubTree {
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

     
	 
	 // sub tree of another tree
	 public static boolean isIdentical(Node root, Node subroot) {
		 if(root==null && subroot==null) {
			 return true;
		 }
		 if(root==null || subroot==null) {
			 return false;
		 }
		 if(root.data== subroot.data) {
		 return isIdentical(root.left, subroot.left) && isIdentical(root.right, subroot.right);
	 
		 }
		 return false;
		 }
	 
	 
	 public static boolean isSubtree(Node root,Node subroot) {
		 if(subroot==null) {
			 return true;
		 }
		 if(root==null) {
			 return false;
		 }
		 if(root.data==subroot.data) {
			 if(isIdentical(root, subroot)) {
				 return true;
			 }
		 }
		 
		 return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
		 
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
int nodes2[]= {2,4,-1,-1,5,-1,-1};
		
		BinaryTree tree= new BinaryTree();
		Node root= tree.buildTree(nodes);
		System.out.println(root.data);
		//Node root2= tree.buildTree(nodes2);
		
		System.out.println(root.data);
		
		//System.out.println(isSubtree(root, root2));

	}

}
