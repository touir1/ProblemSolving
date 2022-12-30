// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class TheSnail {

	/*
	 * problem: 573 - The Snail
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=609&page=show_problem&problem=514
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		// comment next row and uncomment the one after before submitting
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/TheSnail.txt"));
		//Scanner scan = new Scanner(System.in);
		
		while(true) {
			double height = scan.nextInt(), dayClimb = scan.nextInt(), nightSlide = scan.nextInt(), fatigueFactor = scan.nextInt();
			
			if(height == 0) break;
			
			fatigueFactor /= 100;
			int day = 0;
			double progress = 0, climb = dayClimb + (dayClimb * fatigueFactor);
			while(true) {
				day++;
				climb -= dayClimb * fatigueFactor;
				if(climb <= 0) climb = 0;
				
				progress += climb;
				if(progress > height) {
					System.out.println("success on day " + day);
					break;
				}
				
				progress -= nightSlide;
				if(progress < 0) {
					System.out.println("failure on day " + day);
					break;
				}
			}
			
		}
		
		
		scan.close();
	}

}
