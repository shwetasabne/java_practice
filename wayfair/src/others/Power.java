package others;

public class Power {

	public double sqrt (double n, int y)
	{
		double temp; 
		if(y == 0)
			return 1;
		temp = sqrt(n, y/2);
		if(y%2 == 0)
			return temp*temp;
		else
		{
			if(y > 0)
				return n * temp * temp;
			else
				return (temp * temp)/n;
		}
	}

	public static void main(String[] args) {
		
		Power p = new Power ();
		System.out.println(p.sqrt(2, 2));

	}

}
