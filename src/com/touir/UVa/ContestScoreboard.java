// remove package before submitting
package com.touir.UVa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

//change classname to Main before submitting
public class ContestScoreboard {

	/*
	 * problem: 10258 - Contest Scoreboard
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=625&page=show_problem&problem=1199
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/ContestScoreboard.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.valueOf(in.readLine());
		
		// flush empty row
		if(t>0)
			in.readLine();
		
		while(t-- > 0) {
			List<Team> teams = new ArrayList<Team>();
			int problemCount = 0;
			
			// init teams
			for(int i=1;i<=100;i++)
				teams.add(new Team(i));
			
			while(true) {
				String input = in.readLine();
				
				if(input == null || "".equals(input.trim()))
					break;
				
				String[] sub = input.split(" ");
				int teamNumber = Integer.valueOf(sub[0]),
						problem = Integer.valueOf(sub[1]),
						time = Integer.valueOf(sub[2]);
				char verdict = sub[3].charAt(0);

				//teamCount = Math.max(teamCount, teamNumber);
				problemCount = Math.max(problemCount, problem);
				
				Team team = teams.get(teamNumber-1);
				
				team.submitted = true;
				if(!team.isSolved[problem]) {
					if(verdict == 'C') {
						team.isSolved[problem] = true;
						team.problemTimes[problem] += time;
						team.time += team.problemTimes[problem];
						team.solved++;
					}
					if(verdict == 'I')
						team.problemTimes[problem] += 20;
				}
			}

			teams.sort(null);
			
			for(int i=0;i<teams.size();i++) {
				if(!teams.get(i).submitted)
					continue;
				Team team = teams.get(i);
				out.append(team.toString() + "\n");
			}
			if(t > 0)
				out.append("\n");
		}
		
		out.close();
		in.close();
	}
	
	public static class Team implements Comparable<Team>{
		public int teamNumber;
		public int solved;
		public int time;
		public int[] problemTimes;
		public boolean[] isSolved;
		
		public boolean submitted;
		
		public Team(int teamNumber) {
			this.teamNumber = teamNumber;
			this.problemTimes = new int[10];
			this.isSolved = new boolean[10];
		}
		
		@Override
		public int compareTo(Team o) {
			if(o == null)
				return -1;
			
			if(o.solved < this.solved 
					|| (o.solved == this.solved && o.time > this.time) 
					|| (o.solved == this.solved && o.time == this.time && o.teamNumber > this.teamNumber))
				return -1;
			return 1;
		}

		@Override
		public String toString() {
			return this.teamNumber + " " + this.solved + " " + this.time;
		}
	}

}
