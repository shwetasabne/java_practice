package infinitestreams;

import java.util.*;

class OutStreamElementComparator implements Comparator<OutputStreamElement>
{

	@Override
	public int compare(OutputStreamElement arg0, OutputStreamElement arg1) {
		
		if(arg0.value < arg1.value)
			return -1;
		if(arg0.value > arg1.value)
			return 1;
		else
			return 0;
	}
}

public class MergeInputStreams {

	
	Comparator os = new OutStreamElementComparator();
	PriorityQueue<OutputStreamElement> pq = new PriorityQueue<OutputStreamElement>(11, os);
	public List<OutputStreamElement> mergeInputStreams(ArrayList<InputStream> lists)
	{
		List<OutputStreamElement> output = new ArrayList<OutputStreamElement>();
		
		int[] lastReadElementId = new int[lists.size()];
		//Read the first element from each stream, 
		//Add to the priorityqueue
		Iterator itr = lists.iterator();
		int count = 0;
		
		// This is O(k) for k input streams
		while(itr.hasNext())
		{
			InputStream curr = (InputStream) itr.next();
			int firstElement = curr.readAt(0);
			if(firstElement != -1)
			{
				OutputStreamElement oe = new OutputStreamElement(firstElement, count);
				pq.offer(oe);
			}
			count++;
		}
		
		//Since the last read element id for all lists was 0 we update that in the lastReadElementId 
		for(int i=0; i<lastReadElementId.length; i++)
		{
			lastReadElementId[i] = 0;
		}

		while(!pq.isEmpty())
		{
			//Now read the first element from the PQ and add it to the oslist
			OutputStreamElement oe = pq.poll();
			System.out.println("!! Adding element "+oe.value+" from list "+oe.listIndex);
			output.add(oe);
			
			// Get the next element from the input stream from which this was read
			InputStream is = lists.get(oe.listIndex);
			int nextVal = is.readAt(++lastReadElementId[oe.listIndex]);
			if(nextVal != -1)
			{
				//Indicates that the input stream is not yet empty
				OutputStreamElement next = new OutputStreamElement(nextVal, oe.listIndex);
				pq.offer(next);
			}
		//	System.out.println("last read is "+Arrays.toString(lastReadElementId));
		}
		
		return output;
	}
	
	public static void main(String[] args)
	{
		InputStream is1 = new InputStream();
		is1.addTo(1);
		is1.addTo(3);
		is1.addTo(5);
		
		InputStream is2 = new InputStream();
		is2.addTo(2);
		is2.addTo(4);
		is2.addTo(6);
		
		InputStream is3 = new InputStream();
		is3.addTo(0);
		is3.addTo(0);

		
		ArrayList<InputStream> lists = new ArrayList<InputStream>();
		lists.add(is1);
		lists.add(is2);
		lists.add(is3);
		
		MergeInputStreams ms = new MergeInputStreams();
		List retVal = (ArrayList)ms.mergeInputStreams(lists);
		
	}
}
