
public class AutoComplete {

	public Trie trie = new Trie();
	public void generateTrie()
	{
		trie.insertWord("that");
		trie.insertWord("tram");
		trie.insertWord("this");
	}

	public void autoComplete(String s)
	{
		TrieNode latestSub = trie.getLatestSubNode(s);
		if(latestSub == null)
		{
			System.out.println("");
		}
		else
		{
			System.out.println("Latest sub is "+latestSub.content);
			dfs(latestSub, "", s);
		}
	}

	public void dfs(TrieNode root, String prefix, String base)
	{
		if(root.isEnd)
		{
			System.out.println(base + prefix);
			return;
		}
		for(TrieNode child : root.children)
		{
			dfs(child, prefix + child.content, base);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutoComplete ac = new AutoComplete();
		ac.generateTrie();
		ac.autoComplete("th");
	}

}
