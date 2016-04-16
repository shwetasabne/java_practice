package geekforgeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class Interval implements Comparable<Interval> {
	
	int start;
	int end;
	
	public Interval(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
	
	 public int compareTo(Interval i){
	      return ((Integer)this.start).compareTo(i.start);
	 }

}

public class MergeIntervals {

	public static Stack<Interval> overlapped (List<Interval> list)
	{

		Stack<Interval> s = new Stack<Interval>();
		if(list.size() == 0)
		{
			return s;
		}		
		Iterator itr = list.iterator();
		while(itr.hasNext())
		{
			Interval curr = (Interval) itr.next();
			if(s.isEmpty())
			{
				s.push(curr);
			}
			else
			{
				Interval prev = s.peek();
				if(prev.end < curr.start)
				{
					s.push(curr);
				}
				else
				{
					s.pop();
					Interval newI = new Interval(prev.start, curr.end);
					s.push(newI);
				}
			}
		}
		return s;
	}

	public static void main(String[] args) {
		
		List<Interval> newList = new ArrayList<Interval>();
		Interval i1 = new Interval(1,3);
		newList.add(i1);
		Interval i2 = new Interval(5,8);
		newList.add(i2);
		Interval i3 = new Interval(2,6);
		newList.add(i3);
		Interval i4 = new Interval(20,60);
		newList.add(i4);
		//System.out.println(newList.toString());
		Collections.sort(newList);
		
		
		// Now that the list is sorted, we start the overlap business
		Stack out = overlapped(newList);
		Iterator itr = out.iterator();
		while(itr.hasNext())
		{
			Interval curr = (Interval) itr.next();
			System.out.println("Interval "+curr.start+" "+curr.end);
		}
	}

}
