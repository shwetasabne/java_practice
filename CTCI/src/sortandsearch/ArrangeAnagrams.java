package sortandsearch;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

public class ArrangeAnagrams {

	public String sort(String s)
	{
		char [] ch = s.toCharArray();
		Arrays.sort(ch);
		return String.valueOf(ch);
	}
	
	public static void main(String[] args) {
		
		ArrangeAnagrams a = new ArrangeAnagrams();
		
		String [] str = {"dog", "cat", "tac","act","god"};
		
		Hashtable<String, LinkedList<String>> t = new Hashtable<String, LinkedList<String>>();
		
		for(String s : str)
		{
			String temp = a.sort(s);
			if(!t.containsKey(temp))
			{
				t.put(temp, new LinkedList<String>());
			}
			LinkedList<String> anagrams = t.get(temp);
			anagrams.push(s);
		}
		System.out.println(t.toString());
		int i =0;
		for(String s : t.keySet())
		{
			LinkedList<String> l = t.get(s);
			for(String r: l)
			{
				str[i] = r;
				i++;
			}
		}
		System.out.println(Arrays.toString(str));
	}

}
