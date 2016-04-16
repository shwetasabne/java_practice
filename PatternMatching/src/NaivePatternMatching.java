
public class NaivePatternMatching {


	public static void matchIndex(String txt, String pat)
	{
		char [] t = txt.toCharArray();
		char [] p = pat.toCharArray();
		
		int M = p.length;
		int N = t.length;
		
		for(int i=0; i < N-M ; i++)
		{
			int j;
			for(j=0; j < M ; j++)
			{
				if(t[i+j] != p[j])
					break;
				
			}
			if(j == M)
				System.out.println("Pattern found at "+i);
		}
	}
	
	public static void main(String[] args) {
		
		String t = "this is a text file";
		String p = "tixt";
		
		matchIndex(t,p);
	}

}
