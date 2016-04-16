import java.util.HashMap;


public class LongestPalindron {

	public String expandAroundCenter(String s, int c1, int c2){
		System.out.println("Params "+ s + " " + c1+ " "+c2);
		int l = c1;
		int r = c2, n=s.length();
		while(l >=0 && r < n && s.charAt(l)== s.charAt(r)){
			l--;
			r++;
		}
		System.out.println("Final " +(l+1) + " " +(r-1+1));
		System.out.println("Returning "+s.substring(l+1, r-1+1));
		return s.substring(l+1, r-1+1);
	}

	public String longestPalin(String s){
			int n = s.length();
			if(n == 0) return "";
			if(n==1 ) return s;
			if(n==2){ 
				if (s.charAt(0) == s.charAt(1) )
						return s;
				else
					return "";
			}
			String longestPalin = "";
			for(int i=0; i < n ; i++){
				System.out.println("************ "+longestPalin);
				System.out.println("EVEN Processing "+ i + " "+s.charAt(i));
				String p1 = this.expandAroundCenter(s, i, i);
				if(p1.length() > longestPalin.length()){
					longestPalin = p1;
				}
				System.out.println("ODD Processing "+ i + " "+s.charAt(i));
				String p2 = this.expandAroundCenter(s, i, i+1);
				if(p2.length() > longestPalin.length()){
					longestPalin = p2;
				}
			}
			return longestPalin;
	}
	
	
	public static void main(String[] args) {
		LongestPalindron l = new LongestPalindron();
		String s = "abba";
		//String o = s.substring(1,3);
		String o = l.longestPalin(s);
		System.out.println(" "+o);

	}

}
