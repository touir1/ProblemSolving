// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class LanguageDetection {

	/*
	 * problem: 12250 - Language Detection
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=607&page=show_problem&problem=3402
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		// comment next row and uncomment the one after before submitting
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/LanguageDetection.txt"));
		//Scanner scan = new Scanner(System.in);
		int cases = 1;
		while(true) {
			String input = scan.nextLine();
			
			if("#".equals(input)) break;
			if("HELLO".equals(input)) System.out.println("Case "+cases+": ENGLISH");
			else if("HOLA".equals(input)) System.out.println("Case "+cases+": SPANISH");
			else if("HALLO".equals(input)) System.out.println("Case "+cases+": GERMAN");
			else if("BONJOUR".equals(input)) System.out.println("Case "+cases+": FRENCH");
			else if("CIAO".equals(input)) System.out.println("Case "+cases+": ITALIAN");
			else if("ZDRAVSTVUJTE".equals(input)) System.out.println("Case "+cases+": RUSSIAN");
			else System.out.println("Case "+cases+": UNKNOWN");
			
			cases++;
		}
		
		
		scan.close();
	}

}
