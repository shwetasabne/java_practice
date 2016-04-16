package dynamicprog;

public class PermutationsAddingSpace {

	public  static void printPerms(String s, char [] buff, int i, int j, int n)
	{
		if(i == n)
		{
			System.out.println(String.valueOf(buff));
			return;
		}
		
		buff[j] = s.charAt(i);
		printPerms(s, buff, i+1, j+1, n);
		
		buff[j] = ' ';
		buff[j+1] = s.charAt(i);
		printPerms(s, buff, i+1, j+2, n);
		
	}

	public static void main(String[] args) {

		String s= "ABC";
		int i = 1; 
		int j = 1;
		int n = s.length();
		char [] buff = new char[2*n];
		
		buff[0] = s.charAt(0);
		printPerms(s, buff, i, j, n);
	}

}
