
public class RegExMatching {


	public static boolean isMatch(String s, String p){
		System.out.println(" *** Proc "+ s+ " "+p);
		if(p.length() == 0){
			return s.length() == 0;
				
		}
		
		// Next char is not star
		if(p.length() == 1 || p.charAt(1) != '*' )
		{
			System.out.println("in here "+p);
			if((s.length() < 1) || (p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')){
				//System.out.println("Ret 2 "+p+" "+s);
				return false;
			}
			//System.out.println("Recalling with ")
			return isMatch(s.substring(1), p.substring(1));
		}
		else {
			int i = -1;
			int len = s.length();
			while(i < len && (i < 0 || p.charAt(0) == s.charAt(i) || p.charAt(0) == '.'))
			{
				System.out.println(" p is " +p);
				if(isMatch(s.substring(i+1), p.substring(2))){
					return true;
				}
				i++;
			}
			//System.out.println("Ret 3");	
		}

		return false;
	}
	public static void main(String[] args) {
		
		System.out.println(isMatch("mab", "mc*d*ab"));
	}

}
