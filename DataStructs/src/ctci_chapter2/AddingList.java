package ctci_chapter2;

import linkedlist.ListNode;
import linkedlist.SingleLinkedList;

public class AddingList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SingleLinkedList s1 = new SingleLinkedList();
		s1.add(7);
		s1.add(1);
		//s1.add(6);
//		s1.print();
		System.out.println();
		SingleLinkedList s2 = new SingleLinkedList();
		s2.add(5);
		s2.add(9);
		s2.add(2);
	//	s2.print();
		
		ListNode curr1 = s1.getHead();
		ListNode curr2 = s2.getHead();
		SingleLinkedList s3 = new SingleLinkedList();
		int carry  = 0;
		while( (curr1 != null && curr1.getNext() !=null) || (curr2 != null && curr2.getNext() != null)){
			int temp = 0;
			if(curr1 == null) temp = curr2.getData();
			else if(curr2 == null) temp = curr1.getData();
			
			else temp = curr1.getData() + curr2.getData();
			temp+=carry;
			int ret = temp % 10;
			
			s3.add(ret);
			if(temp > 10){
				carry = 1;
			}
			else{
				carry = 0;
			}
			curr1 = curr1.getNext();
			curr2 = curr2.getNext();
		}
		
		int finalv = 0;
		if (curr1 == null && curr2 == null){
			finalv = carry;
		}
		if(curr1 == null && curr2 != null){
			finalv = curr2.getData() + carry;
		}
		if(curr1 != null && curr2 == null){
			finalv = curr1.getData() + carry;
		}
		
		s3.add(finalv);
		s3.print();
	}
	
	
		

}
