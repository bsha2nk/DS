package com.bsha2nk.tree;

public class BinarySearchTree {
	
	Node root;
	
	public void add(int key) {
		root = add(root, key);
	}

	private Node add(Node node, int key) {
		if (node == null) {
			node = new Node(key);
		} else {
			if (key < node.key) {
				node.left = add(node.left, key);
			} else if (key > node.key) {
				node.right = add(node.right, key);
			}
		}
		
		return node;
	}
	
	public void delete(int key) {
		delete(root, key);
	}
	
	private Node delete(Node node, int key) {
		if (node == null) {
			return null;
		}
		
		if (key < node.key) {
			node = delete(node.left, key);
		} else if (key > node.key) {
			node = delete(node.right, key);
		} else {
			if (node.left == null || node.right == null) {
				return node.left == null ? node.right : node.left;
			} else {
				Node successor = getSuccessor(node.right);
				node.right = delete(node.right, successor.key);
				node.key = successor.key;
			}
		}
		
		return node;
	}



	private Node getSuccessor(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		
		return node;
	}



	private class Node implements Comparable<Node>{
		int key;
		Node left;
		Node right;

		public Node(int key) {
			this.key = key;
		}

		@Override
		public int compareTo(Node o) {
			return o.key - this.key;
		}

	}
}
