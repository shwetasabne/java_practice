package se_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class OriginalBruteForce {

	public static HashMap map = new HashMap();
    
    /**
     * 
     * @param arr : sorted array of strings
     * @return non
     * 
     * This method accepts a sorted string array Eg [apple,banana, orange]
     * 
     * Method attempts to permute the string to obtain unique pairs 
     * EG apple, orange ; apple, banana ; orange, banana
     */
	public static void permuteAndAdd(String[] arr){
		
		//Since I want to obtain only unique pairs and the array is sorted
		//   the inner for loop iterates only from i+1 to array length giving the complexity on O(nlogn)
		//   sorting the array and permuting in such a manner and then using the hashmap optimizes the code
		for(int i=0; i<arr.length - 1; i++){
			for(int j = i+1; j < arr.length; j++){
				
				// The unique pair is then saved as a key
				String key = arr[i]+","+arr[j];
				// If key exists then increment the value
				if(map.containsKey(key)){
					map.put(key, (Integer)map.get(key) +1);
				}
				else{
					// Else put the key
					map.put(key, 1);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		// Initialize an array list
		ArrayList artistsList = new ArrayList();
		
		System.out.println("Enter the full path of file to be parsed:");
		Scanner userInput = new Scanner(System.in);
		
		FileInputStream fstream = new FileInputStream(userInput.next());
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		long startTime = System.nanoTime();
		String strLine;
		while ((strLine = br.readLine()) != null)  {
			
			// remove spaces split each line and sort the array
			strLine = strLine.replaceAll("\\s","");
			String [] array = strLine.split(",");
			Arrays.sort(array);
			// Add the sorted array to array list
			artistsList.add(array);
		}
		br.close(); // close buffered reader

		Iterator itr = artistsList.iterator();
		while(itr.hasNext()){
			// Iterate over the array list, permute each string array and generate the mapping
			String []t = (String[]) itr.next();
			permuteAndAdd(t);
		}
		
		
		
		System.out.println("HashMap size is "+ map.size());
		
		File fout = new File("out_brute.txt");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		Iterator i = map.entrySet().iterator();
		while(i.hasNext()){
			Map.Entry entry =  (Entry) i.next();
			if((Integer)entry.getValue() >= 50){
				String str = entry.getKey() + " => " + entry.getValue();
				bw.write(str);
				bw.newLine();
			}
		}
		bw.close();
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
	}
}


