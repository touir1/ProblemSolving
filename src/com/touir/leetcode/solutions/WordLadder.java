package com.touir.leetcode.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.touir.leetcode.Solution;

public class WordLadder extends Solution {

	/**
	 * problem: 127. Word Ladder
	 *
	 * url: https://leetcode.com/problems/word-ladder/
	 */

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
			return 0;

		Queue<String> queue = new LinkedList<String>();
		Set<String> words = new HashSet<String>(wordList), visited = new HashSet<String>();

		queue.add(beginWord);
		visited.add(beginWord);
		int queueSize, level = 1;
		String word, str;
		char[] w;

		while (!queue.isEmpty()) {
			queueSize = queue.size();
			while (queueSize-- > 0) {
				word = queue.poll();

				if (word.equals(endWord))
					return level;
				w = word.toCharArray();
				for (int i = 0; i < word.length(); i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						if (c == word.charAt(i))
							continue;
						w[i] = c;
						str = new String(w);
						if (!visited.contains(str) && words.contains(str)) {
							queue.add(str);
							visited.add(str);
						}
					}
					w[i] = word.charAt(i);
				}

			}
			level++;

		}

		return 0;
	}

	@Override
	public void test() {
		System.out.println(
				"result: " + this.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))
						+ ", expected: 5");
		System.out.println("result: "
				+ this.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")) + ", expected: 0");
	}

}
