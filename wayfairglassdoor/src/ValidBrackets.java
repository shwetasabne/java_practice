
public class ValidBrackets {

	public static String getMatching(String str)
	{
		switch(str){
			
			case "}" :
				return "{";
			case ")" :
				return "(";
			case "]" :
				return "[";
			default :
				return "";
		}
	}

	public static void main(String[] args) {
		

	}

}
