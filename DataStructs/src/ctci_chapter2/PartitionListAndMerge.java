package ctci_chapter2;

import linkedlist.ListNode;
import linkedlist.SingleLinkedList;

public class PartitionListAndMerge {

	public static SingleLinkedList sll = new SingleLinkedList();
	
	public static void main(String[] args) {

		sll.add(10);
		sll.add(2);
		sll.addAtStart(3);
		sll.add(9);
		sll.add(8);
		sll.add(3);
		sll.add(7);
		sll.add(5);
		sll.add(4);
		sll.print();
		int x = 9;
		
		SingleLinkedList before = new SingleLinkedList();
		SingleLinkedList after = new SingleLinkedList();
		
		ListNode curr = sll.getHead();
		
		while(curr != null){
			
			if(curr.getData() < x){
				before.addAtStart(curr.getData());
			}
			else{
				after.addAtStart(curr.getData());
			}
			curr = curr.getNext();
		}
		
		if(before.getHead() == null){
			sll = after;
		}
		
		else{
			ListNode curr1 = before.getHead();
			while( curr1.getNext() != null){
				curr1 = curr1.getNext();
			}
			curr1.setNext(after.getHead());
			sll = before;
		}
		
		System.out.println();
		sll.print();

	}

}
