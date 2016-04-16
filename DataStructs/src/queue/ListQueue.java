package queue;


public class ListQueue {

	ListNode rear = null;
	ListNode front = null;
	
	public ListQueue(){
		this.rear = null;
		this.front = null;
	}
	
	public static ListQueue createQueue(){
		return new ListQueue();
	}
	
	public boolean isQueueEmpty(){
		return (front == null);
	}
	
	public void enQueue(Object data){
		ListNode temp = new ListNode(data);
		if(rear != null){
			rear.setNext(temp);
		}
		rear = temp;
		if(front == null){
			front = rear;
		}
	}
	
	public Object deQueue(){
		
		Object temp = front.getData();
		front = front.getNext();
		return temp;
	}
	
	public void printQueue(){
		
		System.out.println("");
		ListNode curr = this.front;
		while(curr.getNext()!=null){
			System.out.print(curr.getData() + "-->");
			curr = curr.getNext();
		}
		System.out.print(curr.getData());
	}
	
}
