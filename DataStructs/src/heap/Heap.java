package heap;

import java.util.Arrays;

public class Heap {

	int count = 0;
	public int [] array ;
	int capacity = 0;
	
	
	public Heap(int capacity){
		
		this.capacity = capacity;
		this.count = 0;
		this.array = new int[this.capacity];
	}
	
	// Parent of given index
	public int Parent (int i){
		
		if( i<=0 || i >= this.count){
			return -1;
		}
	
		return (i-1)/2;
	}
	
	public int LeftChild(int i){

		int left = (2 * i) + 1;
		if(left >= this.count){
			return -1;
		}
		return left;
	}
	
	public int RightChild(int i){

		int right = (2 * i) + 2;
		if(right >= this.count){
			return -1;
		}
		return right;
	}
	
	public int getMaximum(){
		if(this.count == 0){
			return -1;
		}
		return this.array[0];
	}
	
	public void resizeHeap(){
		System.out.println("Resizing array");
		int [] array_old = new int [this.capacity];
		System.arraycopy(this.array, 0, array_old, 0, this.capacity);
	//	System.out.println("Resizing array + 1 "+this.array.length + " "+ array_old.length);
	//	System.out.println(Arrays.toString(array_old));
		this.capacity *= 2;
		this.array = new int[this.capacity];
		System.out.println("hey "+this.array.length);
		if(this.array == null){
			System.out.println("Memory Error");
			return;
		}
		for(int i=0; i < array_old.length; i++){
			this.array[i] = array_old[i];
		}
		
		array_old = null;
	}
	
	public void insertElement(int data){
		
		int i =0;
		if(this.count == this.capacity){
			
			resizeHeap();
		}
	//	System.out.println("Done");
		this.count++;
		i = this.count-1;
		while(i >0 && data > this.array[(i-1)/2]){
			
			this.array[i] = this.array[(i-1)/2];
			i = (i-1)/2;
		}
		this.array[i] = data;
		
	}

	public void printHeap(){
		System.out.print("[");
		for(int i =0; i < this.count; i++){
			System.out.print(" "+this.array[i]+" ");
		}
		System.out.println("]");
	}
	
	public void percolateDown(int i){
		
		//System.out.println("i "+i);
		int l = this.LeftChild(i);
		//System.out.println("Left is "+l);
		int r = this.RightChild(i);
		//System.out.println("Right is "+r);
		int max = 0;
		if(l != -1 && this.array[l] > this.array[i]){
			max = l;
		}
		else {
			max = i;
		}
		if( r!= -1 && this.array[r] > this.array[max]){
			max = r;
		}
		//System.out.println("Max is "+max);
		if(max != i){
			int temp = this.array[i];
			this.array[i] = this.array[max];
			this.array[max] = temp;
			//System.out.println("Max is "+max);
			//System.out.println("**");
			percolateDown(max);
		}

	}
	
	public void buildHeap(Heap h, int[] A, int n){
		
		if(h == null) {
			return ;
		}
		for(int i=0; i < A.length; i++){
			h.array[i] = A[i];
		}
		if (n > h.capacity){
			h.resizeHeap();
		}
		for(int i = (n-1)/2; i >=0; i--){
			h.percolateDown(i);
		}
		h.count = n;
	}
	
	public void heapSort(Heap h, int [] A, int n){
		
		
		int temp; 
		h.buildHeap(h, A, n);
		System.out.println("&&&&&&&&&&&&&&&");
		int old_size = h.count;
		for(int i = n-1; i >=0; i--){
			temp = h.array[0];
			System.out.println("Temp is "+temp);
			
			h.array[0] = h.array[count-1];
			h.array[count-1]= temp;
			h.count--;
			h.percolateDown(0);
			System.out.println("After perco");
			h.printHeap();
			System.out.println("!**!");
		}
		
		h.count = old_size;
	}
	
	public int deleteMax(){
		
		if(this.count == 0){
			return -1;
		}
		int data = this.array[0];
		this.array[0] = this.array[this.count-1];
		this.percolateDown(0);
		return data;
	}
	
	public int findMinInMaxHeap(){
		
		int min = Integer.MAX_VALUE;
		for(int i= (this.count+1)/2; i < this.count; i++){
			//System.out.println("i is "+i + " val is "+this.array[i]);
			if(this.array[i] < min){
				min = this.array[i];
			}
		}
		return min;
	}
	
	public int deleteIthIndex(int i){
		
		if(i > this.count){
			return -1;
		}
		int key = this.array[i];
		this.array[i] = this.array[this.count-1];
		this.count--;
		this.percolateDown(i);
		return key;
	}
	
	public void findElementsLessThanData(int root, int data){
		
		if(root == -1){
			return;
		}
		if(data > this.array[root])
		{
		//	System.out.println("Root "+this.array[root]+" i "+data);
			System.out.print(" " + this.array[root]);
			
		}
		findElementsLessThanData(this.LeftChild(root),  data);
		findElementsLessThanData(this.RightChild(root),  data);		
	}
}
