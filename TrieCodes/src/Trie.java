import java.util.LinkedList;


class TrieNode {
	
	char content; 
	boolean isEnd; 
	int count;
	LinkedList<TrieNode> children ;
	
	public TrieNode(char ch)
	{
		this.content = ch;
		this.children = new LinkedList<TrieNode>();
	}
	
	public TrieNode subNode(char ch)
	{
		if(children != null)
		{
			for(TrieNode child : this.children)
			{
				if(child.content == ch)
					return child;
			}
		}
		return null;
	}
	
}

public class Trie {

	public TrieNode root;
	public Trie() {
		this.root = new TrieNode(' ');
	}
	
	public void insertWord(String s)
	{
		if(this.search(s))
		{
			return;
		}
		//For every charachter in the word, we check if there is already a subNode,
		// if there is one, the obtain that and construct it's child nodes
		// if there is none, then add this char as a sub node
		TrieNode current = this.root;
		
		for(char ch : s.toCharArray())
		{
			TrieNode child = current.subNode(ch);
			if(child != null)
			{
				current = child;
			}
			else
			{
				current.children.add(new TrieNode(ch));
				current = current.subNode(ch);
			}
			current.count++;
		}
		current.isEnd = true;
	}
	
	public TrieNode getLatestSubNode(String s)
	{
		TrieNode current = this.root;
		for(char ch : s.toCharArray())
		{
			if(current.subNode(ch) == null)
				return null;
			else
				current = current.subNode(ch);
		}
		return current;
	}
	
	public boolean search(String word)
	{
		// This does a substring search
		// EG if trie maps to TREE
		// and you search for TRE, this will return true
		TrieNode current = this.root;
		for(char ch : word.toCharArray())
		{
			if(current.subNode(ch) == null)
				return false;
			else {
				current = current.subNode(ch);
			}
		}
		return true;
	}

}
