package strings;

import java.util.LinkedList;

public class UTTrie {

	
	public static void main(String[] args) {
		
		Trie t = new Trie();
		t.insert("ty");
		t.insert("tram");
		System.out.println("Searching for "+ t.search("t"));
		System.out.println("Searching for "+ t.search("ty"));
		System.out.println("Searching for "+ t.search("tram"));
		System.out.println("Searching for "+ t.search("ram"));

	}

}
