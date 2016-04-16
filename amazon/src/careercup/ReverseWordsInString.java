package careercup;

import java.util.Arrays;

public class ReverseWordsInString {

	public static void swap(char [] ch, int low, int high)
	{
		while(low < high)
		{
			char temp = ch[low];
			ch[low] = ch[high];
			ch[high] = temp;
			low++;
			high--;
		}
	}

	public static void main(String[] args) {
		
		String str =  "This is a   test";
		char [] ch = str.toCharArray();
		int i = 0; 
		int j = 0;
		
		int n = str.length();
		while(i < n && j <= i)
		{
			//System.out.println(i + " "+j +" "+ch[i] + " "+ch[j]);
			if(ch[i] != ' ')
			{
				i++;
			}
			else if(i != j && ch[i] == ' ')
			{
			//	System.out.println("Encountered space at "+i);
				swap(ch, j, i-1);
			//	System.out.println("After swap "+Arrays.toString(ch));
				i++;
				j=i;
			}
			else
			{
				i++;
				j++;
			}
		}
		if(i != j)
		{
			swap(ch, j, i-1);
		}
		System.out.println(String.valueOf(ch));
	}

}
