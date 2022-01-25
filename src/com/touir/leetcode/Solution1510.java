package com.touir.leetcode;

public class Solution1510 extends Solution {

	// problem: https://leetcode.com/problems/stone-game-iv/

	Boolean dp[] = new Boolean[100001];

	public boolean winnerSquareGame(int n) {

		if (dp[n] != null)
			return dp[n];

		boolean result = false;

		for (int i = 1; i * i <= n; i++) {
			if (!winnerSquareGame(n - i * i)) {
				result = true;
				break;
			}
		}

		return (dp[n] = result);
	}

	@Override
	public void test() {
		System.out.println("result: " + this.winnerSquareGame(1) + ", expected: true");
		System.out.println("result: " + this.winnerSquareGame(2) + ", expected: false");
		System.out.println("result: " + this.winnerSquareGame(4) + ", expected: true");
	}

}
