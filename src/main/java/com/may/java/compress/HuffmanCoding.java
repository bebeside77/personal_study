package com.may.java.compress;

import java.util.ArrayList;
import java.util.Collections;
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

		List<TreeNode> treeNodeList = new ArrayList<>();
		for (Character character : countMap.keySet()) {
			TreeNode treeNode = new TreeNode();
			treeNode.c = character;
			treeNode.count = countMap.get(character);

			treeNodeList.add(treeNode);
		}

		Collections.sort(treeNodeList);
		Collections.reverse(treeNodeList);

		log.info("treeNodeList : " + treeNodeList);

		TreeNode lastNode = treeNodeList.get(treeNodeList.size() - 1);
		TreeNode preLastNode = treeNodeList.get(treeNodeList.size() - 2);
		int countSum = lastNode.count + preLastNode.count;

		TreeNode newTreeNode = new TreeNode();
		newTreeNode.count = countSum;
		BinaryTree.Node<TreeNode> newNode = new BinaryTree.Node<>(newTreeNode);
		newNode.left = new BinaryTree.Node<>(preLastNode);
		newNode.right = new BinaryTree.Node<>(lastNode);

		BinaryTree<TreeNode> huffmanTree = new BinaryTree<>(newNode);

		treeNodeList.remove(treeNodeList.size() - 1);
		treeNodeList.remove(treeNodeList.size() - 2);
		treeNodeList.add(newTreeNode);

		return "";
	}

	@ToString
	class TreeNode implements Comparable<TreeNode> {
		char c;
		int count;

		@Override
		public int compareTo(TreeNode treeNode) {
			if (this.count > treeNode.count) {
				return 1;
			} else if (this.count == treeNode.count) {
				return 0;
			}
			return -1;
		}
	}

}
