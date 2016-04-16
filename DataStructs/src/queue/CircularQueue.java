package queue;

import java.util.Arrays;

class CircularQueueBase {
	
	int capacity = 5;
	int size ;
	int [] queueArray ;
	int rearIdx;
	int frontIdx;
	
	public CircularQueueBase()
	{
		this.size = 0;
		this.queueArray = new int[capacity];
		this.rearIdx = 0;
		this.frontIdx = 0;
	}
	
	public boolean isFull()
	{
		int diff = rearIdx - frontIdx;
		if(diff == -1 || diff == size-1)
		{
			return true;
		}
		return false;
	}
	
	public boolean isEmpty()
	{
		return (rearIdx == frontIdx);
	}
	
	public void enQueue(int element) throws Exception
	{
		if(this.isFull())
			throw new Exception("Queue is full");
		else
		{
			this.queueArray[rearIdx] = element;
			this.rearIdx = (this.rearIdx+1)%this.capacity;
			this.size ++;
		}
	}
	
	public int deQueue() throws Exception
	{
		int item ;
		if(this.isEmpty())
		{
			throw new Exception("Queue is empty");
		}
		else
		{
			item = this.queueArray[this.frontIdx];
			this.queueArray[this.frontIdx] = -1;
			this.frontIdx = (this.frontIdx + 1)% this.capacity;
			this.size--;
			
		}
		return item;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public String toString()
	{
		return ("[" + Arrays.toString(this.queueArray) + "]");
	}
}

public class CircularQueue {
	
	public static void main(String[] args) throws Exception {
		
		CircularQueueBase c = new CircularQueueBase();
		System.out.println("Size is "+c.getSize());
		
		c.enQueue(10);
		c.enQueue(20);
		c.enQueue(30);
		c.enQueue(40);
		
		System.out.println(c.toString());
		System.out.println();
		
		int m = c.deQueue();
		System.out.println("dequeeued "+m);

	}

}
