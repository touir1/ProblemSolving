package com.touir.google.kickstart.practice2022;

import java.util.Scanner;

public class SampleProblem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int testCases = scan.nextInt();
		for (int i = 1; i <= testCases; i++) {
			int n = scan.nextInt();
			int kids = scan.nextInt();

			int candies = 0;

			for (int j = 0; j < n; j++) {
				candies += scan.nextInt();
			}

			System.out.println("Case #" + i + ": " + (candies % kids));
		}

		scan.close();
	}

}
