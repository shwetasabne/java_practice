package ctci_chapter2;

import java.util.Hashtable;

import linkedlist.ListNode;
import linkedlist.SingleLinkedList;

public class RemoveDuplicates {

	private static  SingleLinkedList sll = new SingleLinkedList(3);
	
	public void generateLinkedList(){
		
		sll.add(2);
		sll.add(7);
		sll.add(9);
		sll.add(2);
		sll.add(7);
		sll.add(4);
		sll.add(4);
	}
	
	public void removeDuplicatesHash(){
		
		Hashtable ht = new Hashtable();
		ListNode curr = sll.getHead();
		ListNode prev = curr;
		while(curr != null){
			
			if(ht.containsKey(curr.getData())){
				ListNode temp = curr.getNext();				
				prev.setNext(temp);
			}
			else{
				ht.put(curr.getData(), curr);
				prev = curr;
			}
			curr = curr.getNext();
		}

	}
	
	public  void removeDuplicatesPointers(){
		
		ListNode p1 = sll.getHead();
		
		while(p1 != null){
			ListNode p2 = p1.getNext();
			ListNode prev = p2;
			while(p2 != null){
				
				if(p1.getData() == p2.getData()){
					if(p2.getNext() == null )
						p1.setNext(null);
					else
						
					prev.setNext(p2.getNext());
					
				}
				else{
					prev = p2;
				}
			p2 = p2.getNext();	
		
			}
			
		p1 = p1.getNext();
		}
	}
	
	public static void main(String[] args) {
		
		RemoveDuplicates rm = new RemoveDuplicates();
		rm.generateLinkedList();
		rm.sll.print();
		
		System.out.println("Removing dups using Hash");
	//	rm.removeDuplicatesHash();
		rm.removeDuplicatesPointers();
		rm.sll.print();

	}

}
