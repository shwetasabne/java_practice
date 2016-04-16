package stacksandqueue;

import java.util.Arrays;

class LocalStack {
	
	int [] stackPointer = {-1, -1, -1};
	int [] stackArr ;
	int stackSize ;
	public LocalStack(int capacity){
		stackArr = new int[capacity * 3];
		this.stackSize = capacity;
	}
	public LocalStack(){
		this.stackSize = 3;
		stackArr = new int[stackSize * 3];
	}
	
	private int topOfStackIndex(int stackNum){
		
		return stackNum * stackSize + stackPointer[stackNum];
	}

	public void push (int stackNum, int data) throws Exception{
		
		if(stackPointer[stackNum] + 1 >= stackSize){
			throw new Exception ("Out of memory");
		}
		stackPointer[stackNum]++;
		stackArr[topOfStackIndex(stackNum)]  = data;
	}
	
	public int pop (int stackNum) {
		
		if(stackPointer[stackNum] < 0){
			return -1;
		}
		else {
			int temp = stackArr[topOfStackIndex(stackNum)];
			stackPointer[stackNum]--;
			return temp;
		}
	}
	
	public int peek (int stackNum){
		
		if(stackPointer[stackNum] < 0){
			return -1;
		}
		else{
			
			return stackArr[topOfStackIndex(stackNum)];
		}
	}
}

public class OneArrayThreeStacks {


	public static void main(String[] args) throws Exception {
		
		LocalStack s1 = new LocalStack();
		s1.push(0, 1);
		s1.push(1, 21);
		s1.push(2, 31);
		
		System.out.print("Peeking stack \n");
		for(int i=0; i < s1.stackPointer.length; i++){
			System.out.print(" Stack Num "+i+" Top Element "+s1.peek(i)+"\n");
		}
		
		s1.push(0, 2);
		s1.push(0, 3);
	//	s1.push(0, 4);
		System.out.println(Arrays.toString(s1.stackPointer));
		System.out.print("Peeking stack \n");
		for(int i=0; i < s1.stackPointer.length; i++){
			System.out.print(" Stack Num "+i+" Top Element "+s1.peek(i)+"\n");
		}
		System.out.println(Arrays.toString(s1.stackArr));
	//	s1.push(0, 5);
		
		System.out.println("Popping Stack ");
		System.out.print( " Popped element is "+s1.pop(1));
		System.out.print( " Popped element is "+s1.pop(1));
	}

}
