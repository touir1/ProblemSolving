package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class SearchWordsDataStructure extends Solution {

	/**
	 * problem: 211. Design Add and Search Words Data Structure
	 *
	 * url:
	 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
	 *
	 */

	class WordDictionary {

		TreeNode root;

		public WordDictionary() {
			root = new TreeNode();
		}

		public void addWord(String word) {
			TreeNode pointer = root;
			for (char c : word.toCharArray()) {
				if (pointer.children == null)
					pointer.children = new TreeNode[26];
				if (pointer.children[c - 97] == null)
					pointer.children[c - 97] = new TreeNode();
				pointer = pointer.children[c - 97];
			}
			pointer.end = true;
		}

		public boolean search(String word) {
			return search(word, root, 0);
		}

		private boolean search(String word, TreeNode node, int idx) {
			if (node == null)
				return false;
			if (idx >= word.length())
				return node.end;
			if (node.children == null)
				return false;

			if (word.charAt(idx) != '.')
				return search(word, node.children[word.charAt(idx) - 97], idx + 1);

			for (TreeNode n : node.children) {
				if (search(word, n, idx + 1))
					return true;
			}
			return false;
		}

		private class TreeNode {
			boolean end;
			TreeNode[] children;

			TreeNode() {
			}
		}
	}

	@Override
	public void test() {
		WordDictionary ds = new WordDictionary();
		ds.addWord("bad");
		ds.addWord("dad");
		ds.addWord("mad");
		System.out.println("result: " + ds.search("pad") + ", expected: false");
		System.out.println("result: " + ds.search("bad") + ", expected: true");
		System.out.println("result: " + ds.search(".ad") + ", expected: true");
		System.out.println("result: " + ds.search("b..") + ", expected: true");
		ds = new WordDictionary();
		ds.addWord("a");
		ds.addWord("ab");
		System.out.println("result: " + ds.search("a") + ", expected: true");
		System.out.println("result: " + ds.search("a.") + ", expected: true");
		System.out.println("result: " + ds.search("ab") + ", expected: true");
		System.out.println("result: " + ds.search(".a") + ", expected: false");
		System.out.println("result: " + ds.search(".b") + ", expected: true");
		System.out.println("result: " + ds.search("ab.") + ", expected: false");
		System.out.println("result: " + ds.search(".") + ", expected: true");
		System.out.println("result: " + ds.search("..") + ", expected: true");
	}

}
