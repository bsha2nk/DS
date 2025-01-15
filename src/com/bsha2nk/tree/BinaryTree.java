package com.bsha2nk.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	Node root;

	public void add(int key) {
		root = add(root, key);
	}

	private Node add(Node node, int key) {
		if(node == null) {
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

	//	public void add(int key) {
	//
	//		Node newNode = new Node(key);
	//
	//		if(root == null) {
	//			root = newNode;
	//		} else {
	//			Node focusNode = root;
	//			Node parent;
	//
	//			while (true) {
	//				parent = focusNode;
	//
	//				if (key < focusNode.key) {
	//					focusNode = focusNode.left;
	//
	//					if (focusNode == null) {
	//						parent.left = newNode;
	//						return;
	//					}
	//				} else {
	//					focusNode = focusNode.right;
	//
	//					if (focusNode == null) {
	//						parent.right = newNode;
	//						return;
	//					}
	//				}
	//			}
	//		}
	//
	//	}

	public void delete(int key) {
		delete(root, key);
	}

	private Node delete(Node node, int key) {
		if(node == null) {
			return null;
		}

		if(key < node.key) {
			node.left = delete(node.left, key);
		} else if (key > node.key) {
			node.right = delete(node.right, key);
		} else {
			if(node.left == null || node.right == null) {
				Node temp = node.left == null ? node.right : node.left;

				if (temp == null) {
					return null;
				} else {
					return temp;
				}
			} else {
				Node successorNode = successor(node.right);
				node.right = delete(node.right, successorNode.key);
				node.key = successorNode.key;
			}
		}

		return node;
	}

	private Node successor(Node node) {

		Node temp = node;
		while(temp.left != null) {
			temp = temp.left;
		}

		return temp;
	}

	public Integer findNode(int key) {

		Node focusNode = root;

		while(focusNode.key != key) {

			if(key < focusNode.key) {
				focusNode = focusNode.left;
			} else {
				focusNode = focusNode.right;
			}

			if(focusNode == null) {
				return null;
			}
		}

		return focusNode.key;
	}

	public void traversal() {
		//		System.out.println("In Order Traversal");
		//		inOrderTraversal(root);
		//		System.out.println();

		System.out.println("Level order traversal");
		levelOrderTraversal(root);

		//		System.out.println("\nPre Order Traversal");
		//		preOrderTraversal(root);
		//		
		//		System.out.println("\nPost Order Traversal");
		//		postOrderTraversal(root);
	}

	public void levelOrderTraversal(Node node) {

		if(node == null) {
			return;
		}

		Queue<Node> q = new LinkedList<>();
		q.add(node);

		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.left != null) q.add(cur.left);
			if(cur.right != null) q.add(cur.right); 			

			System.out.print(cur.key + " ");
		}
	}
	
	public void inOrderTraversal() {
		inOrderTraversal(root);
	}

	private void inOrderTraversal(Node node) {
		if(node == null) {
			return;
		}

		inOrderTraversal(node.left);
		System.out.print(node.key + " ");
		inOrderTraversal(node.right);
	}

	private void preOrderTraversal(Node node) {

		System.out.print(node.key + " ");

		if (node.left != null) {
			preOrderTraversal(node.left);
		}

		if (node.right != null) {
			preOrderTraversal(node.right);
		}
	}
	
	public void postOrderTraversal() {
		postOrderTraversal(root);
	}

	private void postOrderTraversal(Node node) {
		if(node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.key + " ");
		}
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
