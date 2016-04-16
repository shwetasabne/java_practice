/**
 * @see <a href="http://www.geeksforgeeks.org/stock-buy-sell/">http://www.geeksforgeeks.org/stock-buy-sell/</a>
 */
package geekforgeeks;

import java.util.ArrayList;
import java.util.List;

class BuySellDate {
	int buy;
	int sell;
	int maxprofit;

	public BuySellDate() {
	this.buy = 0;
	this.sell = 0;
	this.maxprofit = 0;
	}
}

public class BuySell {

	public List<BuySellDate> findMaxProfit( int [] a)
	{
		List<BuySellDate> newList = new ArrayList<BuySellDate>();
		if(a.length == 0)
			return null;
		if(a.length == 1)
		{
			BuySellDate bs = new BuySellDate();
			newList.add(bs);
			return newList;
		}
		int i = 0;
		
		int n = a.length ;
		while(i < n-1)
		{
			// find local minimum
			BuySellDate bs = new BuySellDate();
			while((i < n-1) && a[i+1] < a[i])
				i++;
			bs.buy = i;
			
			if(i == n-1)
				break;

			int tempBuyPrice = a[i];

			//find local maximum
			while((i < n-1) && (a[i+1] > a[i]))
				i++;
			bs.sell = i;
			bs.maxprofit = a[i] - tempBuyPrice;
			System.out.println("Buy on "+bs.buy+" sell on "+bs.sell+" max "+bs.maxprofit);
			newList.add(bs);
		}
		return newList;
	}
	public static void main(String[] args) {
		
		BuySell bs = new BuySell();
		int []a = {100, 180, 260, 310, 40, 535, 695};
		bs.findMaxProfit(a);

	}

}
