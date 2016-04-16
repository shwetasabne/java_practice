package careercup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class WordNode {
	
	String word;
	WordNode pre;
	LinkedList<WordNode> next ;
	boolean isVisited;
	
	public WordNode(String w)
	{
		this.word = w;
		this.pre = null;
		this.next = new LinkedList<WordNode>();	
	}
	
	public String toString()
	{
		return this.word;
	}
}


public class WordLadderTotal {

	public static HashSet<WordNode> dict = new HashSet<WordNode>(); 
	
	public static HashMap<String, LinkedList<String>> parsed = new HashMap<String, LinkedList<String>>();

	public static void createDict()
	{
		dict.add(new WordNode("hit"));
		dict.add(new WordNode("hot"));
		dict.add(new WordNode("ham"));
		dict.add(new WordNode("hil"));
		dict.add(new WordNode("dot"));
		dict.add(new WordNode("dog"));
		dict.add(new WordNode("lot"));
		dict.add(new WordNode("log"));
	}
	
	public static void printDict()
	{
		for(WordNode w : dict)
		{
			System.out.println(w.toString());
			System.out.println(w.next.toString());
		}
	}
	
	public static boolean isDiffOne(String a, String b)
	{
		if(a.length() != b.length())
			return false;
		int diff = 0;
		for(int i=0; i < a.length(); i++)
		{
			if(a.charAt(i) != b.charAt(i))
				diff++;
			if(diff > 1)
				return false;
		}
		if(diff == 1)
			return true;
		else
			return false;
	}

	public static void parseDictionary()
	{
		for(WordNode s : dict)
		{
			LinkedList<WordNode> nexts = new LinkedList<WordNode>();
			for(WordNode s1: dict)
			{
				if(!s.word.equals(s1.word) && isDiffOne(s.word, s1.word))
				{
					nexts.add(s1);
				}
			}
			s.next = nexts;
		}
	}

	public static void dfs (WordNode src, WordNode dest, String path, ArrayList<ArrayList<String>>overall, ArrayList<String>list)
	{
		src.isVisited = true;
		if(src.word.equals(dest.word))
		{
			ArrayList<String> t = new ArrayList<String>(list);
			overall.add(t);
			System.out.println(path + " "+src.word);
			return;
		}
		for(WordNode next : src.next)
		{

			if(!next.isVisited)
			{
				next.pre = src;
				list.add(next.word);
				dfs(next, dest, path+" "+next.word, overall, list);
				next.isVisited = false;
				list.remove(list.size()-1);
			}
		}
	}

	public static void main(String[] args) {
	
		createDict();
		WordNode s1 = new WordNode("sit");
		WordNode s2 = new WordNode("cog");
		dict.add(s1);
		dict.add(s2);
		parseDictionary();
	//	printDict();
		ArrayList<ArrayList<String>> overall = new ArrayList<ArrayList<String>>();
		ArrayList<String> list = new ArrayList<String>();
		dfs(s1, s2, "", overall, list);
		System.out.println(overall.toString());
	}

}
