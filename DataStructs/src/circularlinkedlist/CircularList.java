package circularlinkedlist;

public class CircularList {

	private CircularListNode head;
	
	public CircularList(int val){
		this.head = new CircularListNode(val);
		this.head.setNext(this.head);
	}
	
	public void addAtEnd(int val){
		CircularListNode newNode = new CircularListNode(val);
		CircularListNode curr = this.head;
		while(curr.getNext()!=null){
			if(curr.getNext() == this.head){
				curr.setNext(newNode);
				newNode.setNext(this.head);
				break;
			}
			curr = curr.getNext();
		}
	}
	
	public void addAtStart(int val){
		
		CircularListNode newNode = new CircularListNode(val);
		CircularListNode curr = this.head;
		while(curr.getNext() != null){
			if(curr.getNext() == this.head){
				newNode.setNext(this.head);
				curr.setNext(newNode);
				this.head = newNode;
				break;
			}
			curr = curr.getNext();
		}
	}
	
	public void addAtPosition(int position, int val){
		CircularListNode newNode = new CircularListNode(val);
		CircularListNode curr = this.head;
		int counter = 0;
		while(curr.getNext()!=this.head && counter < position - 1){
			curr = curr.getNext();
			counter++;
		}
		newNode.setNext(curr.getNext());
		curr.setNext(newNode);
	}
	
	public void printList(){
		
		CircularListNode curr = this.head;
		while(curr.getNext()!=null){
			System.out.print(curr.getData()+"-->");
			curr = curr.getNext();
			if(curr == this.head){break;}
		}
		System.out.print(curr.getData());
	}
}
