package backtracking;

import java.util.HashSet;
import java.util.LinkedList;

class TrieNode {
	
	char content;
	boolean isEnd;
	LinkedList<TrieNode> children;
	
	public  TrieNode(char ch)
	{
		this.content = ch;
		this.children = new LinkedList<TrieNode>();
	}
	
	public TrieNode subNode(char ch)
	{
		if(children != null)
		{
			for(TrieNode child : children)
			{
				if(child.content == ch)
				{
					return child;
				}
			}
		}
		return null;
	}
}

class Trie {
	
	public TrieNode root; 
	public Trie()
	{
		this.root = new TrieNode(' ');
	}
	
	public void insertWord(String word)
	{
		TrieNode current = this.root;
		for(char ch : word.toCharArray())
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
		}
		current.isEnd = true;
	}
	
	public boolean searchWord(String word)
	{
		TrieNode current = this.root;
		
		for(char ch : word.toCharArray())
		{
			TrieNode child = current.subNode(ch);
			if(child == null)
				return false;
			else
				current = child;
		}
		if(current.isEnd)
			return true;
		else
			return false;
	}
	
	public boolean startsWith(String prefix)
	{
		TrieNode current = this.root;
		
		for(char ch : prefix.toCharArray())
		{
			TrieNode child = current.subNode(ch);
			if(child == null)
				return false;
			else
				current = child;
		}
		return true;
	}
}

public class WordSearch2 {

	public static Trie trie = new Trie();
	
	public static HashSet<String> result = new HashSet<String>();

	public static void dfs(int x, int y, char[][] board, boolean [][] visited, String str, Trie trie, HashSet result)
	{
		if(x  < 0 || y < 0 || x >= board.length || y >= board[0].length)
			return ;
		
		if(visited[x][y])
			return;
		
		str = str + board[x][y];
		
		if(!trie.startsWith(str))
			return;
		
		if(trie.searchWord(str))
			result.add(str);
		
		visited[x][y] = true;
		dfs(x+1, y, board,visited, str, trie, result);
		dfs(x-1, y, board, visited, str, trie, result);
		dfs(x, y+1, board, visited, str, trie, result);
		dfs(x, y-1, board, visited, str, trie, result);
		visited[x][y] = false;
	}
	
	public static void findWords(char[][] board, String [] words)
	{
		for(String s : words)
		{
			trie.insertWord(s);
		}
		boolean [][] visited = new boolean[board.length][board[0].length];
		
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j < board[0].length; j++)
			{
				dfs(i, j, board, visited, "", trie, result);
			}
		}
		
		System.out.println(result.toString());
	}
	
	public static void main(String[] args) {
		
		char [][] board = {
				{'o', 'a','a', 'n'},
				{'e', 't', 'a' ,'e'},
				{'i', 'h', 'k', 'r'},
				{'i', 'f', 'l', 'v'}
		};
		
		String [] words = {"oath", "pea", "eat", "rain"};
		findWords(board, words);
	}

}
