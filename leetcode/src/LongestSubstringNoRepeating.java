
import java.util.Arrays;
import java.util.HashMap;


public class LongestSubstringNoRepeating {

    public int lengthOfLongestSubstring(String s) {
    	int maxLength = 0;
    	
    	int j=0;
    	boolean []visited = new boolean[256];
    	
    	if(s.length() == 1){
    		return 1;
    	}
    	if(s.length() == 0){
    		return 0;
    	}
    	int i = 0;
    	for(i=0; i < s.length(); i++){
    		char curr = s.charAt(i);
    		if(visited[curr]) {
    			 for(; j < i; j++){
    				 maxLength = Math.max(maxLength, i-j);
    			
    				 if(s.charAt(i) == s.charAt(j)){
    					 j++;
    					 break;
    				 }
    				 visited[s.charAt(j)] = false;
    			 }
    		}
    		else {
    			visited[curr] = true;
    		}
    	}
    	return Math.max(maxLength, i - j);
    }
    
    public int longestDP(String s)
    {
    	int maxLength = 0;
    	
    	HashMap m = new HashMap();
    //	int currLen = 1;
   // 	m.put(s.charAt(0), 0);
    	char [] charArr = s.toCharArray();
    	int start = 0;
    	for(int i=0; i < charArr.length; i++)
    	{
    		if(m.containsKey(charArr[i]))
    		{
    			
    			int prevIndex = (Integer) m.get(charArr[i]);
    			
    			if(prevIndex >= start)
    			{
    				maxLength = Math.max(maxLength, (i - prevIndex));
    				start = i;
    				System.out.println("i is "+charArr[i]+" prev is "+prevIndex+" curr "+i+" max leng "+ maxLength);
    			}
    		}
    		m.put(charArr[i],i);
    	}
    	return maxLength;
    }
    
	public static void main(String[] args) {
		
		String s = "ABDEFGABEF";
		
		System.out.println("String to process is "+s);
		LongestSubstringNoRepeating l = new LongestSubstringNoRepeating();
		//int r = l.lengthOfLongestSubstring(s);
		int r = l.longestDP(s);
		System.out.println("Length of longest substring is " + r);

	}

}
