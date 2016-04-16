package dynamicprog;

public class MakeSentencesFromWorkds {


	public static void makeSentence(String [] words, String prefix, int pntr, boolean [] used)
	{
		if(pntr == words.length)
		{
			System.out.println(prefix);
			return;
		}
		for(int i=0; i < words.length; i++)
		{
			if(used[i]) continue;
			used[i] = true;
			makeSentence(words, prefix + " " + words[i], pntr+1, used);
			used[i] = false;
		}
	}
	public static void main(String[] args) {
		
		String [] words = {"man", "man", "boy", "dog"};
		 boolean[] used = new boolean[words.length];
		makeSentence(words, "",0, used);

	}

}
