package heap;

import java.util.Arrays;

public class RevArr {

	public static void main(String[] args){
		
		int [] a = {1,2,3,4,5,6,7,8};
		
		int n = a.length - 3;
		
		int i=0; int j = n-1;
		while(i < j){
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++; j--;
		}
		
		i=n; j = a.length-1;
		while(i < j){
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++; j--;
		}
		
		i=0; j = a.length-1;
		while(i < j){
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++; j--;
		}
		System.out.println(Arrays.toString(a));
	}
}
