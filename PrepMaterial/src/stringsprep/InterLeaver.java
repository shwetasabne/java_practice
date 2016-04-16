package stringsprep;

public class InterLeaver {
	
	public static String s1 = "AB";
	public static String s2 = "CD";
	
	public void interleave(int i, int j, String s)
	{
		if(i == s1.length() && j == s2.length())
		{
			System.out.println("" + s);
		}
		if(i != s1.length())
		{
			System.out.println("!! Now sending "+(i+1)+ " "+j+ " "+s+" "+s1.charAt(i));
			interleave(i+1, j, s+s1.charAt(i));
		}
		if(j != s2.length())
		{
			System.out.println("** Now sending "+(i)+ " "+(j+1)+ " "+s+" "+s2.charAt(j));
			interleave(i, j+1, s+s2.charAt(j));
		}
	}
	
	public boolean isInterLeaved(String A, String B, String C)
	{
		System.out.println("A is "+A+" B is "+B+" C is "+C);
		if( !(A.length() != 0 || B.length() != 0 || C.length() != 0))
			return true;
		if(C.length() == 0)
			return false;
		if(A.length() == 0)
		{
			return (C.charAt(0) == B.charAt(0)  &&  isInterLeaved(A, B.substring(1), C.substring(1)));
			
		}
		else if(B.length() == 0)
		{
			return (C.charAt(0) == A.charAt(0)  &&  isInterLeaved(A.substring(1), B, C.substring(1)));
		}
		else
		{
		return ( (C.charAt(0) == A.charAt(0)  &&  isInterLeaved(A.substring(1), B, C.substring(1))) ||
				(C.charAt(0) == B.charAt(0)  &&  isInterLeaved(A, B.substring(1), C.substring(1)))
				);
		}
	}
	public static void main(String [] args)
	{
		InterLeaver it = new InterLeaver();
	//	it.interleave(0, 0, "");
		System.out.println(it.isInterLeaved("AB", "CD", "ADBC"));
	}
}
