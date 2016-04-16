package stringsprep;

public class PrintAllCombos {


	public void printAllCombos(String [] chars, int k, String prefix)
	{
		if(k == 0)
		{
			System.out.println(prefix);
			return;
		}
		for(int i=0; i < chars.length; i++)
		{
			printAllCombos(chars, k-1, prefix + chars[i]);
		}
	}
	
	public static void main(String[] args) {
		
		String [] c = {"a", "b"};
		PrintAllCombos p = new PrintAllCombos();
		p.printAllCombos(c, 2, "");
	}

}
