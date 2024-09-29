package trie;

public class Trie {
	
	private TrieNode root;
	
	private class TrieNode{
		
		private TrieNode[] children;
		private boolean isWord;
		
		public TrieNode() {
			this.children= new TrieNode[26];
			this.isWord=false;
		}
	}
	
	public Trie() {
		root= new TrieNode(); //root is Emplty
	}
	

	public void insert(String str) {
		str=str.toLowerCase();
		TrieNode curr = root;
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			int index = c-'a';
			if(curr.children[index]==null) {
				TrieNode node = new TrieNode();
				curr.children[index]=node;
				curr=node;
			}else {
				curr= curr.children[index];
			}
		}
		curr.isWord=true;
	}
	
	public boolean search(String str1) {
		str1=str1.toLowerCase();
		TrieNode curr = root;
		for( int i=0;i<str1.length();i++) {
			char c = str1.charAt(i);
			int index= c-'a';
			if(curr.children[index]==null)
				return false;
			curr=curr.children[index];
		}
		
		if( curr.isWord==false)
			return false;
		else
			return true;

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "karthikeyan";
		Trie obj = new Trie();
		obj.insert(str);
		obj.insert("karthik");
		obj.insert("Barat");
		System.out.println(obj.search("Barat"));
		
	}

}
