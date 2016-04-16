package linkedlist;

import java.util.Hashtable;
import java.util.Random;



public class UTSingleLinkedList {

	public  static SingleLinkedList sll;
	
	private void createList(int size){
		
		sll = new SingleLinkedList(size);
		Random rand = new Random();
		int i = 0;
		int randomNum = 0;
		while(i < size){
			randomNum = rand.nextInt((size - 1) + 1 ) ;
			sll.add(randomNum);
			i++;
		}

	}
	

	public  void testSnailOrSnake(){

		ListNode found = sll.findNthNodeFromEnd(6);
		ListNode found2 = sll.findNthNodeFromEnd(0); //last element
		
		System.out.println("\n"+"Found "+ found.getData());
		System.out.println("\n"+"Found "+ found2.getData());
		
		sll.isListBad();
	
		//Simulating the list to be bad by having found2 point to found instead of null
		found2.setNext(found);		
		sll.isListBad();
		
		
		// Find the bad node
		System.out.println("Bad node is " + sll.findBeginOfLoop().getData());
		
		
		//Establish length of loop
		System.out.println("Lenght of Loop is "+ sll.findLenghtOfLoop());
				
		//Reset the list to be good list
		found2.setNext(null);
		
		
	}
	
	/** REVISIT **/
	public void testReverseList(){
		
		SingleLinkedList original = sll;
		sll.reverseList();
		System.out.println("Reversed List :");
		sll.print();
		
		//Reset the list
		sll = original;
	}
	
	public void testMiddleElement(){
		
		System.out.println( "Middle element" + sll.findMiddleOfList().getData());
	}
	
	public void testPrintListInRevers(){
		sll.printListInReverse(sll.getHead());
	}
	
	public void testListLenght(){
		if(sll.isListLengthEven() == 0){
			System.out.println("List is even");
		}
		else{
			System.out.println("List is odd");
		}
	}
	
	public void testExchange(){
		System.out.println();
		sll.exchangeAdjacentElements();
		System.out.println();
		
		sll.print();
	}
	
	public static void main(String[] args) {
		
		// Create  a list
		UTSingleLinkedList utsl = new UTSingleLinkedList();
		utsl.createList(5);
		
		System.out.println("List");
		sll.print();
		
		utsl.testExchange();
		
	}

}
