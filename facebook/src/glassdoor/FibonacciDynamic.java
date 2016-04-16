package glassdoor;

public class FibonacciDynamic {


	public static void main(String[] args) {
		
		int number = 4;
		
		long [] fib = new long[number+1];
		
		fib[0] = 1;
		fib[1] = 1;
		
		for(int n=2; n <= number; n++)
		{
			fib[n] = fib[n-1] + fib[n-2];
		}

		System.out.println(fib[number]);
	}

}
