package com.touir.google.kickstart.h2021;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class TransformTheString {

	public static void main(String[] args) {
		File file = new File("./src/com/touir/google/kickstart/h2021/input/TransformTheString_2.txt");

		try {
			Scanner in = new Scanner(file); // System.in //file
			int n = Integer.valueOf(in.nextLine());

			for (int i = 1; i <= n; i++) {
				String str = in.nextLine();
				String favorite = in.nextLine();
				int result = 0;

				int[] minDistance = new int[26];
				Arrays.fill(minDistance, 13);

				for (int j = 0; j < favorite.length(); j++) {
					for (char k = 'a'; k <= 'z'; k++) {
						minDistance[k - 'a'] = Math.min(26 - Math.abs(k - favorite.charAt(j)),
								Math.min(minDistance[k - 'a'], Math.abs(k - favorite.charAt(j))));
					}
				}
				for (int j = 0; j < str.length(); j++) {
					result += minDistance[str.charAt(j) - 'a'];
				}
				System.out.println("Case #" + i + ": " + result);
			}

			in.close();
		} catch (Exception e) {
		}

	}

}
