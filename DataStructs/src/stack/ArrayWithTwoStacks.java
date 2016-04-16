package stack;

public class ArrayWithTwoStacks {

	private int[] dataArray;
	private int size;
	private int top1;
	private int top2;
	
	public ArrayWithTwoStacks(int size){
		this.size = size;
		this.top1 = -1;
		this.top2 = this.size;
		dataArray = new int[size];
	}
	
	public void push(int stackid, int data){
		if(top1 == top1+1) {
			System.out.println("Stack overflow");
		}
		if(stackid == 1){
			dataArray[++top1] = data;
		}
		else{
			dataArray[--top2] = data;
		}
	}
	
	public int pop(int stackid){
		if(stackid == 1){
			return (dataArray[top1--]);
		}
		else{
			return dataArray[top2++];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
