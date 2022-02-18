package com.touir.google.kickstart.practice2022;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class HIndex {

	public static int[] getHIndexScore(int[] citationsPerPaper) {
		int[] hIndex = new int[citationsPerPaper.length];
		Queue<Integer> queue = new PriorityQueue<>((a, b) -> -1 * a.compareTo(b));

		for (int i = 0; i < citationsPerPaper.length; i++) {
			queue.add(citationsPerPaper[i]);
			int hi = 0;
			Queue<Integer> copy = new PriorityQueue<>(queue);
			while (!queue.isEmpty()) {
				int p = queue.poll();
				if (hi >= p)
					break;
				hi++;
			}
			queue = copy;
			hIndex[i] = hi;
		}

		return hIndex;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Get number of test cases in input
		int testCaseCount = scanner.nextInt();
		// Iterate through test cases
		for (int tc = 1; tc <= testCaseCount; ++tc) {
			// Get number of papers for this test case
			int paperCount = scanner.nextInt();
			// Get number of citations for each paper
			int[] citations = new int[paperCount];
			for (int p = 0; p < paperCount; ++p) {
				citations[p] = scanner.nextInt();
			}
			// Print h-index score after each paper in this test case
			System.out.print("Case #" + tc + ":");
			for (int score : getHIndexScore(citations)) {
				System.out.append(" ").print(score);
			}
			System.out.println();
		}

		scanner.close();
	}

}
