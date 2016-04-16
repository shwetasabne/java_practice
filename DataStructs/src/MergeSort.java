import java.util.Arrays;


public class MergeSort {

	private int[] numbers;
	
	private int[] helper;

	private int number;
	
	private void sort(int [] values){
		
		this.numbers = values;
		this.number = values.length;
		this.helper = new int[number];
		mergesort(0, number-1);
	}

	private void mergesort(int low, int high){
		System.out.println("****");
		if(low < high){
			System.out.println("Low "+ low + " high "+high);
			int mid = low + (high-low)/2;
			System.out.println("mid is "+mid);
			mergesort(low, mid);
			System.out.println("	Split point ****");
			mergesort(mid+1, high);
			System.out.println("	Ret point ****");
			merge(low, mid, high);
		}
		
	}
	
	private void merge(int low, int mid, int high){
		System.out.println("Merging "+low+" "+mid+" "+high);
		
		for(int i=low; i <=high; i++){
			helper[i] = numbers[i];
		}
		System.out.println("After copying "+Arrays.toString(helper));
		
		int i = low;
		int j = mid+1;
		int k = low;
		
		System.out.println("i "+i +" j "+j+" k "+k);
		
		while(i <= mid && j <= high){
			if(helper[i] <= helper[j]){
				numbers[k] = helper[i];
				
				i++;
			}
			else{
				numbers[k] = helper[j];
				j++;
			}
			k++;
			System.out.println("^ i "+i +" j "+j+" k "+k);
		}
		System.out.println("Now array is "+Arrays.toString(numbers));
	    while (i <= mid) {
	        numbers[k] = helper[i];
	        k++;
	        i++;
	    }
	    System.out.println("Final array is "+Arrays.toString(numbers));
	}
	
	public static void main(String[] args) {
		
		int []a = {3,2,5,4, 9, 8};
		MergeSort m = new MergeSort();
		m.sort(a);

	}

}
