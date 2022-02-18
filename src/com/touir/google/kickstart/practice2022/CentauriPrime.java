package com.touir.google.kickstart.practice2022;

import java.util.Arrays;
import java.util.Scanner;

public class CentauriPrime {

	private static String getRuler(String kingdom) {
		char lastLetter = Character.toLowerCase(kingdom.charAt(kingdom.length() - 1));
		if (lastLetter == 'y')
			return "nobody";
		if (Arrays.asList('a', 'o', 'u', 'i', 'e').contains(lastLetter))
			return "Alice";
		return "Bob";
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int T = in.nextInt();

			for (int t = 1; t <= T; ++t) {
				String kingdom = in.next();
				System.out.println("Case #" + t + ": " + kingdom + " is ruled by " + getRuler(kingdom) + ".");
			}
		}
	}

}
