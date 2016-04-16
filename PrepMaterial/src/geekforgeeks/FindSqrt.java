package geekforgeeks;

public class FindSqrt {


	public int sqrt(int n){
		
		long i = 0;
		long j = n/2 + 1;
		
		long mid = 0;
		while(i <= j){
			
			mid = (i+j)/2;
			if(mid * mid == n)
				return (int)mid;
			if(mid*mid < n)
				i = mid + 1;
			else
				j = mid -1;
		}
		return (int)j;
	}
	public static void main(String[] args) {
		FindSqrt f = new FindSqrt();
		System.out.println(f.sqrt(169));
	}

}
