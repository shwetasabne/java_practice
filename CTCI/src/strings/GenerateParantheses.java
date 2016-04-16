package strings;

public class GenerateParantheses {


	public static void generateParantheses(String s, int l, int r)
	{
		if(l > r)
			return;
		
		if(l==0 && r == 0)
			System.out.println(s);
		
		if(l > 0)
			generateParantheses(s+"(", l-1, r);
		
		if(r > 0)
			generateParantheses(s+")", l, r-1);
	}
	
	public static void main(String[] args) {
		
		generateParantheses("", 3, 3);
	}

}
