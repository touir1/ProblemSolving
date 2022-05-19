// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class DivisionOfNlogonia {

	/*
	 * problem: 11498 - Division of Nlogonia
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=607&page=show_problem&problem=2493
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/DivisionOfNlogonia.txt"));
		//Scanner scan = new Scanner(System.in);
		
		while(scan.hasNext()) {
			int k = scan.nextInt();
			
			if(k == 0) break;
			
			int n = scan.nextInt(), m = scan.nextInt();
			
			while(k-- > 0) {
				int x = scan.nextInt(), y = scan.nextInt();

				if(x == n || y == m) System.out.println("divisa");
				else if(x > n && y > m) System.out.println("NE");
				else if(x > n && y < m) System.out.println("SE");
				else if(x < n && y > m) System.out.println("NO");
				else System.out.println("SO");
			}
		}
		
		
		scan.close();
	}

}
