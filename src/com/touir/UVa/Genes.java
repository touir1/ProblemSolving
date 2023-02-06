// remove package before submitting
package com.touir.UVa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

//change classname to Main before submitting
public class Genes {

	/*
	 * problem: 939 - Genes
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=631&page=show_problem&problem=880
	 */
	
	public static final int INIT = -1; // not initialized
	public static final int DOM = 2;//"dominant";
	public static final int REC = 1;//"recessive";
	public static final int NON = 0;//"non-existant";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// comment next row and uncomment the one after before submitting
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/Genes.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input;
		
		int n = Integer.parseInt(in.readLine());
		TreeMap<String, Child> map = new TreeMap<>();
		
		List<String> genes = Arrays.asList("non-existent", "recessive", "dominant");
		
		for(int i=0;i<n;i++) {
			input = in.readLine().split(" ");
			
			Child child = null;//map.getOrDefault(input[0], new Child());
			String name = null;
			if(genes.contains(input[1])) {
				name = input[0];
				child = map.getOrDefault(name, new Child());
				child.gene = input[1].charAt(0) == 'd' ? DOM : input[1].charAt(0) == 'r' ? REC : NON;
			}
			else {
				name = input[1];
				child = map.getOrDefault(name, new Child());
				if(child.parents[0] != null)
					child.parents[1] = input[0];
				else
					child.parents[0] = input[0];
			}
			
			map.put(name, child);
		}
		
		for(Map.Entry<String, Child> entry : map.entrySet()) {
			computeGene(entry.getValue(), map);
			out.append(entry.getKey() + " " + genes.get(entry.getValue().gene) + "\n");
		}
		
		out.close();
		in.close();
	}
	
	public static class Child {
		public int gene;
		public String[] parents;
		
		public Child() {
			this.gene = INIT;
			this.parents = new String[2];
		}
	}
	
	public static void computeGene(Child child, TreeMap<String, Child> map) {
		if(child == null || child.gene != INIT)
			return;
		Child parent1 = map.get(child.parents[0]);
		Child parent2 = map.get(child.parents[1]);
		
		if(parent1.gene == INIT)
			computeGene(parent1, map);
		if(parent2.gene == INIT)
			computeGene(parent2, map);
		
		if((parent1.gene > NON && parent2.gene > NON) || parent1.gene == DOM || parent2.gene == DOM){
			if((parent1.gene <= REC && parent2.gene <= REC )|| parent1.gene == NON || parent2.gene == NON)
				child.gene = REC;
			else
				child.gene = DOM;
		}
		else
			child.gene = NON;
		
	}

}
