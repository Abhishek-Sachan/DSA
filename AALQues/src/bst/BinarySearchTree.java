package bst;

import java.util.ArrayList;

public class BinarySearchTree {
	
	///  BINARY SEARCH TREE
	// 1.  DATA OF ALL LEFT SUBTRRE NODES < ROOT
	// 2.   DATA OF ALL RIGHT SUBTREE > ROOT
	// 3.  LEFT & RIGHT SUBTREE ARE ALSO BST WITH NO DUPLICATES
	/// 4.   INORDER TRAVERSAL( LEFT> ROOT>RIGHT) OF BST GIVES A SORTED SEQUENCE

	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data=data;
		}
	}
	
	// build a bst
	
	public static Node insert(Node root,int val) {
		if(root==null) {
			root= new Node(val);
			return root;
		}
		if(root.data>val) {
		root.left=	insert(root.left,val);
		}
		else {
			root.right=insert(root.right,val);
		}
		return root;
	}
	
	// inorder traversal
	
	public static void inorder(Node root) {
		if(root== null) {
			return ;
		}
		inorder(root.left);
		System.out.println(root.data+ " ");
		inorder(root.right);
	}
	
	// search a bst   o(h)
	
	public static boolean search(Node root,int key) {
		if(root==null) {
			return false;
		}
		if(root.data>key) {
			return search(root.left,key);
		}else if(root.data== key) {
			return true;
		}
		else {
			return search(root.right,key);
		}
	}
	
	// delete a node 
	
	public static Node delete(Node root,int val) {
		if(root.data>val) {
		root.left=	delete(root.left,val);
		}
		else if(root.data<val) {
			root.right=delete(root.right,val);
		}
		else {
			// root.data== val
			// case 1:   root have no child or leaf node
			if(root.left==null && root.right==null) {
				return null;
			}
			// case 2:  root have 1 child , left or right
			if(root.left==null) {
				return root.right;
			}
			else if(root.right==null) {
				return root.left;
			}
			// case :3 root have both child
			Node IS= inorderSuccessor(root.right);
			root.data=IS.data;
		root.right=	delete(root.right,IS.data);
		}
		return root;
	}
	// inorder successor means left most node in right subtree or just max of root
	
	public static Node inorderSuccessor(Node root) {
		while(root.left!=null) {
			root=root.left;
		}
		return root;
		
	}
	
	// print in range
	
	
	public static void printInRange(Node root,int x,int y) {
		if(root==null) {
			return;
		}
		
		
		if(root.data>=x && root.data<=y) {
			printInRange(root.left, x, y);
			System.out.print(root.data+ " ");
			printInRange(root.right, x, y);
		}
		else if(root.data>=y) {
			printInRange(root.left, x, y);
		}
		else {
			printInRange(root.right, x, y);
		}
	}
	
	// root to leaf paths
	
	public static void printRootToLeaf(Node root,ArrayList<Integer> path) {
		if(root== null) {
			return;
		}
		
		path.add(root.data);
		// leaf nodes
		
		if(root.left== null && root.right==null) {
			
			
			printPath(path);
			
			
		}
		
		// non leaf nodes
		else {
		printRootToLeaf(root.left,path);
		printRootToLeaf(root.right,path);
		}
		
		path.remove(path.size()-1);
	}
	
	public static void printPath(ArrayList<Integer> path) {
		
		for(int i=0; i<path.size();i++) {
			System.out.print(path.get(i)+ ">-");
			
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  int values[]= {8,5,3,6,10,11,14};
  Node root=null;
  for(int i=0; i<values.length;i++) {
	  root=insert(root,values[i]);
  }
  inorder(root);
  int key=3;
  System.out.println(search(root, key));
  printInRange(root, 3, 11);
  System.out.println();
  printRootToLeaf(root, new ArrayList<>());
 delete(root, key);
  inorder(root);
  
  
	}

}
