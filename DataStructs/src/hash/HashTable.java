package hash;


public class HashTable {

	private  class ListNode {	
		String key;
		String value;
		ListNode next;
	}
	
	// the table looks like this
	// table[1] = ListNode_latest
	//			And this List_Node_latest points to  -> ListNode_secondLast ->... ->ListNode_first element -> null 
	//			Thus representing latest node in a Linked List
	//			We are adding nodes at start of the linked list
	// the table index is the hashcode of the key
	private ListNode [] table;
	private static int sizeOfHashTable = 0;
	
	// Default initialization of 64
	public HashTable(){
		table = new ListNode[64];
	}
	
	//If size is given then use that
	public HashTable(int size) throws Exception{
		if(size <= 0){
			throw new Exception("Size cannot be less than or equal to 0");
		}
	}
	
	// I will take the hashcode of the string and then mod it by 10
	// I will implement repeated doubling for the hash table size
	private int hash(Object key){
		return (Math.abs(key.hashCode())) % 10;	
	}
	
	public void dump(){
		
		for(int i=0; i < table.length; i++){
			System.out.print(i + ":");
			ListNode latestNode = table[i];
			while(latestNode != null){
				System.out.print("  (" + latestNode.key + "," + latestNode.value + ")");
				latestNode = latestNode.next;
			}
			System.out.println();
		}
	}
	
	public void put(String key, String value){
		
		int bucket = hash(key);
		
		ListNode node = table[bucket];
		
		// Check if this above list, is not null iterate to see if the key is already added
		// Iterate over the list to find if the key is already added
		while(node != null){
			if(node.key.equals(key)){
				break;
			}
			// Key not found, hence move on to the next node in the list
			node = node.next;
		}
		
		// At this point, the key is not added
		if(node !=null){
			//Means we broke from the while loop and that means we have the key already added
			// So we simply replace the key
			node.value = value;
		}
		else{
			// Either the list is null or key is not found
			ListNode newNode = new ListNode();
			newNode.key = key;
			newNode.value = value;
			// This new node's next points to the current latest Node
			newNode.next = table[bucket];
			// Now since the newNode becomes latest node, put that in the table
			table[bucket] = newNode;
			sizeOfHashTable++;
		}
		
	}
	
	public String get(String key){
		
		// First get the hashcode of the key
		int bucket = hash(key);
		
		// See if this is in the table
		// This is the last node in the linked list
		ListNode ln = table[bucket];
		while(ln != null){
			if(ln.key.equals(key)){
				return ln.value;
			}
			// Go on iterating over the linked list
			ln = ln.next;
		}
		return null;
	}
	
	public boolean containsKey(String key){
		
		int bucket = hash(key);
		ListNode ln = table[bucket];
		while(ln != null){
			if(ln.key.equals(key)){
				return true;
			}
			ln = ln.next;
		}
		return false;
	}
	
	public int size(){
		return sizeOfHashTable;
	}
	
	public void remove(String key){
		
		// First check if key exists
		if(! this.containsKey(key)){
			return;
		}
		
		int bucket = hash(key);
		
		//First case : if this key turns out to be the first node on table[bucket]
		ListNode ln = table[bucket];
		if(ln.key.equals(key)){
			ListNode newLatest = ln.next;
			table[bucket] = newLatest;
			sizeOfHashTable--;
			return;
		}
		
		ln = table[bucket];
		ListNode prev = ln;
		// Now incase this key is hidden somewhere inside the list
		while(ln != null){

			if (ln.key.equals(key)){
				System.out.println("Key found");
				// This will happen if we are deleting the last element in the list
				if(ln.next != null){
					prev.next = ln.next;
				}
				else{
					
					prev.next = null;
				}
				
			}
			prev = ln;
			if(ln.next != null) ln = ln.next;
			sizeOfHashTable--;
			return;
		}
	}
}
