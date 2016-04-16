package glassdoor;

public class PhonePadPermutations {

	public static String [] phonePad = {"", "", "abc", "def", "ghi", "jkl","mno", "pqrs", "tuv", "wxyz"};
	
	public static void printPerms(int [] number, int currDigitIdx, String prefix)
	{
		if(currDigitIdx == number.length)
		{
			System.out.println(prefix);
			return;
		}
		
		for(int i=0; i < phonePad[number[currDigitIdx]].length(); i++)
		{
			//prefix = prefix + phonePad[number[currDigitIdx]].charAt(i);
			printPerms(number, currDigitIdx+1, prefix + phonePad[number[currDigitIdx]].charAt(i));
			if(number[currDigitIdx] == 0 || number[currDigitIdx] == 1)
				return;
		}
	}

	public static void main(String[] args) {
		
		int [] number = {5,4,3,2};
		printPerms(number, 0, "");

	}

}
