package backtracking;

import java.util.Comparator;
import java.util.PriorityQueue;

class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1 < o2)
			return -1;
		else if(o1 > o2)
			return 1;
		else
			return 0;
	}
	
}

public class PermutationSequence {

	MyComparator comp = new MyComparator();
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(11, comp);

	public void generatePerms(int num)
	{
		String str = String.valueOf(num);
		generatePerms("", str);
	}
	
	public void generatePerms(String prefix, String str)
	{
		if(str.length() == 0)
		{
			pq.add(Integer.valueOf(prefix));
			return;
		}
		for(int i=0; i < str.length(); i++)
		{
			generatePerms(prefix+ str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()));
		}
	}
	
	public static void main(String[] args) {
		
		PermutationSequence p = new PermutationSequence();
		p.generatePerms(123);
		System.out.println(p.pq.toString());
		
		int k = 5;
		int counter = 1;
		while(! p.pq.isEmpty())
		{
			int temp = p.pq.poll();
			if(counter == k)
			{
				System.out.println(temp);
				break;
			}
			counter++;
		}
	}

}
