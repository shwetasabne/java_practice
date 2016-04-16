package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class WordSearch {

	public ArrayList<ArrayList<Integer>> locateStartingIndices(String [][] words, String s)
	{
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		
		int [] result = new int[2];
		
		for(int i=0; i < words.length; i++)
		{
			for(int j=0; j<words[0].length; j++)
			{
				if(s.equals(words[i][j]))
				{
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(i);
					temp.add(j);
					output.add(temp);
				}
			}
		}
		return output;
	}


	public boolean isSafe(int i, int j, String search, int charAtIdx, String [][] words)
	{
	//	System.out.println("Processing "+i + " "+j + " "+charAtIdx +  " " +words[i][j]+ " "+search.charAt(charAtIdx));
	//	System.out.println(words[i][j].equals(String.valueOf(search.charAt(charAtIdx))));
		if(i >=0 && i < words.length && j >=0 && j < words[0].length && words[i][j].equals(String.valueOf(search.charAt(charAtIdx))))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean dfs(int x , int y, String search, int charAtIdx, int [][] soln, String [][] words)
	{
		System.out.println("DFS ing with "+x+" "+y);
		
		if(charAtIdx == search.length())
		{
			//soln[x][y] = 1;
			return true;
		}
		
		if(isSafe(x, y, search, charAtIdx, words))
		{
			
			soln[x][y] = 1;
			
			if(dfs(x+1, y, search, charAtIdx+1, soln, words))
			{
				return true;
			}
			
			if(dfs(x-1, y, search, charAtIdx+1, soln, words))
			{
				return true;
			}
			if(dfs(x, y+1, search, charAtIdx+1, soln, words))
			{
				return true;
			}
			if(dfs(x, y-1, search, charAtIdx+1, soln, words))
			{
				return true;
			}
			
			soln[x][y] = 0;
			return false;
		}
		return false;
	}

	public static void main(String[] args) {
		
		String [][] words = {
				{"A", "B", "C", "E"},
				{"S", "F", "C", "S"},
				{"A", "D", "E", "E"}
				};
		
		WordSearch ws = new WordSearch();
		
		ArrayList<ArrayList<Integer>> indices = ws.locateStartingIndices(words, "S");
		System.out.println(indices.toString());
		
		int[][] visited = new int[words.length][words[0].length];
		boolean output = ws.dfs(1, 3, "SEE", 0, visited, words);
	
		System.out.println(output);
		for(int i=0; i < visited.length; i++)
		{
			for(int j=0; j < visited[0].length; j++)
			{
				System.out.print(" " + visited[i][j]);
			}
			System.out.println();
		}
	}

}
