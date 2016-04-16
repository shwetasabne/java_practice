
public class BuySell3 {

	public static int maxProfit(int[] prices) {
        
        if(prices.length <= 0)
            return 0;
        if(prices.length == 1)
            return prices[0];
            
        int [] maxprofits = new int[prices.length];
        int [] rightElement = new int[prices.length];
        
        maxprofits[0] = 0;
        int minElement = prices[0];
        int maxP = 0;
        for(int i=1; i < prices.length; i++)
        {
        	System.out.println("Processing "+i+ " "+maxprofits[i-1]);
            minElement = Math.min(minElement, prices[i]);
            maxP = Math.max(maxprofits[i-1], (prices[i] - minElement));
            maxprofits[i] = maxP;
        }
        maxP = 0;
        int maxElement = prices[prices.length - 1];
        rightElement[prices.length-1] = 0;
        for(int i=prices.length-2; i > 0; i--)
        {
            maxElement = Math.max(maxElement, prices[i]);
            maxP = Math.max(rightElement[i+1], (maxElement - prices[i]));
            rightElement[i] = maxP;
        }
        
        maxP=0;
        for(int i=0; i < prices.length; i ++)
        {
            maxP = Math.max(maxP, (maxprofits[i] + rightElement[i]) );
        }
        
        return maxP;
    }
	public static void main(String[] args) {
		
		int [] a = {3,3};
		System.out.println(maxProfit(a));
	}

}
