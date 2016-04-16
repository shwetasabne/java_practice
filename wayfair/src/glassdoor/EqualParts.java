package glassdoor;
import java.util.Arrays;


public class EqualParts {

	public int [] partition(int num, int p)
	{
		int [] parts = new int[p];
		
		int quotient = num / p;
		System.out.println("q is "+quotient);
		for(int i= 0; i<parts.length; i++)
		{
			parts[i] = quotient;
		}
		
		int rmd = num % p;
		int i = 0;
		System.out.println("Rmd is "+rmd);
		while(rmd > 0)
		{
			parts[i] = parts[i] + 1;
			rmd--;
			i++;
		}
		
		return parts;
	}

	public static void main(String[] args) {
		
		EqualParts e = new EqualParts ();
		int [] out = e.partition(22, 10);
		System.out.println(Arrays.toString(out));
	}

}
