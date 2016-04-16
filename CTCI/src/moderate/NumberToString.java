package moderate;

public class NumberToString {


	public  static String [] digits = {"one", "two", "three", "four","five", "six", "seven", "eight", "nine"};
	public static String [] teens = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	public static String [] tens = {"ten", "twenty","thirty", "forty", "fifty","sixty", "seventy","eighty","ninety"};
	public static String [] bigs = {" ", "thousand", "million"};
	
	public String numberToString(int num)
	{
		String output = "";
		int count = 0;
		while(num > 0)
		{
			System.out.println("debug count is "+count);
			if(num %  1000 != 0)
			{
				output = numToHundred(num%1000) +" "+bigs[count]+" " + output;
			}
			num = num /1000;
			count++;
		}
		return output;
	}
	
	public String numToHundred(int num)
	{
		String str = "";
		
		if(num >= 100)
		{
			str += digits[num/100 -1] + " hundred ";
			num %= 100;
		}
		if(num >= 11 && num <= 19)
		{
			//System.out.println("debug num is "+num);
			str += teens[num-11]+" ";
			return str;
		}
		else if(num == 10 || num >= 20)
		{
			str += tens[num/10 -1]+" ";
			num %=10;
		}
		
		if(num >=1 && num <= 9){
			str += digits[num-1]+ " "; 
		}
		return str;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberToString r = new NumberToString ();
		String s = r.numberToString(1801837319);
		System.out.println(s);
	}

}
