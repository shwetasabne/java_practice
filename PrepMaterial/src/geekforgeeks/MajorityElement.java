package geekforgeeks;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class MajorityElement {

	public void getMajorityMoore(int [] array){
		
		if(array.length <= 0){
			System.out.println("getMajorityMoore :: "+"None");
			return;
		}
		int count = 1;
		int majorElement = 0;
		
		for(int i=1; i < array.length; i++){
			if(array[i] == array[majorElement]){
				count++;
			}
			else{
				count--;
			}
			if(count == 0){
				majorElement = i;
				count = 1;
			}
		}
		
		int major = array[majorElement];
		count = 0;
		int valid = 0;
		
		for(int i=0; i < array.length; i++){
			if(array[i] == array[major]){
				count++;
			}
			if (count > array.length/2)
			{
				valid = 1;
				 break;
			}
			else
				valid = 0;
		}
		
		if(valid == 1)
			System.out.println("getMajorityMoore :: "+major);
		else
			System.out.println("getMajorityMoore :: "+"None");
		
	}

	public void getMajorityHashmap(int [] array){

	    Map<Integer, Integer> m = new TreeMap<Integer, Integer>(Collections.reverseOrder());
	    
	    for(int i : array){
	        if (m.containsKey(i)){
	            m.put(i, m.get(i)+1);
	        }
	        else{
	            m.put(i, 1);
	        }
	    }
	    
	    for(Map.Entry<Integer, Integer> entry : m.entrySet()){
	        int val = entry.getValue();
	        if(val > array.length/2){
	            System.out.println(" getMajorityHashmap :: " + entry.getKey());
	        }
	        else{
	            System.out.println(" getMajorityHashmap :: None");
	        }
	        return;
	    }
		
	}
	public static void main(String[] args) {
		
		MajorityElement me = new MajorityElement();
		int [] arr = {3,3, 4, 2, 4, 4, 2, 4, 4};
		me.getMajorityHashmap(arr);
		int []arr1 = {3,3,4, 2, 4, 4, 2, 4};
		me.getMajorityHashmap(arr1);
		System.out.println("***");
		me.getMajorityMoore(arr);
		me.getMajorityMoore(arr1);
	}

}
