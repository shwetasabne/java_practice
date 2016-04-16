package treesandgraphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Node {
	
	Object data;
	Node next;
	
	public Node(Object data){
		this.data = data;
	}
}

class Queue {
	
	private Node head;
	//private Node tail;
	int size = 0;
	
	public void enQueue(Object data){
		Node newNode = new Node(data);
		if(this.head == null)
			this.head = newNode;
		else{
			Node temp = this.head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = newNode;
		}
		this.size++;
	}
	
	public boolean isEmpty(){
		if(this.size <=0 )
			return true;
		else
			return false;
	}
	
	public Object deQueue(){
		
		if(this.isEmpty())
			return (Character) null;		
		else{
			Object temp = this.head.data;
			this.head = this.head.next;
			this.size--;
			return temp;
		}
	}

}

class Vertex {
	
	char label ;
	List<Vertex> adjacents ;
	boolean visited;
	
	public Vertex(char label){
		this.label = label;
		this.visited = false;
		this.adjacents = new LinkedList<Vertex>();
	}
	
	public void addEdge(Vertex destination){
		this.adjacents.add(destination);
		destination.adjacents.add(this);
	}
	
	public void printAdjacents(){
		LinkedList temp = (LinkedList) this.adjacents;
		Iterator itr = temp.iterator();
		while(itr.hasNext()){
			System.out.print(" "+((Vertex)itr.next()).label+" ");
		}
	}
}


public class RouteBetweenTwoNodes {

	public boolean areNodesConnectedDfs(Vertex source, Vertex dest){
		
		// Call dfs on the source
		this.dfs(source);
		//if destination has been visited, then they are connected
		return dest.visited;
	}

	// Using DFS
	public void dfs(Vertex source){
		
		source.visited = true;
		LinkedList adj = (LinkedList)source.adjacents;
		Iterator itr = adj.iterator();
		while(itr.hasNext()){
			Vertex nextNode = (Vertex) itr.next();
		//	System.out.println("Curre next is "+nextNode.label);
			if(!nextNode.visited){
				dfs(nextNode);
			}
		}
		
	}
	
	public boolean areNodesConnectedBfs(Vertex source, Vertex dest){
		
		Queue q = new Queue();
		source.visited = true;
		q.enQueue(source);
		
		while(!q.isEmpty()){
			
			Vertex curr = (Vertex)q.deQueue();
			LinkedList adjs = (LinkedList) curr.adjacents;
			Iterator itr = adjs.iterator();
			while(itr.hasNext()){
				Vertex temp = (Vertex)itr.next();
				if(!temp.visited){
					if(temp.label == dest.label){
						return true;
					}
					temp.visited = true;
					q.enQueue(temp);
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		
		Vertex a = new Vertex('a');
		Vertex b = new Vertex('b');
		Vertex c = new Vertex('c');
		Vertex d = new Vertex('d');
		Vertex e = new Vertex('e');
		Vertex f = new Vertex('f');
		
		a.addEdge(b);
		b.addEdge(c);
		b.addEdge(d);
		c.addEdge(e);
		
		RouteBetweenTwoNodes r = new RouteBetweenTwoNodes();
		System.out.println(r.areNodesConnectedDfs(c, f));
		
		a.visited = false;
		b.visited = false;
		c.visited = false;
		d.visited = false;
		e.visited = false;
		f.visited = false;
		System.out.println(r.areNodesConnectedBfs(c, f));
		
	}

}
