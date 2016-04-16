package stringsprep;

import java.util.Arrays;

public class PutAnagramsTogether {


	public void printAnagramsTogether(String [] words)
	{
		int [] index = new int[words.length];
		String [] newWords = new String[words.length];
		
		for(int i = 0; i < words.length; i++)
		{
			index[i] = i;
			newWords[i] = words[i];
		}
		System.out.println(Arrays.toString(newWords));
		for(int i=0; i < newWords.length; i++)
		{
			char [] temp = newWords[i].toCharArray();
			Arrays.sort(temp);
			newWords[i] = String.valueOf(temp);
		}
		System.out.println(Arrays.toString(newWords));
		System.out.println(Arrays.toString(index));
		for(int i=0; i < (newWords.length-1); i++)
		{
			if(newWords[i].compareTo(newWords[i+1]) > 0)
			{
				String temp = newWords[i+1];
				int tempIndex = index[i+1];
				
				newWords[i+1] = newWords[i];
				index[i+1] = index[i];
				
				newWords[i] = temp;
				index[i] = tempIndex;
			}
		}
		System.out.println();
		System.out.println(Arrays.toString(newWords));
		System.out.println(Arrays.toString(index));
		
		for(int i=0; i< words.length; i++)
		{
			System.out.println(words[index[i]]+"  ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PutAnagramsTogether p = new PutAnagramsTogether();
		String [] s = {"cat", "dog","act","god"};
		String a = "act";
		String b = "dog";
		System.out.println(a.compareTo(b));
		p.printAnagramsTogether(s);
	}

}
