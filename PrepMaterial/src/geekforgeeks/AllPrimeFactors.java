package geekforgeeks;

import java.util.ArrayList;

public class AllPrimeFactors {

	public static void main(String[] args) {
		
		int n = 21;
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		while(n%2 == 0){
			primes.add(2);
			n = n /2 ;
		}
		for(int i=3; i < Math.sqrt(n); i=i+2){
			
			while(n%i == 0){
				System.out.println("Adding "+i);
				primes.add(i);
				n = n / i;
			}
		}
		
		if(n > 2){
			primes.add(n);
		}
		System.out.println(primes.toString());
	}
	
	

}
