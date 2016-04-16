package glassdoor;

public class NumberToString {


	public static String [] ones = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	public static String [] tens = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy","eighty", "ninety"};
	public static String [] teens = {"eleven", "twelve", "thirteen","fourteen", "fifteen", "sixteen", "seventeen","eighteen","nineteen"};
	public static String [] bigs = {"", "thousand", "million", "billion"};
	
	
	public String numToString (int n)
	{
		String temp = "";
		int count = 0;
		while( n > 0)
		{
			if(n%1000 != 0)
			{
				temp = numToHundred(n%1000) + " "+bigs[count]+" "+temp;
			}
			n = n /1000;
			count++;
		}
		return temp;
	}
	
	public String numToHundred(int n)
	{
		String temp = "";
		if(n >= 100)
		{
			temp = temp+ ones[n/100-1]+" hundred ";
			n = n%100;
		}
		
		if(n >= 11 && n <= 19)
		{
			temp =  temp + teens[n-11] + " ";
			return temp;
		}
		
		if(n==10 || n >=20)
		{
			temp = temp + tens[n/10 -1] + " ";
			n = n%10;
		}
		if(n > 0 && n < 10)
		{
			temp = temp + ones[n-1]+ " ";
		}
		return temp;
	}
	
	public static void main(String[] args) {
		
		NumberToString n = new NumberToString();
		String s = n.numToString(1);
		System.out.println(s);

	}

}
