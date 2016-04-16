package stacksandqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class LocalStackArr {
	
	public int capacity ;
	public int [] stackArr ;
	public int stackSize;
	public int bottom;
	
	public LocalStackArr(int capacity){
		this.capacity = capacity;
		stackArr = new int[capacity];
		this.stackSize = 0;
	}
	
	public boolean isFull(){
		if(this.stackSize == this.capacity){
			return true;
		}
		else
			return false;
	}
	
	public boolean push(int data){

		if(this.stackSize == this.capacity){
			return false;
		}
		else {
			//System.out.println("TOS is "+this.topOfStack());
			this.stackArr[this.topOfStack()+1] = data;
			
			this.stackSize++;
			if(this.stackSize == 1){
				this.bottom = data;
			}
		}
		return true;
	}
	
	public boolean isEmpty(){
		
		if(this.stackSize == 0)
			return true;
		else
			return false;
	}
	
	public int pop(){
		
		if(this.stackSize == 0){
			return -1;
		}
		else {
			int temp = this.stackArr[this.topOfStack()];
			this.stackArr[this.topOfStack()] = 0;
			this.stackSize--;
			return temp;
		}
	}
	
	public int topOfStack(){
		
		if(this.stackSize == 0){
			return -1;
		}
		else {
			return this.stackSize-1;
		}
	}
	
	public void printStack(){
		System.out.println(" Stack is " + Arrays.toString(this.stackArr));
	}
	
	public int removeBottom(){
		// Pop but in reverse direction
		int v = this.stackArr[0];
		this.stackSize--;
		int i =0;
		for(i=0; i < this.stackArr.length-1;i++){
			this.stackArr[i] = this.stackArr[i+1];
		}
		this.stackArr[i] = 0;
		return v;
	}
	

	
}

class StackSet {
	
	ArrayList<LocalStackArr> stackNum ;
	
	public int currStackNum ;
	
	public  StackSet(){
		this.currStackNum = 0;
		this.stackNum = new ArrayList<LocalStackArr>();
	//	this.stackNum.add(new LocalStackArr(3));
	}
	
	public LocalStackArr getLastStack(){
		
		if(this.stackNum.size() == 0){
			return null;
		}
		else {
			return this.stackNum.get(this.stackNum.size()-1);
		}
	}

	public void push(int data){
		
		LocalStackArr temp = this.getLastStack();
		if(temp != null && !temp.isFull()){
			temp.push(data);
		}
		else {
			LocalStackArr l = new LocalStackArr(3);
			l.push(data);
			stackNum.add(l);
		}
	}
	
	public int pop(){
		
		LocalStackArr temp = this.getLastStack();
		int val = temp.pop();
		if(temp.isEmpty()){
			this.stackNum.remove(this.stackNum.size()-1);
		}
		return val;
	}
	
	public int popAt(int index){
		
		if(index >= this.stackNum.size()){
			return -1;
		}
		
		//First pop out the original stack and for each next stack pop out the bottom
		LocalStackArr interim = this.stackNum.get(index);
		int val = interim.pop();
		if(interim.isEmpty()){
			this.stackNum.remove(index);
		}
		else{
			//Rollover mechanism
			int j = index; // j points to current stack, i points to next stack
			for(int i = index+1; i < this.stackNum.size(); i++){
				//Since we have removed element from j, there is space
				// So fetch the bottom from i and push it in j
				LocalStackArr curr = this.stackNum.get(j);
				LocalStackArr next = this.stackNum.get(i);
				//Remove the bottom element of i and put it in j
				int bottomElement = next.removeBottom();
				curr.push(bottomElement);
				j++;
			}
		}
		return val;
	}
	
	public void print(){
		Iterator<LocalStackArr> itr = this.stackNum.iterator();
		while(itr.hasNext()){
			LocalStackArr temp = itr.next();
			temp.printStack();
			System.out.println();
		}
	}
	
}

public class SetOfStacks {

	
	
	public static void main(String[] args) {

		StackSet ss = new StackSet();
		
		ss.push(1);
		ss.push(2);
		ss.push(3);
	/*	Iterator<LocalStackArr> itr = ss.stackNum.iterator();
		while(itr.hasNext()){
			LocalStackArr temp = itr.next();
			temp.removeBottom();
			temp.printStack();
			System.out.println();
			break;
		}*/
		ss.push(10);
		ss.push(11);
		ss.push(12);
		ss.push(20);
		ss.push(21);
		ss.push(22);
		ss.push(30);
		ss.push(31);
		ss.push(32);
		ss.print();
		ss.popAt(1);
		ss.popAt(1);
		ss.popAt(1);
		System.out.println("^^");
		//ss.pop();
		ss.print();
		System.out.println("^^");
		ss.print();
	}

}
