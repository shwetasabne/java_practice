
public class StringCombos {


	public void generateCombos(String temp, int pointer, String [][] str)
	{
		
		if(pointer == str.length)
		{
		//	System.out.println(" ***** ");
			System.out.println(temp);
			return;
		}
		for(int i=0; i < str[0].length; i++)
		{
		//	System.out.println("i is "+i+" pointer "+pointer);
			generateCombos(temp+" " +str[pointer][i], pointer+1, str);
		}
	}
	
	public static void main(String[] args) {
		
		String [][] str = new String[3][2];
		str[0][0] = "fast";
		str[0][1] = "slow";
		
		str[1][0] = "black";
		str[1][1] = "brown";
		
		str[2][0] = "dog";
		str[2][1] = "fox";
		
		StringCombos c = new StringCombos();
		c.generateCombos(" ", 0, str);
	}

}
