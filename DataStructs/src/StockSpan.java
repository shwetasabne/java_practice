import java.util.Arrays;




public class StockSpan {

	// i    : 0 1 2 3 4
	//input : 6 3 4 5 2
	//span  : 1 1 2 3 1 
	public int[] findSpan(int[] input){
		
		int[] span = new int[input.length];
		
		for(int i=0; i < input.length; i++){
			int spanval = 1;
			int j= i - 1;
			while(j >  0 && input[j] <= input[j+1]){
				spanval++;
				j--;
			}
			span[i] = spanval;
		}
		
		return span;
	}
	public static void main(String[] args) {
		
		int[] input = new int []{6, 3, 4, 5, 2};
		StockSpan ss = new StockSpan();
		int [] out = ss.findSpan(input);
		System.out.println(Arrays.toString(out));

	}

}
