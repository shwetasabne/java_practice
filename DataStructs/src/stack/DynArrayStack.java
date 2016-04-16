package stack;

public class DynArrayStack {

	private int top;
	private int capacity;
	private char[] array;
	
	public DynArrayStack(){
		capacity = 1;
		top = -1;
		array = new char[capacity];
	}
	
	public boolean isStackFull(){
		return (top == capacity-1);
	}
	
	public boolean isStackEmpty(){
		return (top == -1);
	}
	
	public void push(char data){
		if(isStackFull()){
			doubleStack();
		}
		array[++top] = data;
	}
	
	public char pop(){
		if(isStackEmpty()){
			System.out.println("stack is empty");
			return 0;
		}
		else{
			return (array[top--]);
		}
	}
	public void doubleStack(){
		char newArry[] = new char[capacity * 2];
		System.arraycopy(array, 0, newArry, 0, capacity);
		capacity = capacity * 2;
		array = newArry;
	}
	public void printStack(){
		
		for(int i=0; i <= top; i++){
			System.out.print(this.array[i] + " -> ");
		}
		System.out.println();
	}

}
