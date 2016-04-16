package arrayTricky;

import java.util.*;

public class SortA1LikeA2 {


	public void sortA1likeA2(int [] a1, int [] a2) 
	{
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		for(int i=0; i < a1.length; i++)
		{
			if(m.containsKey(a1[i]))
			{
				m.put(a1[i], m.get(a1[i]) +1);
			}
			else
			{
				m.put(a1[i], 1);
			}
		}
		System.out.println("debug "+m.toString());
		
		int [] output = new int[a1.length];
		int j = 0;
		for(int i=0; i < a2.length; i++)
		{
			if(m.containsKey(a2[i]))
			{
				int val = m.get(a2[i]);
				int counter = 0;
				while(counter < val)
				{
					output[j] = a2[i];
					j++;
					counter++;
				}
				m.remove(a2[i]);
			}
		}
		System.out.println("debug "+m.toString());
		System.out.println("debug "+ Arrays.toString(output));

		Iterator it = m.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry<Integer, Integer> pair = (Map.Entry)it.next();
			int key = pair.getKey();
			int val = pair.getValue();
			int counter = 0;
			while(counter < val)
			{
				output[j] = key;
				j++;
				counter++;
			}
		}
		
		System.out.println("debug "+ Arrays.toString(output));
	}
	
	public static void main(String[] args) {
		
		int [] a1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
		int [] a2 = {2, 1, 8, 3, 10};
		
		SortA1LikeA2 m = new SortA1LikeA2();
		m.sortA1likeA2(a1, a2);
		
	}

}
