package backtracking;

import java.util.*;

public class FeedPeopleProblem {

	public static Set<Integer> result = new HashSet<Integer>();
	
	public static void find(int r, int c, int mr, int mc, Stack<Integer> dishes, int [][] m)
	{
		System.out.println("r "+r+" c "+c+" mr "+mr+" mc "+mc );
		dishes.push(c);
		if(r == mr)
		{
			Set<Integer> d = new HashSet<Integer>(dishes);
			if(result.size() == 0 || result.size() > d.size())
			{
				result = d;
			}
		}
		else if( r < mr)
		{
			
			for(int i=0; i< mc; i++)
			{
				if(m[r+1][i] == 1)
				{
					find(r+1, i, mr, mc, dishes, m);
					break;
				}
			}
		}
		int x = dishes.pop();
		System.out.println("popped "+x);
		System.out.println("***");
		for(int i = c+1; i < mc; i++)
		{
			if(m[r][i] == 1)
			{
				find(r, i, mr, mc, dishes, m);
			}
		}
	}
	
	public static void feedPeople(int [][] m)
	{
		Stack<Integer> dishes = new Stack<Integer>();
		find(0, 1, m.length-1, m[0].length-1, dishes, m);
	}
	
	public static void main(String[] args) {
	
	    int[][] m = { 
	            { 0, 1, 1, 0, 0, 0, 0 },
	            { 0, 1, 0, 1, 0, 0, 0 },
	            { 0, 1, 1, 0, 0, 1, 0 },
	            { 1, 0, 0, 1, 0, 0, 0 },
	            { 0, 0, 1, 0, 1, 0, 0 },
	            { 0, 0, 0, 1, 0, 0, 1 }
	            };
	    feedPeople(m);
	    System.out.println(result.toString());

	}

}
