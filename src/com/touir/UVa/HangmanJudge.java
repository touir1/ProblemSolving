// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class HangmanJudge {

	/*
	 * problem: 489 - Hangman Judge
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=613&page=show_problem&problem=430
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		// comment next row and uncomment the one after before submitting
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/HangmanJudge.txt"));
		//Scanner scan = new Scanner(System.in);
		
		
		
		while(true) {
			String round = scan.nextLine();
			if("-1".equals(round)) break;
			
			String word = scan.nextLine();
			String guess = scan.nextLine();
			int letters = 0, found = 0, guessed = 0;
			
			for(char c : word.toCharArray()) {
				letters |= (1 << c-'a');
			}
			
			int wrongGuess = 0;
			for(char c : guess.toCharArray()) {
				int l = c-'a';
				if((letters & (1 << l)) == 0 && (guessed & (1 << l)) == 0) {
					wrongGuess++;
					guessed |= (1 << l);
				}
				if((letters & (1 << l)) != 0) {
					found |= (1 << l);
				}
				if(wrongGuess>= 7) break;
				if(found == letters) break;
			}
			System.out.println("Round "+round);
			if(wrongGuess >= 7) {
				System.out.println("You lose.");
			}
			else if(found == letters) {
				System.out.println("You win.");
			}
			else {
				System.out.println("You chickened out.");
			}
		}
		
		
		scan.close();
	}

}
