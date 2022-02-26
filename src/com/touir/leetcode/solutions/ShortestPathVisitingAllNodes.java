package com.touir.leetcode.solutions;

import java.util.LinkedList;
import java.util.Queue;

import com.touir.leetcode.Solution;

public class ShortestPathVisitingAllNodes extends Solution {

	/**
	 * problem: 847. Shortest Path Visiting All Nodes
	 *
	 * url: https://leetcode.com/problems/shortest-path-visiting-all-nodes/
	 */

	public int shortestPathLength(int[][] graph) {
		int n = graph.length;
		if (n <= 1)
			return 0;

		Queue<int[]> queue = new LinkedList<>();

		int target = (1 << n) - 1;
		boolean[][] visited = new boolean[n][target];
		int visitedMask, node, mask;

		for (int i = 0; i < n; i++) {
			visitedMask = (1 << i);
			queue.add(new int[] { i, visitedMask });
			visited[i][visitedMask] = true;
		}
		int result = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int[] c = queue.poll();
				node = c[0];
				mask = c[1];

				for (int i = 0; i < graph[node].length; i++) {
					visitedMask = mask | (1 << graph[node][i]);
					if (visitedMask == target)
						return result + 1;

					if (!visited[graph[node][i]][visitedMask]) {
						queue.add(new int[] { graph[node][i], visitedMask });
						visited[graph[node][i]][visitedMask] = true;
					}
				}
			}
			result++;
		}
		return 0;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.shortestPathLength(new int[][] { { 1, 2, 3 }, { 0 }, { 0 }, { 0 } })
				+ ", expected: 4");
		System.out.println(
				"result: " + this.shortestPathLength(new int[][] { { 1 }, { 0, 2, 4 }, { 1, 3, 4 }, { 2 }, { 1, 2 } })
						+ ", expected: 4");
		System.out.println("result: "
				+ this.shortestPathLength(new int[][] { { 1 }, { 0, 2, 4 }, { 1, 3 }, { 2 }, { 1, 5 }, { 4 } })
				+ ", expected: 6");
		System.out
				.println(
						"result: "
								+ this.shortestPathLength(new int[][] { { 1, 4 }, { 0, 3, 10 }, { 3 }, { 1, 2, 6, 7 },
										{ 0, 5 }, { 4 }, { 3 }, { 3 }, { 10 }, { 10 }, { 1, 9, 8 } })
								+ ", expected: 15");
		System.out.println("result: " + this.shortestPathLength(new int[][] { {} }) + ", expected: 0");

	}

}
