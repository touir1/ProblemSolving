package com.touir.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

import com.touir.leetcode.Solution;

public class CloneGraph extends Solution {

	/*
	 * problem: 133. Clone Graph
	 *
	 * url: https://leetcode.com/problems/clone-graph/
	 */

	public Node cloneGraph(Node node) {
		if (node == null)
			return null;
		Node[] visited = new Node[101];
		Node copy = new Node(node.val);
		dfs(node, copy, visited);
		return copy;
	}

	private void dfs(Node node, Node copy, Node[] visited) {
		visited[node.val] = copy;
		for (int i = 0; i < node.neighbors.size(); i++) {
			if (visited[node.neighbors.get(i).val] == null) {
				Node newNode = new Node(node.neighbors.get(i).val);
				copy.neighbors.add(newNode);
				dfs(node.neighbors.get(i), newNode, visited);

			} else {
				copy.neighbors.add(visited[node.neighbors.get(i).val]);
			}
		}
	}

	@Override
	public void test() {
		// System.out.println("");

	}

	// Definition for a Node.
	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

}
