
public class XOR {

	public int oddNum (int [] a){
		
		int ret = 0;
		for(int i=0; i <a.length; i++)
			ret = ret^a[i];
		return ret;
	}
	public static void main(String [] args){
		XOR x = new XOR();
		int [] a = {1,1,2, 2, 0, 0};
		System.out.println(x.oddNum(a));
	}
}
