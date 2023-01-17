// remove package before submitting
package com.touir.UVa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

//change classname to Main before submitting
public class AnagramsByStack {

	/*
	 * problem: 732 - Anagrams by Stack
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=628&page=show_problem&problem=673
	 */
	
	public static BufferedReader in;
	public static BufferedWriter out;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// comment next row and uncomment the one after before submitting
		in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/AnagramsByStack.txt"));
		//in = new BufferedReader(new InputStreamReader(System.in));

		out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String word, anagram;
		
		while((word = in.readLine()) != null) {
			anagram = in.readLine();
			
			if(word.length() != anagram.length()) {
				out.append("[\n]\n");
				continue;
			}
			
			int[] wordCount = new int[257], anagramCount = new int[257];
			for(int i=0;i<word.length();i++) {
				wordCount[word.charAt(i)]++;
				anagramCount[anagram.charAt(i)]++;
			}
			boolean noAnagram = false;
			for(int i=0;i<wordCount.length;i++) {
				if(wordCount[i] != anagramCount[i]) {
					noAnagram = true;
					break;
				}
			}
			if(noAnagram) {
				out.append("[\n]\n");
				continue;
			}
			
			out.append("[\n");
			anagram(new LinkedList<Character>(),new Stack<Character>(),0,0,word,anagram);
			out.append("]\n");
		}
		
		out.close();
		in.close();
	}
	
	public static void anagram(LinkedList<Character> operations, Stack<Character> stack, int wordIndex, int anagramIndex, 
			String word, String anagram) throws IOException {
		if(anagramIndex == anagram.length()) {
			for(Iterator<Character> it= operations.iterator();it.hasNext();) {
				char c = it.next();
				out.append(c + (it.hasNext()?" ":"\n"));
			}
			return;
		}
		if(wordIndex < word.length()) {
			operations.addLast('i');
			stack.push(word.charAt(wordIndex));
			anagram(operations,stack,wordIndex+1,anagramIndex,word,anagram);
			operations.removeLast();
			stack.pop();
		}
		if(!stack.isEmpty() && stack.peek() == anagram.charAt(anagramIndex)) {
			char c = stack.pop();
			operations.addLast('o');
			anagram(operations,stack,wordIndex,anagramIndex+1,word,anagram);
			stack.push(c);
			operations.removeLast();
		}
	}

}
