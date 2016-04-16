package glassdoor;

public class CalculateSqrt {

	public static double sqrt(int num)
	{
		double t; 
		
		double squareRoot = num/2;
		
		do {
			t = squareRoot;
			squareRoot = (t + (num/t))/2;
		}while((t-squareRoot) != 0);
		
		return squareRoot;
	}
	
	public static void main(String[] args) {
		System.out.println(sqrt(200));
	}

}
