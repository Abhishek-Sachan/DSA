package Trie;



public class WordBreak {
	// Word break problem  
	
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
	
	public static boolean wordBreak(String key) {
		if(key.length()==0) {
			return true;
		}
		for(int i=1;i<=key.length();i++) {
			String firstPart= key.substring(0, i);
			/// in substring, i th index not included
			String secPart=key.substring(i);
			if(search(firstPart) && wordBreak(secPart)) {
				return true;
			}
			
			
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words[]= {"i","like","sam","samsung","mobile"};
		String key="ilikesamsung";
		   for(int i=0; i<words.length;i++) {
			insert(words[i]);
		}
		   System.out.println(wordBreak(key));
	}

}
