// remove package before submitting
package com.touir.UVa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

//change classname to Main before submitting
public class HeadJudgeHeadache {

	/*
	 * problem: 790 - Head Judge Headache
	 * 
	 * url: https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&category=625&page=show_problem&problem=731
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/HeadJudgeHeadache.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(in.readLine());
		
		// flush next line
		in.readLine();
		
		while(t-- > 0) {
			List<List<List<Entry<Integer,Character>>>> submissions = new ArrayList<>();
			String[] input, clock;
			String buffer;
			
			boolean[][] accepted = new boolean[26][7];
			List<Team> teams = new ArrayList<Team>();
			int teamCount = 0;
			
			while(true) {
				buffer = in.readLine();
				if(buffer == null || buffer.length() == 0)
					break;
				input = buffer.split(" ");
				
				int team = Integer.parseInt(input[0]) - 1;
				int problem = input[1].charAt(0) - 'A';
				clock = input[2].split(":");
				int time = Integer.parseInt(clock[0])*60 + Integer.parseInt(clock[1]);
				char status = input[3].charAt(0);
				
				teamCount = Math.max(teamCount, team + 1);
				
				for(int i=submissions.size(); i <= team; i++) {
					submissions.add(new ArrayList<List<Entry<Integer,Character>>>());
				}
				for(int i=submissions.get(team).size(); i <= problem;i++) {
					submissions.get(team).add(new ArrayList<Entry<Integer,Character>>());
				}
				for(int i=teams.size();i<=team;i++) {
					teams.add(new Team(i+1));
				}
				
				submissions.get(team).get(problem).add(new SimpleEntry<Integer,Character>(time,status));
				if(status == 'Y') {
					if(!accepted[team][problem])
						teams.get(team).solvedProblems++;
					
					accepted[team][problem] = true;
				}
				
				
			}
			
			for(int i=0;i< teamCount;i++) {
				for(int j=0;j<submissions.get(i).size();j++) {
					if(accepted[i][j]) {
						List<Entry<Integer,Character>> sub = submissions.get(i).get(j);
						sub.sort(new Comparator<Entry<Integer,Character>>() {

							@Override
							public int compare(Entry<Integer, Character> o1, Entry<Integer, Character> o2) {
								return o1.getKey().compareTo(o2.getKey());
							}
							
						});
						
						int elapsedTime = 0;
						for(int k=0;k<sub.size();k++) {
							//elapsedTime += sub.get(k).getKey();
							if(sub.get(k).getValue() != 'Y')
								elapsedTime += 20;
							else {
								elapsedTime += sub.get(k).getKey();
								break;
							}
						}
						teams.get(i).time += elapsedTime;
					}
				}
			}
			teams.sort(new Comparator<Team>() {

				@Override
				public int compare(Team o1, Team o2) {
					if(o1.solvedProblems > o2.solvedProblems)
						return -1;
					if(o1.solvedProblems < o2.solvedProblems)
						return 1;
					if(o1.time < o2.time)
						return -1;
					if(o1.time > o2.time)
						return 1;
					
					return o1.team > o2.team? 1 : -1;
				}
			});
			out.append("RANK TEAM PRO/SOLVED TIME\n");
			
			int rank = 1;
			for(int i=0;i<teams.size();i++) {
				Team team = teams.get(i);
				if(i > 0) {
					Team team2 = teams.get(i-1);
					if(team.solvedProblems != team2.solvedProblems || team.time != team2.time)
						rank = i+1;
				}
				out.append(String.format("%4d %4d"
						+ (team.solvedProblems > 0?" %4d       %4d\n":"\n"), 
						rank, team.team, team.solvedProblems, team.time));
				
			}
			if(t > 0)
				out.append("\n");
			
		}
		
		out.close();
		in.close();
	}
	
	public static class Team {
		public int solvedProblems;
		public int time;
		public int team;
		
		public Team(int team) {
			this.team = team;
		}
	}
}
