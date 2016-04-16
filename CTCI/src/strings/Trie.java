package strings;

import java.util.LinkedList;
import java.util.List;

class TrieNode {
	
	char data;
	boolean is_end ;
	int count;
	List<TrieNode> children ;
	public TrieNode(char c){
		this.data = c;
		children = new LinkedList<TrieNode>();
		is_end = false;
		this.count = 0;
	}
	
	public TrieNode subNode(char c){
		if(children != null){
			for(TrieNode child : children){
				if(child.data == c)
					return child;
			}
		}
		return null;
	}
}

public class Trie {

	private TrieNode root ;
	
	public Trie (){
		root = new TrieNode(' ');
	}
	
	//Insert
	public void insert(String word){
		
		TrieNode current = root;
		//search if word is present, if so return
		
		for (char ch: word.toCharArray()){
			// Get the subnode of the char 
			TrieNode child = current.subNode(ch);
			if(child != null){
				current = child;
			}
			else {
				System.out.println("Adding "+ch);
				current.children.add(new TrieNode(ch));
				current = current.subNode(ch);
		}
			current.count++;
		}
		current.is_end = true;
	}

	public boolean search (String word){
		
		TrieNode current = root;
		for(char ch : word.toCharArray()){
		//	System.out.println("Searching "+ch);
			TrieNode child = current.subNode(ch);
			//System.out.println(child.toString());
			if(child == null)
				return false;
			else
				current = child;
		}
		if (current.is_end)
			return true;
		else
			return false;
	}
}
