package com.may.java.compress;

/**
 *
 * @author bebeside77
 */
public class BinaryTree<T> {
	private Node<T> root;

	public BinaryTree(Node<T> root) {
		this.root = root;
	}

	static class Node<T> {
		T data;
		Node<T> left;
		Node<T> right;

		public Node(T data) {
			this.data = data;
		}
	}

}
