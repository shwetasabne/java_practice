package glassdoor;

public class NumToString {

	public static String [] digits = {"one", "two", "three", "four","five","six","seven","eight","nine"};
	public static String [] tens = {"ten", "twenty","thirty", "forty","fifty","sixty","seventy","eighty","ninety"};
	public static String [] teens = {"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	public static String [] bigs = {"", "thousand", "million", "billion"};
			
	public String numToString (int num)
	{
		int count = 0;
		String s = "";
		while(num > 0)
		{
			if(num % 1000 != 0)
			{
				s = numToHunderds(num%1000) + " "+ bigs[count] + " "+s;
			}
			num = num /1000;
			count++;
		}
		return s;
	}
	public String numToHunderds(int num)
	{
		System.out.println("debung "+num);
		String str = "";
		if(num >= 100)
		{
			
			str = str + digits[num/100-1] + " hundred ";
			num = num % 100;
		}
		if(num >=11 && num <=19)
		{
			str = str + teens[num-11]+ " ";
			return str;
		}
		if(num == 10 || num >=20)
		{
			str = str + tens[num/10-1]+" ";
			num = num % 10;
		}
		if (num > 0 && num < 10)
		{
			str = str + digits[num-1]+ " ";
		}
		
		return str;
	}
	
	public static void main(String[] args) {
		
		NumToString n = new NumToString();
		System.out.println(n.numToString(1801837319));
	}

}
