package circularlinkedlist;

import java.util.Random;

import linkedlist.SingleLinkedList;

public class UTCircularLinkedList {

	public static CircularList sll;
	
	public void createList(int size){
		
		sll = new CircularList(size);
		Random rand = new Random();
		int i = 0;
		int randomNum = 0;
		while(i < size){
			randomNum = rand.nextInt((size - 1) + 1 ) ;
			sll.addAtEnd(randomNum);
			i++;
		}

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
