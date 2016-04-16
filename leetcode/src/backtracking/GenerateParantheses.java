package backtracking;

public class GenerateParantheses {

	
	public void generateParantheses(int l, int r, String prefix)
	{
		if(l > r)
			return;
		if(l == 0 && r == 0)
		{
			System.out.println(prefix);
		}
		if(l > 0)
		{
			generateParantheses(l-1, r, prefix+"(");
		}
		if(r > 0)
		{
			generateParantheses(l, r-1, prefix+")");
		}
	}

	public static void main(String[] args) {
		
		GenerateParantheses g = new GenerateParantheses();
		g.generateParantheses(2, 2, "");

	}

}
