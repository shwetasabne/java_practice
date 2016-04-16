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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class OptimizedProcessArtistList {
public static HashMap map = new HashMap();
    

	public static void permuteAndAdd(ArrayList arr){
		
		for(int i=0; i<arr.size() - 1; i++){
			for(int j = i+1; j < arr.size(); j++){
				
				// The unique pair is then saved as a key
				String key = arr.get(i)+","+arr.get(j);
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
		
		
		
		System.out.println("Enter the full path of file to be parsed:");
		Scanner userInput = new Scanner(System.in);
		
		FileInputStream fstream = new FileInputStream(userInput.next());
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		long startTime = System.nanoTime();
		String strLine;
		HashMap<String, Integer> artistName = new HashMap<String, Integer>();
		ArrayList al = new ArrayList();
		while ((strLine = br.readLine()) != null)  {	
			// remove spaces split each line and sort the array
			strLine = strLine.replaceAll("\\s","");
			String [] array = strLine.split(",");
			al.add(array);
			// Here I am creating a hash with the artist Name and the number of times the artist appears in the whole file
			// Assumption here is that each line will always contain unique artists names
			for(int i =0 ; i < array.length; i++){
				if(artistName.containsKey(array[i])){
					artistName.put(array[i], (Integer)artistName.get(array[i]) +1);
				}
				else {
					artistName.put(array[i], 1);
				}
			}
		}
		br.close();
		
		Iterator itr = al.iterator();
		while(itr.hasNext()){

			String[] artistsLine = (String[]) itr.next();
			ArrayList temp = new ArrayList();
			for(int i=0; i<artistsLine.length; i++){
				
				// With a view to improve the performance of the program 
				//    I only permuate those artists who have appeared at least 50 times
				//    Reducing the size of the array here has improved the performance. 
				if(artistName.get(artistsLine[i]) >= 50){
					//do nothing
					temp.add(artistsLine[i]);
				}
			}
			Collections.sort(temp);
			permuteAndAdd(temp);
			
		}
		
		System.out.println("HashMap size is "+ map.size());
		
		File fout = new File("out_optimized.txt");
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
