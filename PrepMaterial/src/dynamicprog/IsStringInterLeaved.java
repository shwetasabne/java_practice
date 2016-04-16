package dynamicprog;

public class IsStringInterLeaved {

	public static boolean isInterLeaveNonDP(String a, String b, String c)
	{
		if(a.length() == 0 && b.length() == 0 && c.length() == 0)
			return true;
		
		
		if(c.length() == 0)
			return false;
		
		return ( (c.charAt(0) == a.charAt(0) && isInterLeaveNonDP(a.substring(1), b, c.substring(1)))
				||
				 (c.charAt(0) == b.charAt(0) && isInterLeaveNonDP(a, b.substring(1), c.substring(1)))
				);
	}

	public static boolean isInterLeaveDP(String a1, String b1, String c1)
	{
		char [] a = a1.toCharArray();
		char [] b = b1.toCharArray();
		char [] c = c1.toCharArray();
		
		if(a.length + b.length != c.length)
			return false;
		
		boolean [][] out = new boolean[a.length+1][b.length+1];
		
		for(int i=0; i <= a.length-1; i++)
		{
			for(int j=0; j <= b.length-1; j++){
				
				System.out.println(i+ " "+j);
				if(i==0 && j==0)
				{
					out[i][j] = true;
				}
				
				else if(i==0 && b[j-1] ==c[j-1])
					out[i][j] = out[i][j-1];
				
				else if(j==0 && a[i-1] == c[i-1])
					out[i][j] = out[i-1][j];
				
				else if((i >0) && a[i-1] == c[i+j-1] && b[j-1] != c[i+j-1] )
				{
					out[i][j] = out[i-1][j];
				}
				
				else if( (j>0) && a[i-1] != c[i+j-1] && b[j-1] == c[i+j-1])
				{
					out[i][j] = out[i][j-1];
				}
				
				else if(a[i-1] == c[i+j-1] && b[j-1] == c[i+j-1])
				{
					out[i][j] = out[i][j-1] || out[i-1][j];
				}
			}
		}
		return out[a.length-1][b.length-1];
	}
	public static void main(String[] args) {
	
		String  a = "XY";
		String b = "X";
		String c = "YXY";
		
		System.out.println(isInterLeaveNonDP(a, b, c));
		System.out.println(isInterLeaveDP(a, b, c));
	}

}
