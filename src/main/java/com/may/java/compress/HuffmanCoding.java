package com.may.java.compress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author bebeside77
 */
@Slf4j
public class HuffmanCoding {

	public String encode(String input) {
		Map<Character, Integer> countMap = new HashMap<>();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			Integer count = countMap.get(c);
			if (count == null) {
				count = 0;
			}
			countMap.put(c, count + 1);
		}

		log.info("countMap : " + countMap);

		List<BinaryTree<TreeNode>> treeNodeList = new ArrayList<>();
		for (Character character : countMap.keySet()) {
			TreeNode treeNode = new TreeNode();
			treeNode.c = character;
			treeNode.count = countMap.get(character);
			BinaryTree.Node<TreeNode> newNode = new BinaryTree.Node<>(treeNode);
			BinaryTree<TreeNode> huffmanTree = new BinaryTree<>(newNode);

			treeNodeList.add(huffmanTree);
		}

		while (treeNodeList.size() >= 2) {
			treeNodeList.sort((tree1, tree2) -> {
				TreeNode treeNode1 = tree1.getRoot().getData();
				TreeNode treeNode2 = tree2.getRoot().getData();

				return (treeNode1.count - treeNode2.count) * -1; // descending by count
			});

			log.info("treeNodeList : " + treeNodeList);

			BinaryTree<TreeNode> lastNode = treeNodeList.get(treeNodeList.size() - 1);
			BinaryTree<TreeNode> preLastNode = treeNodeList.get(treeNodeList.size() - 2);
			int countSum = lastNode.getRoot().getData().getCount() + preLastNode.getRoot().getData().getCount();

			TreeNode newTreeNode = new TreeNode();
			newTreeNode.count = countSum;
			BinaryTree.Node<TreeNode> newNode = new BinaryTree.Node<>(newTreeNode);
			newNode.setLeft(new BinaryTree.Node<>(preLastNode.getRoot().getData()));
			newNode.setRight(new BinaryTree.Node<>(lastNode.getRoot().getData()));

			treeNodeList.remove(treeNodeList.size() - 1);
			treeNodeList.remove(treeNodeList.size() - 1);

			treeNodeList.add(new BinaryTree<>(newNode));
		}

		log.info("treeNodeList : " + treeNodeList);

		return "";
	}

	@ToString
	class TreeNode {
		private char c;
		private int count;

		public char getC() {
			return c;
		}

		public int getCount() {
			return count;
		}
	}

}
