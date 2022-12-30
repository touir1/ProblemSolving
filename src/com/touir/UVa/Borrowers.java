// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//change classname to Main before submitting
public class Borrowers {

	/*
	 * problem: 230 - Borrowers
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=623&page=show_problem&problem=166
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		// comment next row and uncomment the one after before submitting
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/Borrowers.txt"));
		//Scanner scan = new Scanner(System.in);
		
		List<Book> books = new ArrayList<Book>();
		
		// books input
		while(true) {
			String input = scan.nextLine();
			if("END".equals(input)) break;
			
			books.add(new Book(input));
		}
		Collections.sort(books);
		
		// creating index for the book name
		Map<String, Integer> index = new HashMap<String, Integer>();
		for(int i = 0; i< books.size(); i++) {
			index.put(books.get(i).name, i);
		}
		
		// operations
		while(true) {
			String input = scan.nextLine();
			if("END".equals(input)) break;
			
			if("SHELVE".equals(input)) {
				Book previous = null;
				
				for(int i=0;i<books.size();i++) {
					Book current = books.get(i);
					if(!current.borrowed) {
						previous = current;
						continue;
					}
					if(current.returned) {
						current.borrowed = false;
						current.returned = false;
						if(previous != null) {
							System.out.println("Put "+current.name + " after "+previous.name);
						}
						else {
							System.out.println("Put "+current.name + " first");
						}
						previous = current;
					}
					
				}
				System.out.println("END");
			}
			
			if(input.startsWith("BORROW")) {
				books.get(index.get(input.substring(7))).borrowed = true;
			}
			if(input.startsWith("RETURN")) {
				int idx = index.get(input.substring(7));
				books.get(idx).returned = true;
			}
		}
		
		scan.close();
	}
	
	public static class Book implements Comparable<Book> {
		public String name;
		public String author;
		public boolean borrowed;
		public boolean returned;
		
		public Book(String input) {
			String[] split = input.split(" by ");
			this.name = split[0];
			this.author = split[1];
			this.borrowed = false;
			this.returned = false;
		}
		
		@Override
		public int compareTo(Book book) {
			if(book == null) return 1;
			// sort with author then name of book
			return !this.author.equals(book.author)? this.author.compareTo(book.author) : this.name.compareTo(book.name);
		}
	}
}
