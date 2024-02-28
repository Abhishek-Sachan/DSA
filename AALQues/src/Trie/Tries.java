package Trie;

public class Tries {
	
	// generally  in balanced(avl) tree , o(logn)
	// in worst case, skewed tree(means all children node in one side , left or right), for searching node, o(h) / o(n)
	// for trie, root is always empty.
	// prefix is not repeated.
	// trie(k-array tree) is using for searching element in string/arrays of string/list of string
	// because complexity, o(n)
	
	
	static class Node{
		// for size of children node array, 26(because of from a to z)
		// but if all character(a-z,A-Z,%,@ ---) is allowed , so size is 256.
		Node[] children;
		boolean endOfWord;
		
		public Node() {
			children= new Node[26];
			for(int i=0;i<26;i++) {
				children[i]=null;
			}
			endOfWord=false;
		}
	}

	static Node root= new Node();
	
	// insert in trie
	// o(L), L means length of array of string, means 5 for ques
	
	public static void insert(String word) {
		Node curr=root;
		for(int i=0; i<word.length();i++) {
			int idx= word.charAt(i)-'a';
			// since 'a'-'a=0'; 'b'-'a'=1 and so on
			if(curr.children[idx]==null) {
				// add new node 
				curr.children[idx]= new Node();
			}
			if(i==word.length()-1) {
				curr.children[idx].endOfWord=true;
			}
			curr=curr.children[idx];
		}
	}
	
	// SEARCH  IN TRIE
	
	public static boolean search(String key) {
		/// o(L)
		Node curr= root;
		for(int i=0; i<key.length();i++) {
			int idx= key.charAt(i)-'a';
			// since 'a'-'a=0'; 'b'-'a'=1 and so on
			if(curr.children[idx]==null) {
				return false;
			}
			if(i==key.length()-1 && curr.children[idx].endOfWord==false) {
				return false;
			}
			curr=curr.children[idx];
		}
		return true;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String words[]= {"the", "a","there","their","any"};
   for(int i=0; i<words.length;i++) {
	insert(words[i]);
}
    System.out.println(search("their"));
    System.out.println(search("thor"));
    System.out.println(search("an"));
	}

}
