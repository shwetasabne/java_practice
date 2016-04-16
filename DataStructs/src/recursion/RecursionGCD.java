package recursion;

public class RecursionGCD {

	/**
	 * If p > q, the gcd of p and q is the same as the gcd of q and p % q.
	 * @param p
	 * @param q
	 * @return
	 */
	public static int findGCD(int p, int q){
		
		if(q == 0){
			return p;
		}
		else{
			return findGCD(q, p % q);
		}
	}
	public static void main(String[] args) {
		
		int ans = findGCD(102, 68);
		System.out.println("GCD is " + ans);

	}

}
