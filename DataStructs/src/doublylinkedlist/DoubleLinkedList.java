package doublylinkedlist;

public class DoubleLinkedList {

	private DoubleLinkedListNode head ;
	
	public DoubleLinkedList(int val){
		this.head = new DoubleLinkedListNode(val);
	}
	
	public void addAtEnd(int val){
		DoubleLinkedListNode newNode = new DoubleLinkedListNode(val);
		
		DoubleLinkedListNode curr = this.head;
		while(curr.getNext() != null){
			curr = curr.getNext();
		}
		newNode.setPrev(curr);
		curr.setNext(newNode);
	}
	
	public void addAtStart(int val){
		
		DoubleLinkedListNode newNode = new DoubleLinkedListNode( val );
		
		newNode.setNext(this.head);
		this.head.setPrev(newNode);
		this.head = newNode;
	}
	
	public void addAtPosition(int position, int val ){
		
		DoubleLinkedListNode newNode = new DoubleLinkedListNode(val);
		int counter = 0;
		DoubleLinkedListNode curr = this.head;
		while(curr.getNext() !=null && counter < position-1){
			curr = curr.getNext();
			counter++;
		}
		newNode.setPrev(curr);
		newNode.setNext(curr.getNext());
		curr.setNext(newNode);
	}
	
	public void deleteAtStart(){
		
		DoubleLinkedListNode temp = this.head;
		temp.getNext().setPrev(null);
		this.head = temp.getNext();
		temp = null;
	}
	
	public void deleteAtEnd(){
		
		DoubleLinkedListNode curr = this.head;
		while(curr.getNext()!=null){
			curr = curr.getNext();
		}
		curr.getPrev().setNext(null);
		curr = null;
	}
	
	public void deleteAtPosition(int position){
		
		DoubleLinkedListNode curr = this.head;
		int counter = 0;
		
		while(curr.getNext()!=null && counter < position-1){
			curr = curr.getNext();
			counter++;
		}
		DoubleLinkedListNode temp = curr.getNext();
		DoubleLinkedListNode nextNext = temp.getNext();
		nextNext.setPrev(curr);
		curr.setNext(nextNext);
		temp = null;
		
		
	}
	public void printList(){
		
		DoubleLinkedListNode curr = this.head;
		while(curr.getNext() != null){
			
			System.out.print(curr.getData() + "-->");
			curr = curr.getNext();
		}
		System.out.print(curr.getData()+"\n");
		
	}
}
