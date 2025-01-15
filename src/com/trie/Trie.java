package com.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

	Node root;

	public Trie() {
		this.root = new Node();
	}

	public void insert(String word) {
		Node curNode = root;
		char[] arr = word.toCharArray();

		for(char c : arr) {
			if(!curNode.children.containsKey(c)) {
				curNode.children.put(c, new Node());
			}

			curNode = curNode.children.get(c);
		}

		curNode.isWord = true;
	}

	public boolean search(String word) {
		Node curNode = root;
		char[] arr = word.toCharArray();

		for(char c : arr) {
			if(!curNode.children.containsKey(c)) {
				return false;
			}

			curNode = curNode.children.get(c);
		}

		return curNode.isWord;
	}

	public boolean startsWith(String prefix) {
		Node curNode = root;
		char[] arr = prefix.toCharArray();
		
		for(char c : arr) {
			if(!curNode.children.containsKey(c)) {
				return false;
			}
			
			curNode = curNode.children.get(c);
		}
		
		return true;
	}
	
	public List<String> autoComplete(String prefix) {
		List<String> autoPromptWords = new ArrayList<String>();
		
		Node node = root;
		for (char c : prefix.toCharArray()) {
			if (node.children.containsKey(c)) {
				node = node.children.get(c);
			} else {
				return autoPromptWords;
			}
		}
		
		addAutoPropmtWords(node, autoPromptWords, prefix);
		
		return autoPromptWords;
	}

	private void addAutoPropmtWords(Node node, List<String> autoPromptWords, String word) {
		if (node == null) {
			return;
		}
		
		if (node.isWord) {
			autoPromptWords.add(word);
		}
		
		for (char c : node.children.keySet()) {
			addAutoPropmtWords(node.children.get(c), autoPromptWords, word + c);
		}
	}

	class Node {
		Map<Character, Node> children = new HashMap<>();
		public boolean isWord = false;
	}

}
