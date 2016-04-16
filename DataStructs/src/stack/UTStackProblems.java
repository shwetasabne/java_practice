package stack;

import java.util.HashMap;

public class UTStackProblems {


	public boolean isStringGood(String str){
		
		//Instantiate the ListStack
		DynArrayStack ds = new DynArrayStack();
		

		for (int i=0; i < str.length(); i++){
			
			if(str.charAt(i) == '(' || 
			   str.charAt(i) == '{' ||
			   str.charAt(i) == '[') 
			{
				 ds.push(str.charAt(i));
				
			}
			if(str.charAt(i) == ')' || 
			   str.charAt(i) == '}' ||
			   str.charAt(i) == ']') 
			{
				char last_val = ds.pop();
				//Check if this matches the last inserted val
				if(  !( ( last_val == '(' && str.charAt(i) == ')' ) ||
						(last_val == '{' && str.charAt(i) == '}' ) ||
						( last_val == '[' && str.charAt(i) == ']' ) )			
						){
					System.out.println("Bad string");
					return false;
				}
						
			}
		}
		System.out.println("Good string");
		return true;
	}
	
	public boolean isPalindrome( String str ){
		
		DynArrayStack ds = new DynArrayStack();
		DynArrayStack ds1 = new DynArrayStack();
	
		int i = 0;
		for (i =0 ; i < str.length()/2 ; i++){
			ds.push(str.charAt(i));
		}

		if( str.length()%2 !=0 ){
			ds.push(str.charAt(i));
		}
		for( i= str.length()/2; i < str.length(); i++){
			if(str.charAt(i) != ds.pop()){
				System.out.println("Not a palin");
				return false;
			}
		}

		System.out.println("Palin");
		return true;
	}
	public static void main(String[] args) {

		UTStackProblems uts = new UTStackProblems();
		
		// Good string or bad string
		String str = "([{]})";
	//	uts.isStringGood(str);
		
		//Is string a palindrome
		uts.isPalindrome("ABCXBA");

	}

}
