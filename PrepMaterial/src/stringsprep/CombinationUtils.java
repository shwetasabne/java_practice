package stringsprep;

import java.util.Arrays;

public class CombinationUtils {

	public void printCombos (int [] n, int index, int r, int [] data, int i)
	{
		if(index == r)
		{
			System.out.println(Arrays.toString(data));
	//		System.out.println();
			return;
		}
		
		if( i >= n.length)
			return;
		
		data[index] = n[i];
		printCombos(n, index+1, r, data, i+1);
		
		printCombos(n, index, r, data, i+1);
	}

	public static void main(String[] args) {
		
		int [] n = {1,2,3,4};
		int r = 2;
		int [] data = new int[r];
		
		CombinationUtils c = new CombinationUtils();
		c.printCombos(n, 0, r, data, 0);
	}

}
