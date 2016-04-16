package queue;

public class UTListQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListQueue lq = new ListQueue();
		lq.enQueue(1);
		lq.enQueue(2);
		lq.enQueue(3);
		lq.printQueue();
		System.out.println(lq.deQueue());
	}

}
