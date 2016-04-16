package linkedlist;

import java.util.Hashtable;

public class SingleLinkedList {

	private ListNode head;
	
	public ListNode getHead() {
		return head;
	}

	public void setHead(ListNode head) {
		this.head = head;
	}

	public SingleLinkedList(int data){
		this.head = new ListNode(data);
	}
	
	public SingleLinkedList(){
		
	}
	
	public void add (int val){
		if(this.head == null){
			this.head = new ListNode(val);
		}
		else {
			ListNode curr = this.head;
		while(curr.getNext() != null){
			curr = curr.getNext();
		}
		curr.setNext(new ListNode(val));
		}
	}
	
	public void addAtStart(int val){
		if(this.head == null){
			this.head = new ListNode(val);
		}
		else {
			ListNode curr = new ListNode(val);
			curr.setNext(this.head);
			this.head = curr;
		}
	}
	
	public void print (){
		
		ListNode curr = this.head;
		while(curr.getNext() != null){
			System.out.print(curr.getData()+ "-->");
			curr = curr.getNext();
		}
		System.out.print(curr.getData());
	}
	
	public void insertNode(int position, int val){
		
		if(position == 0)
		{
			this.addAtStart(val);
			return;
		}
		ListNode newNode = new ListNode(val);
		ListNode prevNode = this.head;
		
		int count = 0;
		
		while (count < position - 1){
			prevNode = prevNode.getNext();
			count++;
		}
		ListNode currNode = prevNode.getNext();
		newNode.setNext(currNode);
		prevNode.setNext(newNode);
	}
	
	public void deleteAtStart(){
		
		ListNode temp = this.head;
		this.head = this.head.getNext();
		temp.setNext(null);
	}
	
	public void delete(){
		
		ListNode prev = this.head;
		ListNode curr = prev;
		while(curr.getNext() != null){
			prev = curr;
			curr = curr.getNext();
		}

		prev.setNext(null);
		curr.setNext(null);
	}
	
	public void deleteAtPosition(int position){
		
		ListNode prev = this.head;
		int count = 0;
		while(count < position-1){
			prev = prev.getNext();
			count++;
		}
		ListNode tempNodeToDelete = prev.getNext();
		ListNode actualNext = tempNodeToDelete.getNext();
		prev.setNext(actualNext);
		tempNodeToDelete.setNext(null);
	}
	
	public  boolean isListBad(){
		
		Hashtable<ListNode, ListNode> ht = new Hashtable<ListNode, ListNode>();
		ListNode curr = this.getHead();
		while(curr.getNext() != null){
			if(! ht.containsKey(curr)){
				
				ht.put(curr, curr.getNext());
			}
			else{
				System.out.println("Bad list");
				return true;
			}
			curr = curr.getNext();
		}
		System.out.println("Good list");
		return false;
		
	}
	
	public  boolean isListBadOptimal(){
		
		if(this.getHead() == null){
			return false;
		}
		ListNode slow = this.getHead();
		ListNode fast = this.getHead();
		while(fast.getNext()!=null && fast.getNext().getNext()!=null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast)
			{
				System.out.println("Bad list");
				return true;
			}
		}
		System.out.println("Good list");
		return false;
	}
	
	public  ListNode findNthNodeFromEnd(int n){
		
		ListNode found = null;		
		ListNode pFast = this.getHead();

		for(int i=0; i < n ; i++){
			if(pFast.getNext() != null){
				pFast = pFast.getNext();
			}
		}
		while(pFast.getNext() != null){
			if(found !=null && found.getNext() != null){
				found = found.getNext();
			}
			else{
				found = this.getHead();
			}
			pFast = pFast.getNext();
		}
		
		if(found != null)
		return found.getNext();
		else
		return null;
	}
	
	public ListNode findBeginOfLoop(){
		
		//First check if the list is snail or snake and if snail,
		// then set slow pointer --> head
		// both slow and fast pointer move together and where they meet is the loop node
		ListNode slow = this.head;
		ListNode fast = this.head;
		if(head == null)
		{
			return null;
		}
		boolean isLoopExists = false;
		while( fast.getNext()!=null && fast.getNext().getNext()!=null ){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast){
				isLoopExists = true;
				break;
			}
		}
		if(isLoopExists){
			slow = this.head;
			while(slow != fast){
				slow = slow.getNext();
				fast = fast.getNext();
			}
			return slow;
		}
		return null;
	}
	
	public int findLenghtOfLoop(){
		
		ListNode slow = this.head;
		ListNode fast = this.head;
		while(this.head == null){
			return 0;
		}
		boolean isLoopExists = false;
		int counter = 0;
		while (fast.getNext()!=null && fast.getNext().getNext()!=null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast){
				isLoopExists = true;
				break;
			}
		}
		if(isLoopExists){
			fast = fast.getNext();
			while(slow!=fast){
				fast = fast.getNext();
				counter++;
			}
		}
		return counter;
	}
	
	public void reverseList(){
		
		ListNode temp = null;
		ListNode nextNode = null;
		System.out.println("DEBUG head " + this.head.getData());
		while(this.head != null){	
			
			if(this.head.getNext() == null){
				nextNode = null;
			}
			else{
				nextNode = this.head.getNext();
			}
			this.head.setNext(temp);
			temp = this.head;
			if(nextNode !=null){
				this.head = nextNode;
			}
			else{
				break;
			}
		}
	}
	
	public ListNode findMiddleOfList(){
		
		ListNode ptr1 = this.head, ptr2 = this.head;
		int i = 0;
		while(ptr1.getNext() != null){
			
			if(i == 0){
				ptr1 = ptr1.getNext();
				i = 1;
			}
			else if(i == 1){
				ptr1 = ptr1.getNext();
				ptr2 = ptr2.getNext();
				i = 0;
			}
		}
		return ptr2;
	}
	
	public void printListInReverse(ListNode head){
		
		if(head == null){
			return;
		}
		System.out.println(head.getData());
		printListInReverse(head.getNext());
		//System.out.println(head.getData());
	}
	
	public int isListLengthEven(){
		
		ListNode curr = this.head;
		while(curr.getNext() !=null && curr.getNext().getNext() !=null){
			curr = curr.getNext().getNext();
			if(curr.getNext() == null ) 
			{
				
				return 0;
			}
		}
		return 1;
			
	}

	public void exchangeAdjacentElements(){
		
		ListNode currNode, temp, nextNode;
		currNode = this.head;
		if(currNode  == null || currNode.getNext() == null){
			this.head = currNode.getNext();
		}
		// 5 -> 2 -> 3 -> 4 -> 7
		while(currNode != null && currNode.getNext() != null){
			nextNode = currNode.getNext(); //nextNode == 2
			System.out.println("Next node "+nextNode.getData());
			currNode.setNext(nextNode.getNext()); // 5 -> 3
			nextNode.setNext(currNode); // 2 -> 5 ->3 -> 4 ->7
			temp = currNode.getNext();
			if(temp!=null && temp.getNext()!=null){
				currNode.setNext(currNode.getNext().getNext());
			}
			currNode = temp;
		}
		
	}
}
