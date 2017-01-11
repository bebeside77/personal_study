package com.may.java.compress;

import lombok.ToString;

/**
 *
 * @author bebeside77
 */
@ToString
public class BinaryTree<T> {
	private Node<T> root;

	public Node<T> getRoot() {
		return root;
	}

	public BinaryTree(Node<T> root) {
		this.root = root;
	}

	@ToString
	static class Node<T> {
		private T data;
		private Node<T> left;
		private Node<T> right;

		public Node(T data) {
			this.data = data;
		}

		public T getData() {
			return data;
		}

		public Node<T> getLeft() {
			return left;
		}

		public Node<T> getRight() {
			return right;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}
	}

}
