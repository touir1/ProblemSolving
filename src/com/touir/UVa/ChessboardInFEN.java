// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class ChessboardInFEN {

	/*
	 * problem: 10284 - Chessboard in FEN
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=612&page=show_problem&problem=1225
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		// comment next row and uncomment the one after before submitting
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/ChessboardInFEN.txt"));
		//Scanner scan = new Scanner(System.in);
		
		while(scan.hasNext()) {
			String[] input = scan.nextLine().split("/");
			
			boolean[][] occupied = new boolean[8][8];
			boolean[][] pieces = new boolean[8][8];
			//init
			int result = 64;
			for(int i=0;i<8;i++) {
				if(i >= input.length) break;
				int j=0,idx=0;
				while(j < 8) {
					char c = input[i].charAt(idx);
					if(c >= '1' && c <= '8') {
						j+=(c-'0');
					}
					else {
						occupied[i][j] = true;
						pieces[i][j] = true;
						result--;
						j++;
					}
					idx++;
				}
			}
			//compute
			for(int i=0;i<8;i++) {
				if(i >= input.length) break;
				int j=0,idx=0;
				while(j < 8) {
					char c = input[i].charAt(idx);
					if(c >= '1' && c <= '8') {
						j+=(c-'0');
					}
					else {
						if(c=='p' && i+1 < 8) {
							if(j+1<8) {
								if(!occupied[i+1][j+1]) result--;
								occupied[i+1][j+1]=true;
							}
							if(j-1>=0) {
								if(!occupied[i+1][j-1]) result--;
								occupied[i+1][j-1]=true;
							}
						}
						else if(c=='P' && i-1 >= 0) {
							if(j+1<8) {
								if(!occupied[i-1][j+1]) result--;
								occupied[i-1][j+1]=true;
							}
							if(j-1>=0) {
								if(!occupied[i-1][j-1]) result--;
								occupied[i-1][j-1]=true;
							}

						}
						else if(c == 'r' || c == 'R') {
							for(int k=j+1;k<8 && !pieces[i][k]; k++) {
								if(!occupied[i][k]) result--;
								occupied[i][k]=true;
							}
							for(int k=j-1;k>=0 && !pieces[i][k]; k--) {
								if(!occupied[i][k]) result--;
								occupied[i][k]=true;
							}
							for(int k=i+1;k<8 && !pieces[k][j]; k++) {
								if(!occupied[k][j]) result--;
								occupied[k][j]=true;
							}
							for(int k=i-1;k>=0 && !pieces[k][j]; k--) {
								if(!occupied[k][j]) result--;
								occupied[k][j]=true;
							}
						}
						else if(c == 'n' || c == 'N') {
							if(i+1<8 && j+2 <8 && !occupied[i+1][j+2]) {
								result--;
								occupied[i+1][j+2] = true;
							}
							if(i+1<8 && j-2 >=0 && !occupied[i+1][j-2]) {
								result--;
								occupied[i+1][j-2] = true;
							}
							if(i-1>=0 && j-2 >=0 && !occupied[i-1][j-2]) {
								result--;
								occupied[i-1][j-2] = true;
							}
							if(i-1>=0 && j+2 <8 && !occupied[i-1][j+2]) {
								result--;
								occupied[i-1][j+2] = true;
							}
							if(i+2<8 && j+1 <8 && !occupied[i+2][j+1]) {
								result--;
								occupied[i+2][j+1] = true;
							}
							if(i+2<8 && j-1 >=0 && !occupied[i+2][j-1]) {
								result--;
								occupied[i+2][j-1] = true;
							}
							if(i-2>=0 && j-1 >=0 && !occupied[i-2][j-1]) {
								result--;
								occupied[i-2][j-1] = true;
							}
							if(i-2>=0 && j+1 <8 && !occupied[i-2][j+1]) {
								result--;
								occupied[i-2][j+1] = true;
							}
						}
						else if(c=='b' || c == 'B') {
							for(int k=i+1, l=j+1; k<8 && l<8 && !pieces[k][l]; k++,l++) {
								if(!occupied[k][l])result--;
								occupied[k][l]=true;
							}
							for(int k=i+1, l=j-1; k<8 && l>=0 && !pieces[k][l]; k++,l--) {
								if(!occupied[k][l])result--;
								occupied[k][l]=true;
							}
							for(int k=i-1, l=j+1; k>=0 && l<8 && !pieces[k][l]; k--,l++) {
								if(!occupied[k][l])result--;
								occupied[k][l]=true;
							}
							for(int k=i-1, l=j-1; k>=0 && l>=0 && !pieces[k][l]; k--,l--) {
								if(!occupied[k][l])result--;
								occupied[k][l]=true;
							}
						}
						else if(c=='q' || c == 'Q') {
							for(int k=i+1, l=j+1; k<8 && l<8 && !pieces[k][l]; k++,l++) {
								if(!occupied[k][l])result--;
								occupied[k][l]=true;
							}
							for(int k=i+1, l=j-1; k<8 && l>=0 && !pieces[k][l]; k++,l--) {
								if(!occupied[k][l])result--;
								occupied[k][l]=true;
							}
							for(int k=i-1, l=j+1; k>=0 && l<8 && !pieces[k][l]; k--,l++) {
								if(!occupied[k][l])result--;
								occupied[k][l]=true;
							}
							for(int k=i-1, l=j-1; k>=0 && l>=0 && !pieces[k][l]; k--,l--) {
								if(!occupied[k][l])result--;
								occupied[k][l]=true;
							}
							for(int k=j+1;k<8 && !pieces[i][k]; k++) {
								if(!occupied[i][k])result--;
								occupied[i][k]=true;
							}
							for(int k=j-1;k>=0 && !pieces[i][k]; k--) {
								if(!occupied[i][k])result--;
								occupied[i][k]=true;
							}
							for(int k=i+1;k<8 && !pieces[k][j]; k++) {
								if(!occupied[k][j])result--;
								occupied[k][j]=true;
							}
							for(int k=i-1;k>=0 && !pieces[k][j]; k--) {
								if(!occupied[k][j])result--;
								occupied[k][j]=true;
							}
						}
						else if(c== 'k' || c == 'K'){
							if(i+1 < 8) {
								if(!occupied[i+1][j]) {
									result--;
									occupied[i+1][j]=true;
								}
								if(j+1<8 && !occupied[i+1][j+1]) {
									result--;
									occupied[i+1][j+1]=true;
								}
								if(j-1>=0 && !occupied[i+1][j-1]) {
									result--;
									occupied[i+1][j-1]=true;
								}
								
							}
							if(i-1 >= 0) {
								if(!occupied[i-1][j]) {
									result--;
									occupied[i-1][j]=true;
								}
								if(j+1<8 && !occupied[i-1][j+1]) {
									result--;
									occupied[i-1][j+1]=true;
								}
								if(j-1>=0 && !occupied[i-1][j-1]) {
									result--;
									occupied[i-1][j-1]=true;
								}
							}
							if(j+1 < 8 && !occupied[i][j+1]) {
								result--;
								occupied[i][j+1]=true;
							}
							if(j-1 >= 0 && !occupied[i][j-1]) {
								result--;
								occupied[i][j-1]=true;
							}
						}
						j++;
					}
					idx++;
				}
				
			}
			System.out.println(result);
		}
		
		
		scan.close();
	}

}
