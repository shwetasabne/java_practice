package backtracking;

public class PhonePadCombination {

	public static String [] phonePad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	
	public void generateCombos(int [] numbers, String prefix, int currDigit)
	{
		if(currDigit == numbers.length)
		{
			System.out.println(prefix);
			return;
		}
		for(int i=0; i < phonePad[numbers[currDigit]].length(); i++)
		{
			generateCombos(numbers, prefix + phonePad[numbers[currDigit]].charAt(i), currDigit+1);
			if(numbers[currDigit] == 0 || numbers[currDigit] == 1)
				return;
		}
	}

	public static void main(String[] args) {
		
		int [] num = {2,3,4};
		PhonePadCombination p = new PhonePadCombination();
		p.generateCombos(num, "", 0);
	}

}
