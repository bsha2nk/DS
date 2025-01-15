package com.trie;

public class TrieMain {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("dead");
		trie.insert("deadly");
		trie.insert("deader");
		trie.insert("deed");
		trie.insert("dear");
		
		System.out.println(trie.autoComplete("dear"));
	}
}
