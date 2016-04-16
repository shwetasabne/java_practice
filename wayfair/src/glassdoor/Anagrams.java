package glassdoor;

public class Anagrams {


	public void anagrams(String prefix, String s)
	{
		if(s.length() == 0)
		{
			System.out.println(prefix);
		//	return;
		}
		for(int i=0; i < s.length(); i++)
		{
			anagrams(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, s.length()));
		}
	}
	
	public void combinations(String prefix, String s)
	{
	
		System.out.println(prefix);
		for(int i=0; i < s.length(); i++)
		{
			combinations(prefix+s.charAt(i), s.substring(i+1));
		}
	}
	
	public static void main(String[] args) {
		Anagrams a = new Anagrams();
		a.anagrams("", "ABC");
	//	a.combinations("", "cat");
	}

}
