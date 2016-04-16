package hard;

import java.util.*;

public class LongestWordMade {

	public void findLongestWord(String [] words)
	{
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for(String s : words)
		{
			map.put(s, true);
		}
		for(int i=0; i < words.length; i++)
		{
			if(isMadeUpOfWords(words[i], true, map))
			{
				System.out.println(words[i]);
				return;
			}
			
		}
	}

	public boolean isMadeUpOfWords(String s, boolean isOrig, HashMap<String, Boolean> map)
	{
		if(map.containsKey(s) && !isOrig)
		{
			return map.get(s);
		}
		for(int i= 0; i < s.length(); i++)
		{
			String l = s.substring(0, i);
			String r = s.substring(i);
			if(map.containsKey(l) && map.get(l) == true && isMadeUpOfWords(r, false, map))
			{
				return true;
			}
		}
		map.put(s, false);
		return false;
	}

	public static void main(String[] args) {
		
		String [] words = {"agfowofjslskfjfgqph","testingtester", "tester", "test","ing","cat", "ca","t"};
		LongestWordMade m = new LongestWordMade();
		m.findLongestWord(words);
	}

}
