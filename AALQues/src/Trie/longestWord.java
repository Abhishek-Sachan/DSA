package Trie;



public class longestWord {
	
	// LONGEST WORD WITH ALL PREFIXES
	// find longest string in words such that every prefix of it is also in words
	// always find lexicographically(ascending order), means e<y
	
	
	
	
	
	

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
	
	public static String ans=" ";
	public static void longestWord(Node root, StringBuilder temp) {
		if(root==null) {
			return ;
		}
		for(int i=0;i<26;i++) {
			if(root.children[i]!=null && root.children[i].endOfWord==true) {
				temp.append((char)(i+'a'));
				// char is type cast, because integer+char=integer
				// 1+'a'='b'
				if(temp.length()> ans.length()) {
					ans=temp.toString();
				}
				longestWord(root.children[i], temp);
				temp.deleteCharAt(temp.length()-1);
				
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words[]= {"a","banana","app","appl","ap","apply","apple"};
		   for(int i=0; i<words.length;i++) {
			insert(words[i]);
		}
		   longestWord(root, new StringBuilder(" "));
		   System.out.println(ans);
	}

}
