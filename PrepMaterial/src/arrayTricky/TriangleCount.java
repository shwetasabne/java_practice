package arrayTricky;

import java.util.Arrays;
import java.util.Collections;

public class TriangleCount {

	public static int countTriangles(int [] a)
	{
		int count = 0;
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		/*for(int i=0; i < a.length/2 ; i++)
		{
			int temp = a[i];
			a[i] = a[a.length-1-i];
			a[a.length-1-i] = temp;
		}*/
		System.out.println(Arrays.toString(a));
		int n = a.length;
		for(int i=0 ; i < n-2 ; ++i)
		{
			int k = i+2;
			
			for(int j=i+1; j < n ; ++j)
			{
				while(k < n && a[i] +a[j] > a[k])
				{
					System.out.println(" "+a[i]+" "+a[j]+" "+a[k]);
					++k;
				}
				count += k-j-1;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		
		int [] a = {10, 21, 22, 100, 101, 200, 300};
		System.out.println(countTriangles(a));
	}

}
