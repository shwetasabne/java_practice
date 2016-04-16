
public class LongestCommonPrefix {


	public static String longestCommPrefix(String[] strs){
				
		int j = 0;
		
		if(strs.length == 0)
			return "";
		if(strs.length == 1)
			return strs[0];
		
		StringBuffer sb = new StringBuffer();
		boolean proceed = true;
		while(true){
			char temp = ' ';
			for(int i=0; i < strs.length-1; i++)
			{
			//	System.out.println(i+ " " +strs[i]);
				if(j >= strs[i].length() || j >= strs[i+1].length()){
					proceed = false;
				}
				else {
					if(proceed && (strs[i].charAt(j) != strs[i+1].charAt(j))){
						proceed = false;
					}
					temp = strs[i].charAt(j);
				}
			}
			if(proceed){
				sb.append(temp);
				j++;
			}
			else {
				return sb.toString();
			}
		//	return sb.toString();
		}
		//return sb.toString();
	}
	public static void main(String[] args) {
		
		String [] s = {"aba", "abbba", "abab"};
		String t = longestCommPrefix(s);
		System.out.println(t);
	}

}
