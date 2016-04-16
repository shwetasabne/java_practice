package doublylinkedlist;

public class UTDoubleLinkedListNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DoubleLinkedList dll = new DoubleLinkedList(5);
		
		dll.addAtEnd(10);
		dll.addAtEnd(15);
		dll.addAtEnd(20);
		dll.printList();

		System.out.println();
		
		dll.addAtStart(25);
		dll.printList();
		
		System.out.println();
		dll.addAtPosition(3, 30);
		dll.printList();

		System.out.println();
		dll.deleteAtStart();
		dll.printList();
		
		System.out.println();
		dll.deleteAtEnd();
		dll.printList();
		
		System.out.println();
		dll.deleteAtPosition(2);
		dll.printList();
	}

}
