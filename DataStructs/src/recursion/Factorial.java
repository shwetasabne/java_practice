package recursion;

public class Factorial {

	public static int findFact(int n){
		
		if(n == 0 || n == 1){
			return 1;
		}
		else{
			return findFact(n-1) * n;
		}
		
	}
	public static void main(String[] args) {
	
		int ans = findFact(4);
		System.out.println("Fact of 4 is " + ans);
	}

}
