package strings;

public class Permutations {

	public static void permute(String prefix, String s){
//		System.out.println("Curr prefix is "+prefix);
		if(s.length() == 0)
			System.out.println(prefix);
		for(int i=0; i < s.length(); i++)
			permute(prefix+s.charAt(i)+s.substring(0,i), s.substring(i+1, s.length()));
	}
	
	public static void combine(String prefix, String s){
		
			System.out.println(prefix);
		for(int i=0; i < s.length(); i++)
			combine(prefix+s.charAt(i), s.substring(i+1));
	}
	public static void main(String[] args){
		
		String s = "cat";
	//	permute("", s);
		combine("",s);
	}
}
