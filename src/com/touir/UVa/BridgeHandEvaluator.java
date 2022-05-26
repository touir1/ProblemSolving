// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class BridgeHandEvaluator {

	/*
	 * problem: 462 - Bridge Hand Evaluator
	 *
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=611&page=show_problem&problem=403
	 *
	 */

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/BridgeHandEvaluator.txt"));
		//Scanner scan = new Scanner(System.in);

		while(scan.hasNext()) {
			String[] cards = scan.nextLine().split(" ");
			int points = 0;
			int[][] count = new int[4][5];
			int countMaxSuit = 0, maxSuit = 0;

			for(int i=0;i<cards.length;i++) {
				int card = convertCardToInt(cards[i]);
				int rank = card%13 == 0? 13 : card%13, suit = card / 13 - (card%13 == 0 ? 1 : 0);

				count[suit][0]++;

				if(rank == 1) {
					points += 4;
					count[suit][4] = 1;
				}
				if(rank > 10) {
					points += rank - 10;
					count[suit][rank - 10] = 1;
				}

			}

			for(int i=0;i<4;i++) {
				if(count[i][3] == 1 && count[i][0] == 1) points--;
				if(count[i][2] == 1 && count[i][0] < 3) points--;
				if(count[i][1] == 1 && count[i][0] < 4) points--;

				if(count[i][0] > countMaxSuit) {
					countMaxSuit = count[i][0];
					maxSuit = i;
				}
			}
			boolean canNoTrump = points >= 16;
			boolean stopped = true;
			for(int i=0;i<4;i++) {
				stopped = stopped && (count[i][4] == 1 || (count[i][3] == 1 && count[i][0] > 1) || (count[i][2] == 1 && count[i][0] > 2));
				points += count[i][0] == 2 ? 1 : count[i][0] < 2 ? 2 : 0;
			}
			canNoTrump = canNoTrump && stopped;

			if(points < 14) {
				System.out.println("PASS");
			}
			else if(canNoTrump) {
				System.out.println("BID NO-TRUMP");
			}
			else {
				System.out.println("BID " + (maxSuit == 0 ? "S" : maxSuit == 1? "H" : maxSuit == 2? "D" : "C"));
			}
		}


		scan.close();
	}

	public static int convertCardToInt(String card) {
		int result = 0;
		result += card.charAt(0) == 'A'? 1 :
			card.charAt(0) == 'T'? 10 :
				card.charAt(0) == 'J' ? 11 :
					card.charAt(0) == 'Q' ? 12 :
						card.charAt(0) == 'K' ? 13 :
							card.charAt(0) - '0';
		result += card.charAt(1) == 'S' ? 0:
			card.charAt(1) == 'H' ? 13:
				card.charAt(1) == 'D' ? 13*2: 13*3;
		return result;
	}

}
