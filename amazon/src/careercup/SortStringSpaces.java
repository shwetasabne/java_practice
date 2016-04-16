package careercup;

import java.util.Arrays;

public class SortStringSpaces {

	public static void sortString(String str)
	{
		 char [] ch = str.toCharArray();
		 
		 for(int i=0; i<ch.length-1; i++)
		 {
			 System.out.println("currently at "+i+" with "+ch[i]);
			 if(ch[i] == ' ')
			 {
				 if((int) ch[i+1] >= 97 && (int) ch[i+1] <= 122 )
				 {
					// char temp = ch[i+1];
					 ch[i] = ch[i+1];
					 ch[i+1] = ' ';
				 }
			 }
		 }
		 
		 System.out.println(Arrays.toString(ch));
	}
	
	public static void main(String[] args) {
	
		String s = "a b c";
		sortString(s);
	}

}
