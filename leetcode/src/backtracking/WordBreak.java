package backtracking;

import java.util.*;

public class WordBreak {

	public static List<String> wordBreak(Set<String> dict, String s)
	{
		List<String> dp[] = new ArrayList[s.length()+1];
		dp[0] = new ArrayList<String>();
		
		for(int i=0 ; i < s.length(); i++)
		{
			
			if(dp[i] == null)
				continue;
			
			for(String word : dict)
			{
				int len = word.length();
				int end = i + len;
			//	System.out.println("Processing character "+i+ " word "+word+" len "+len+" end "+end);
				if(end > s.length())
					continue;
				
				if(s.substring(i, end).equals(word))
				{
					System.out.println("Substring "+word);
					if(dp[end] == null)
					{
						dp[end] = new ArrayList<String>();
					}
					dp[end].add(word);
				}
			}
		}
				
		List<String> result = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		if(dp[s.length()] == null)
		{
			System.out.println("good bye");
			return result;
		}
		dfs(dp, s.length(), result, temp);
		System.out.println(result.toString());
		return result;
	}

	public static void dfs(List<String>[] dp, int end, List<String> result, ArrayList<String> temp)
	{
		if(end <= 0)
		{
			String path = temp.get(temp.size()-1);
			for(int i = temp.size()-2; i >= 0; i--)
			{
				path += " "+ temp.get(i);
			}
			result.add(path);
			return;
		}
		
		for(String str : dp[end])
		{
			temp.add(str);
			dfs(dp, end - str.length(), result, temp);
			temp.remove(temp.size()-1);
		}
	}

	public static void main(String[] args) {
		
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("sand");
		dict.add("and");
		dict.add("dog");
		
		String s = "catsanddog";
		
		WordBreak wb = new WordBreak();
		wb.wordBreak(dict, s);
	}

}
