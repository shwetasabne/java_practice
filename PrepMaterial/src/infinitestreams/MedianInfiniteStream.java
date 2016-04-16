package infinitestreams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class MaxHeapComparator implements Comparator<Double> {

	@Override
	public int compare(Double o1, Double o2) {
		if(o1 < o2)
			return 1;
		else if(o1 > o2)
			return -1;
		else
			return 0;
	}
	
}

class MinHeapComparator implements Comparator<Double> {

	@Override
	public int compare(Double o1, Double o2) {
		if(o1 < o2)
			return -1;
		else if(o1 > o2)
			return 1;
		else
			return 0;
	}
	
}

public class MedianInfiniteStream {

	public static MinHeapComparator minHeapComp = new MinHeapComparator(); 
	public static PriorityQueue<Double> minHeap = new PriorityQueue(11,minHeapComp);
	
	public static MaxHeapComparator maxHeapComp = new MaxHeapComparator(); 
	public static PriorityQueue<Double> maxHeap = new PriorityQueue(11,maxHeapComp);

	public static double returnMedian(double n)
	{
		double median = -1;
		
		// Decide where to put n
		if(maxHeap.size() == 0 && minHeap.size() == 0)
		{
			maxHeap.add(n);
			return n;
		}
		if(n < maxHeap.peek())
			maxHeap.add(n);
		else
			minHeap.add(n);
		
		if(Math.abs(maxHeap.size() - minHeap.size()) > 1)
		{
			if(maxHeap.size() > minHeap.size())
			{
				double temp = maxHeap.poll();
				minHeap.add(temp);
			}
			else
			{
				double temp = minHeap.poll();
				maxHeap.add(temp);
			}
		}
		
		if(minHeap.size() == maxHeap.size())
		{
			System.out.println("Calcultatin media");
			median = (minHeap.peek() + maxHeap.peek())/2;
		}
		else
		{
			if (minHeap.size() > maxHeap.size())
				median = minHeap.peek();
			else
				median = maxHeap.peek();
		}
		System.out.println("minHeap top "+minHeap.peek() + " maxHeap top "+maxHeap.peek());
		return median;
	}

	public static void main(String[] args) {
		
		System.out.println("enter number");
		Scanner sc = new Scanner(System.in);
		MedianInfiniteStream m = new MedianInfiniteStream();
		while(true)
		{
			String input = sc.next();
			if(input.equals("end"))
			{
				System.out.println("Final median is ");
				break;
			}
			System.out.println("You entered "+Integer.valueOf(input));
			double median = returnMedian(Integer.valueOf(input));
			System.out.println("Median is "+median);
			System.out.println("Enter next number ");
		}
	}

}
