package glassdoor;

public class PracticeVectorCombo {


	public static void printStringCombo(String [][] str, int pntr, String prefix)
	{
		if(pntr == str.length)
		{
			System.out.println(prefix);
			return;
		}
		for(int i=0; i< str[pntr].length; i++)
		{
			printStringCombo(str, pntr+1, prefix + " "+ str[pntr][i]);
		}
	}
	
	public static void main(String[] args) {
		
		String [][] str = {
				{"one","two", "three"},
				{"four", "five", "nine"},
				{"six", "seven", "ten"}
		};
		
		printStringCombo(str, 0, "");
		
	}

}
