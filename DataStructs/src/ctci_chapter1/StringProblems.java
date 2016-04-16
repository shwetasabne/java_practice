package ctci_chapter1;

import java.util.Stack;

public class StringProblems {

	public static boolean doesStringContainUniqueChar(String str) throws Exception{
		
		if(str.length() <= 0){
			throw new Exception ("String is empty");
		}

		for(int i=0; i<str.length(); i++){
			for(int j=0; j< str.length(); j++){
				if(str.charAt(i) == str.charAt(j) && i!=j){
					return false;
				}
			}
		}

		return true;
	}
	
	public static String reverseString(String str) throws Exception{
		
		if(str.length() <= 0){
			throw new Exception("No string give");
		}
		Stack s = new Stack();
		for(int i=0; i < str.length(); i++){
			s.push(str.charAt(i));
		}
		
		StringBuffer sb = new StringBuffer();
		while(!s.isEmpty()){
			sb.append(s.pop());
		}
		return sb.toString();
		
	}
	
	public static void test(){
		int [] a = {1,2};
		System.out.println(a.length);
	}
	
	private static String sort(String str1){
		char [] arr = str1.toCharArray();
		java.util.Arrays.sort(arr);
		return new String(arr);
	}
	
	public static boolean areStringsPermutations(String str1, String str2){
		
		if(str1.length() != str2.length()){
			return false;
		}
		else{
			return (sort(str1).equals(sort(str2)));
		}

	}
	
	public static String spaceReplace(String str, String replacement){
		
		// Check the length first
		if(str.length() <= 0){
			return "";
		}
		
		// Find how many spaces are there so we know how much to increase the string by
		int numSpaces = 0;
		for(int i=0 ; i < str.length(); i++){
			if(str.charAt(i) == ' '){
				numSpaces++;
			}
		}
		
		// Now first check if there are infact any spaces in the string
		if(numSpaces <= 0){
			return str;
		}
		
		// Now increase the length of string
		// Str : Mr John Smith
		// New : Mr%20John%20Smith
		// str.length = 13, replacement string lenght = 3, numSpaces = 2
		// So newLenght = 13 + 2*(3-1) = 13 + 2 * 2 = 13 + 4 = 17
		int newLength = str.length() + numSpaces * (replacement.length() - 1);
		char [] newString = new char [newLength];
		//Now do the iterations
		for(int i= str.length()-1 ; i >= 0; i--){
			if(str.charAt(i) == ' '){
				newString[newLength - 1]= '0';
				newString[newLength - 2]= '2';
				newString[newLength - 3]= '%';
				newLength = newLength - 3;
			} 
			else{
				newString[newLength - 1] = str.charAt(i);
				newLength = newLength - 1;
			}
		}
		
		return new String(newString);
	}
	
	public static String compressedString(String str){
		
		StringBuffer sb = new StringBuffer();
		if(str.length()<=0)
		{
			return "";
		}
		else{
			
			char curr = str.charAt(0);
			char prev = str.charAt(0);
			int init = 0;
			
			for(int i=0; i<str.length(); i++){
				
				curr = str.charAt(i);
				if(curr == prev){
					init++;
				}
				else{
					sb.append(prev).append(init);
					init = 1;
				}
				prev = curr;
			}
		}
		return sb.toString();
	}
	
	public static boolean isRotation(String str1, String str2){
		
		if(str1.length() != str2.length()){
			return false;
		}
		else{
			String str = str1 + str1;
			if(str.indexOf(str2) != -1) return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Testing doesStringContainUniqueChar");
		String input1 = "abcdef";
		System.out.println(doesStringContainUniqueChar(input1));		
		String input2 = "abcdefghed";
		System.out.println(doesStringContainUniqueChar(input2));		
		//System.out.println(doesStringContainUniqueChar(""));
		
		System.out.println();
		System.out.println("Testing reverseString");
		String orig = "Shweta";
		String rev = reverseString(orig);
		System.out.println("Orig " + orig + "Rev " + rev);	
		 orig = "Shweta   ";
		 rev = reverseString(orig);
		System.out.println("Orig " + orig + "Rev " + rev);	
		 orig = " ";
		 rev = reverseString(orig);
		System.out.println("Orig " + orig + "Rev " + rev);		
		 orig = "-1";
		 rev = reverseString(orig);
		System.out.println("Orig " + orig + "Rev " + rev);	
		 orig = "";
		// rev = reverseString(orig);
		//System.out.println("Orig " + orig + "Rev " + rev);
		
		System.out.println();
		System.out.println("Testing areStringsPermutations");
		String str1 = "dog";
		String str2 = "god";
		System.out.println("Str 1 "+str1 + " Str2 "+ str2 + " Are they perms ? " + areStringsPermutations(str1, str2));
		str2 = "gof";
		System.out.println("Str 1 "+str1 + " Str2 "+ str2 + " Are they perms ? " + areStringsPermutations(str1, str2));
		
		System.out.println();
		System.out.println("Testing spaceReplace");
		str1 = "Mr John Smith";
		str2 = "%20";
		rev = spaceReplace(str1, str2);
		System.out.println("Str 1 "+str1 + " Str2 "+ str2 + " Modified " + rev);
		

		
		System.out.println();
		System.out.println("Testing compressedString");
		str1 = "aaabbbbcddaaa";
		System.out.println("Str 1 "+str1 + " Modified " + compressedString(str1));
		
		str1 = "waterbottle";
		str2 = "erbottlewat";
		System.out.println("Str 1 " + str1 + " Str 2 " + str2 + " isrotation " + isRotation(str1, str2));
		str2 = "erbuttlewat";
		System.out.println("Str 1 " + str1 + " Str 2 " + str2 + " isrotation " + isRotation(str1, str2));
	}

}
