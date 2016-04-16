package infinitestreams;

import java.util.Comparator;
import java.util.PriorityQueue;

class IntegerComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1 < o2)
			return 1;
		else if(o1 > o2)
			return -1;
		else
			return 0;
	}
}

public class KLargestElement {

	IntegerComparator i = new IntegerComparator();
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(11, i); 
	
	public int kthLargestElement(int [] a, int k)
	{
		int element = -1;
		
		// Put the array in pq
		for(int i=0; i < a.length; i++)
		{
			this.pq.offer(a[i]);
		}
		System.out.println(this.pq.toString());
		int i=0;
		int m = -1;
		while(i < k)
		{	
			m = this.pq.poll();
			System.out.println("m is "+m+" i "+i);
			i++;
		}
		return m;
	}
	public static void main(String[] args) {
		
		KLargestElement n = new KLargestElement();
		int [] a = {19, 21, 16, 23, 46, 1, 12};
		int out = n.kthLargestElement(a, 4);
		System.out.println(" "+out);
 	}



}
