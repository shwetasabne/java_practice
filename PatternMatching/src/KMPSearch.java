import java.util.Arrays;


public class KMPSearch {

	public int [] computeLPS(String s)
	{
		int [] lps = new int[s.length()];
		char [] ch = s.toCharArray();
		int i = 1; 
		int j = 0; 
		lps[0] = 0;
		
		while(i < lps.length)
		{
			// if 1 matches 0
			if(ch[i] == ch[j])
			{
				j++;
				lps[i] = j;
				i++;
			}
			else
			{
				if(j != 0)
				{
					j = lps[j-1];
				}
				else
				{
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}
	
	public void kmpMatching(String t, String p)
	{
		int [] out = this.computeLPS(p);
		System.out.println(Arrays.toString(out));
		int i = 0; int j = 0;
		char [] txt = t.toCharArray();
		char [] pat = p.toCharArray();
		
		
		while(i < t.length())
		{
			if(txt[i] == pat[j])
			{
				i++;
				j++;
			}
			if(j == p.length())
			{
				System.out.println("Pattern found at "+ (i-j));
				j = out[j-1];
			}
			else if(txt[i] != pat[j] && i < t.length())
			{
				if(j != 0)
					j = out[j-1];
				else
					i++;
			}
			
		}
	}
	
	public static void main(String[] args) {
	
		KMPSearch m = new KMPSearch();
		m.kmpMatching("ABABDABACDABABCABAB", "GEEKSFORGEEKSSTUDYING");
	}

}
