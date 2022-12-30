// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class Jollo {

	/*
	 * problem: 12247 - Jollo
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=611&page=show_problem&problem=3399
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		// comment next row and uncomment the one after before submitting
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/Jollo.txt"));
		//Scanner scan = new Scanner(System.in);
		
		int a,b,c,x,y, result;
		
		while(true) {
			a = scan.nextInt();
			b = scan.nextInt();
			c = scan.nextInt();
			x = scan.nextInt();
			y = scan.nextInt();
			
			if(a == 0) break;
			
			if((x < a && (y < b || y < c)) || (x < b && (y < a || y < c)) || (x < c && (y < a || y < b))) {
				System.out.println(-1);
				continue;
			}
			
			result = -1;

			if(x < a || y < a) result = Math.max(getNext(a,b,c,x,y,Math.max(b, c)+1), result);
			if(x < b || y < b) result = Math.max(getNext(a,b,c,x,y,Math.max(a, c)+1), result);
			if(x < c || y < c) result = Math.max(getNext(a,b,c,x,y,Math.max(a, b)+1), result);
			
			if(x > Math.max(a, Math.max(b, c)) && y > Math.max(a, Math.max(b, c))) result = getNext(a,b,c,x,y,1);
			
			System.out.println(result);
		}
		
		
		scan.close();
	}
	
	private static int getNext(int a, int b, int c, int x, int y, int start) {
		while(start == a || start == b || start == c || start == x || start == y) start++;
		return start != 53 ? start : -1;
	}

}
