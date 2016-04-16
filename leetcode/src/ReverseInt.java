
public class ReverseInt {

	public int reverse(int n){
		
		if (n == Integer.MIN_VALUE){
			
			return 0;
		}
		if(n == 0){
			
			return n;
		}
		boolean sign = false;
		if(n < 0){
			sign = true;
			n = n * -1;
		}
		int sum =0;
		
		while(n > 0)
		{
			int m = n%10;
			System.out.println(sum*10);
			if((sum * 10)/10 != sum){
				System.out.println("hit here");
				return 0;
			}
			sum = sum * 10 + m;
			System.out.println("m is "+m+" sum is "+sum+ " "+Integer.MAX_VALUE);

			n = n/10;
		}
		
		if(sign)
			return sum * -1;
		else
			return sum;
	}
	
	public static void main(String[] args) {
		
		ReverseInt ri = new ReverseInt();
		System.out.println(ri.reverse(1534236469));
		
	}

}
