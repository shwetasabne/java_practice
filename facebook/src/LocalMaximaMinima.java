
public class LocalMaximaMinima {

	public static void main(String[] args) {
		
		int [] a = {1, 2, 3, 4, 5, 4, 3, 2, 1};

		int localMinima = Integer.MAX_VALUE;
		int localMaxima = Integer.MIN_VALUE;
		for(int i=0; i < a.length-1; i++)
		{
			if(a[i] > localMaxima)
			{
				localMaxima = a[i];
			}
			if(a[i] < localMinima)
			{
				localMinima = a[i];
			}
		}
		if(localMinima != Integer.MAX_VALUE && localMaxima != Integer.MIN_VALUE)
		{
			System.out.println("local minima is "+localMinima +" "+"local maxima is "+localMaxima);
		}
		else if(localMinima != Integer.MAX_VALUE && localMaxima == Integer.MIN_VALUE)
		{
			System.out.println("local minima is "+localMinima +" "+"local maxima is NONE");
		}
		else if(localMinima == Integer.MAX_VALUE && localMaxima != Integer.MIN_VALUE)
		{
			System.out.println("local minima is NONE " +" "+"local maxima is "+localMaxima);
		}
		else
		{
			System.out.println("NONE");
		}
	}

}
