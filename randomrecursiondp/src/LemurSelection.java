
public class LemurSelection {

	public static int pascal(int i, int j)
	{
		if (j == 0) {
	           return 1;
	       } else if (j == i) {
	           return 1;
	       } else {
	           return pascal(i - 1, j - 1) + pascal(i - 1, j);
	       }
	}
	
	public static void main(String[] args) {
		
		System.out.println("count for available 2 and to choose 1 is " + pascal(2,1));
		System.out.println("count for available 10 and to choose 5 is " + pascal(10,5));

	}

}
