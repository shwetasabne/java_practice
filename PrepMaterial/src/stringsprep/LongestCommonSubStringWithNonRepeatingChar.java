package stringsprep;

public class LongestCommonSubStringWithNonRepeatingChar {


	public static int longestSubStrinNRC (String s)
	{
		char [] ch = s.toCharArray();
		
		int [] visited = new int[256];

		for(int i=0; i < visited.length; i++)
			visited[i] = -1;		

		int n = s.length() -1 ;
		int len = 0;
		visited[ch[0]] = 0;
		int i = 1;
		int j = 0;
		
		while(i <= n)
		{
		//	System.out.println("****\n");
		//	System.out.println(" i is "+ch[i]);
			if(visited[ch[i]] == -1)
			{
				visited[ch[i]] = i;
				i++;
			}
			else
			{
				if(visited[ch[i]] <= j)
				{
					visited[ch[i]] = i;
					i++;
				}
				else
				{
					len = Math.max(len, (i-j));
					System.out.println(" "+i+" "+j);
					j = i;
					i++;
				}
			}
		}
		
		return len;
	}
	
	public static void main(String[] args) {
		
		String s = "geeksforgeeeks";

		int out = longestSubStrinNRC(s);
		System.out.println(out-1);
	}

}
