package stringsprep;

import java.util.Arrays;
import java.util.HashMap;

public class FirstNonRepeatingChar {

	private class DoubleLinkedList {
		char data;
		DoubleLinkedList prev;
		DoubleLinkedList next;
		
		DoubleLinkedList(char data)
		{
			this.data = data;
			this.prev = null;
			this.next = null;
		}
		
		void addNode(int data)
		{
			if(this.prev == null)
			{
				
			}
		}
	}
	
	DoubleLinkedList dllHead;
	DoubleLinkedList dllTail;
	//DoubleLinkedList travelNode = dllHead;
	HashMap<String, DoubleLinkedList> inDLL = new HashMap<String, DoubleLinkedList>();
	DoubleLinkedList [] indll ;
	boolean [] repeated;
	
	public void firstNonRepeatingChar(char [] arr)
	{
		
		repeated = new boolean[256];
		indll = new DoubleLinkedList[256];
		for(int i=0; i < arr.length; i++)
		{
			repeated[arr[i]] = false;
			indll[arr[i]] = null;
		}
	
		//Now iterate over the char arr 
		//If the character is not repeated, check if it is added to DLL and if not add to DLL
		for(int i=0; i < arr.length; i++)
		{
			System.out.println("Processing "+arr[i] + " "+repeated[arr[i]]);
			if(!repeated[arr[i]] && indll[arr[i]] == null)
			{
				
				DoubleLinkedList newNode = new DoubleLinkedList(arr[i]);
				if(dllHead == null && dllTail == null)
				{
					dllHead = newNode;
					dllTail = newNode;
					dllHead.next = dllTail;
					dllTail.prev = dllHead;
				}
				else
				{
					
					dllTail.next = newNode;
					newNode.prev = dllTail;
					dllTail = newNode;
				}
				indll[arr[i]] = newNode;
				//System.out.println(inDLL.toString());
			}
			else if(!repeated[arr[i]] && indll[arr[i]] != null)
			{
				//System.out.println(" "+arr[i]+" has come in second");
				DoubleLinkedList temp = indll[arr[i]];
				
				if(temp == dllHead)
				{
					DoubleLinkedList tempNext = temp.next;
					dllHead = tempNext;
					temp = null;
				}
				else if(temp == dllTail)
				{
					DoubleLinkedList tempPrev = temp.prev;
					dllTail = tempPrev;
					temp = null;
				}
				else
				{
					//Remove node by making it's prev point to it's next
					DoubleLinkedList tempPrev = temp.prev;
					DoubleLinkedList tempNext = temp.next;
					tempPrev.next = tempNext;
					tempNext.prev = tempPrev;
					temp = null;
				}
				indll[arr[i]] = null;
				repeated[arr[i]] = true;
			}

			System.out.println("First non repeating character is "+dllHead.data);
			System.out.println("****");
		}
	}
	
	public static void main(String[] args) {
		
		FirstNonRepeatingChar f = new FirstNonRepeatingChar();
		String s = "geeksforgeeksandgeeksquizfor";
		f.firstNonRepeatingChar(s.toCharArray());
	}

}
