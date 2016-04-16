package sortandsearch;

import java.util.*;

class HtWt  implements Comparable {
	int ht; 
	int wt;
	
	public String toString()
	{
		return String.valueOf(ht)+":"+String.valueOf(wt);
	}
	
	public HtWt(int h, int w)
	{
		this.ht = h;
		this.wt = w;
	}

	public int compareTo(Object arg0) {
		HtWt second = (HtWt)arg0;
		if(this.ht != second.ht)
		{
			return ((Integer)this.ht).compareTo((Integer)second.ht);
		}
		else
		{
			return ((Integer)this.wt).compareTo((Integer)second.wt);
		}
	}
	
	public boolean isBefore(HtWt o)
	{
		if(this.ht < o.ht && this.wt < o.wt)
			return true;
		else
			return false;
	}
}

public class LongestSequeceInPairs {


	public ArrayList<HtWt> list = new ArrayList<HtWt>();
	
	public void createObjects()
	{
		this.list.add( new HtWt(60, 65));
		this.list.add( new HtWt(73, 77));
	}
	
	public ArrayList<HtWt> getIncreasingSubSequence(ArrayList<HtWt> list)
	{
		Collections.sort(list);
		return longestSub(list);
	}
	
	public ArrayList longestSub(ArrayList<HtWt> list)
	{
		ArrayList<HtWt>[] soln = new ArrayList[list.size()];
		
		this.longS(list, soln, 0);
		
		ArrayList best = null;
		for(int i=0; i < list.size(); i++)
		{
			best = this.sequenceWithMax(best, soln[i]);
		}
		return best;
	}
	
	public ArrayList<HtWt> sequenceWithMax(ArrayList<HtWt>best, ArrayList<HtWt> sec)
	{
		if(best == null) return sec;
		if(sec == null) return best;
		return best.size() > sec.size() ? best : sec;
	}
	
	public void longS(ArrayList<HtWt>l, ArrayList<HtWt>[] sol, int curr)
	{
		if(curr >= l.size() || curr < 0)
			return;
		
		HtWt c = l.get(curr);
		
		ArrayList<HtWt> best = null;
		for(int i=0; i < curr; i++)
		{
			if(l.get(i).isBefore(c))
			{
				best = this.sequenceWithMax(best, sol[i]);
			}
		}
		
		ArrayList<HtWt> newsol = new ArrayList<HtWt>();
		if(best != null)
			newsol.addAll(best);
		else
			newsol.add(c);
		
		sol[curr] = newsol;
		longS(l, sol, curr+1);
	}
	
	public static void main(String[] args) {
		
		LongestSequeceInPairs l  = new LongestSequeceInPairs();
		l.createObjects();
		
		System.out.println(l.getIncreasingSubSequence(l.list).toString());
	}

}
