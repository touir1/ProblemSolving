// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class CombinationLock {

	/*
	 * problem: 10550 - Combination Lock
	 * 
	 * url: https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=1491
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/CombinationLock.txt"));
		//Scanner scan = new Scanner(System.in);
		
		while(scan.hasNext()) {
			int result = 360*3, startingPoint = scan.nextInt();
			int[] code = new int[3];
			
			for(int i=0;i<3;i++) {
				code[i] = scan.nextInt();
			}

			if(startingPoint + code[0] + code[1] + code[2] == 0)
				break;
			
			result += code[0] <= startingPoint ? ((startingPoint - code[0])*360)/40 : ((startingPoint + 40 - code[0])*360)/40;
			result += code[1] >= code[0] ? ((code[1] - code[0])*360)/40 : ((code[1] + 40 - code[0])*360)/40;
			result += code[2] <= code[1] ? ((code[1] - code[2])*360)/40 : ((code[1] + 40 - code[2])*360)/40;
			
			System.out.println(result);
		}
		
		scan.close();
	}

}
