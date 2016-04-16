
public class ZigZag {


	public String zigzag (String s, int nRows){
		
		if(nRows == 1)
			return s;
		StringBuilder sb = new StringBuilder();
		int step1 = (2 * nRows) - 2;
		
		for(int i=0; i < s.length() ; i++){
			if(i ==0 || i == nRows -1){
				for(int j=i; j < s.length(); j = j+step1){
					
				}
			}
		}
		return "";
	}
	public static void main(String[] args) {
	

	}

}
