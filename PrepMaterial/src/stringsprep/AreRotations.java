package stringsprep;

public class AreRotations {


	public boolean areRotations(String s1, String s2)
	{
		if(s1.length() != s2.length())
			return false;
		String s = s1+s1;
		if(s.contains(s2))
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AreRotations a = new AreRotations();
		System.out.println(a.areRotations("ABCD", "ACBD"));
	}

}
