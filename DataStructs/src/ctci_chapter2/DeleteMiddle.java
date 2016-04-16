package ctci_chapter2;

import linkedlist.ListNode;
import linkedlist.SingleLinkedList;

public class DeleteMiddle {

	public static SingleLinkedList sll = new SingleLinkedList(1);
	
	public void delete (int data){
		
		ListNode curr = sll.getHead();
		ListNode prev = curr;
		
		while(curr != null){
			
			if(curr.getData() == data){
				prev.setNext(curr.getNext());
				curr.setNext(null);
			}
			prev = curr;
			curr = curr.getNext();
		}
		
	}
	
	public static void main(String[] args) {
		
		sll.add(2);
		sll.add(3);
		sll.add(4);
		sll.add(5);
		System.out.println();
		sll.print();
		DeleteMiddle dl = new DeleteMiddle();
		dl.delete(40);
		System.out.println();
		sll.print();
		dl.delete(5);
		System.out.println();
		sll.print();
		dl.delete(1);
		System.out.println();
		sll.print();

	}

}
