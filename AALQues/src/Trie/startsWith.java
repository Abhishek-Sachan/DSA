package Trie;



public class startsWith {
	// starts WITH PROBLEM ,RETURNS TRUE IF THERE IS PREVIOUS INSERTED STRING WORD THAT HAS PREFIX IN TRIE
	
	
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
	
	
	
	public static boolean startsWith(String prefix) {
		/// o(L)
		Node curr= root;
		for(int i=0; i<prefix.length();i++) {
			int idx= prefix.charAt(i)-'a';
			// since 'a'-'a=0'; 'b'-'a'=1 and so on
			if(curr.children[idx]==null) {
				return false;
			}
			
			curr=curr.children[idx];
		}
		return true;
	}
	
	
	/// COUNT UNIQUE(DISTINCT) SUBSTRING(CONTINUOUS PART)
	
	// find all suffix of string
	// create a trie from suffix
	// total nodes of trie= count of unique prefix
	// count nodes of trie
	
	// ALL PREFIX OF ALL SUFFIX
	
	public static int countNode(Node root) {
		if(root==null) {
			return 0;
		}
		int count=0;
		for(int i=0; i<26; i++) {
			if(root.children[i]!=null) {
				count+=countNode(root.children[i]);
			}
		}
		return count+1;
		// +1, means " ", empty node or empty root
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String prefix="app";

		String words[]= {"apple","app","mango","man","woman"};
		   for(int i=0; i<words.length;i++) {
			insert(words[i]);
		}
		   System.out.println(startsWith(prefix));
		   
		   // count distinct substring
		   // first comment all prefix code, then run for count node
		   
		   String str="ababa";
			// calculate all suffix
		   for(int i=0; i<str.length();i++) {
			   String suffix= str.substring(i);
			   System.out.println(suffix);
			   insert(suffix);
		   }
		   System.out.println(countNode(root));
	}

}
