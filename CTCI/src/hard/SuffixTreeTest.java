package hard;

import java.util.*;

class SuffixTreeNode {
	
	HashMap<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
	
	char value;
	ArrayList<Integer> indexes = new ArrayList<Integer>();
	public SuffixTreeNode() {
		
	}
	
	public String toString()
	{
		return String.valueOf(this.value);
		
	}
	
	public void insertWord(String s, int index)
	{
		indexes.add(index);
		if(s!= null && s.length() > 0)
		{
			value = s.charAt(0);
			SuffixTreeNode child = null;
			if(children.containsKey(value))
			{
				child = children.get(value);
			}
			else
			{
				child = new SuffixTreeNode();
				children.put(value, child);
			}
			child.insertWord(s.substring(1), index);
		}
	}
	
	public ArrayList<Integer> searchWord(String s)
	{
		if(s== null || s.length() == 0)
			return indexes;
		else
		{
			char first = s.charAt(0);
			if(children.containsKey(first))
			{
				String rmd = s.substring(1);
				return children.get(first).searchWord(rmd);
			}
		}
		return null;
	}
	
}

class SuffixTree {
	
	SuffixTreeNode root = new SuffixTreeNode();
	
	public SuffixTree(String s)
	{
		for(int i=0; i< s.length(); i++)
		{
			String suffix = s.substring(i);
			root.insertWord(suffix, i);
		}
	}
	
	public void printChildren()
	{
		System.out.println(root.children.toString());
		System.out.println(root.indexes.toString());
	}
	
	public ArrayList<Integer> search(String s)
	{
		return root.searchWord(s);
	}
}
public class SuffixTreeTest {


	public static void main(String[] args) {
		
		SuffixTree s = new SuffixTree("BIBS");
		s.printChildren();
		ArrayList<Integer> out = s.search("B");
		System.out.println(out.toString());
	}

}
