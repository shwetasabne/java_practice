package glassdoor;

public class NumExactlyOnce {


	public void onlyOnceWithOtherTwo(int [] a)
	{
		int out = a[0];
		for(int i= 1; i < a.length; i++)
		{
			out = out ^ a[i-1] ^ a[i];
		}
		System.out.print(out);
	}
	public static void main(String[] args) {
		
		NumExactlyOnce o = new NumExactlyOnce();
		int [] a = {1,0,2,1,2,0,3};
		o.onlyOnceWithOtherTwo(a);

	}

}
