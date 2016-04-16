package dynamicprog;

public class StringMingling {


	public static void stringMingle(String p, String q, int index, String res)
	{
		if(res.length() == p.length() + q.length())
		{
			System.out.println(res);
			return;
		}
		String temp = res + String.valueOf(p.charAt(index)) + String.valueOf(q.charAt(index));
		stringMingle(p, q, index+1, temp);
	}
	
	public static void main(String[] args) {
		
		String p = "ab";
		String q = "cd";
		stringMingle(p, q, 0, "");
	}

}
