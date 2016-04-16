import java.util.*;


public class ApplicationT9Dictionary {

	public Trie t = new Trie();
	
	public void createTrieBasedOnDictionary()
	{
		t.insertWord("hello");
		t.insertWord("hell");
		t.insertWord("idea");
		t.insertWord("next");
		t.insertWord("supper");
	}
	
	public static String [] t9 = {"", "", "abc","def","ghi","jkl","mno","pqrs", "tuv","wxyz"};
	
	public void bfs_search(String strNum) {  
        Queue<String> q = new LinkedList<String>();  
          
        q.add("");  
          
        for(int i = 0; i < strNum.length(); i++) {  
        	//System.out.println("\n\n\n");
            String keyStr = t9[strNum.charAt(i) - '0'];  
            System.out.println("keyStr "+keyStr);
            int len = q.size();  
           
            while(len-- > 0) {
            	System.out.println("len "+len+" q "+q.toString());
                String preStr = q.remove();  
                for(int j = 0; j < keyStr.length(); j++) { 
                	
                    String tmpStr = preStr + keyStr.charAt(j);  
                  //  System.out.println("tmpStr "+tmpStr);
                    if(t.search(tmpStr) && tmpStr.length() == strNum.length()) {  
                        System.out.println("* "+tmpStr);  
                    } else {  
                        q.add(tmpStr);  
                    }  
                }  
            }  
        }  
    } 
	
	public static void main(String [] args)
	{
		ApplicationT9Dictionary a = new ApplicationT9Dictionary();
		a.createTrieBasedOnDictionary();
		a.bfs_search("43");
	}

}
