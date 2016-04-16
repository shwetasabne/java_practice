package quickunion;

public class QuickUnionUFClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickUnionUF qu = new QuickUnionUF(10);
		
		qu.union(1,2);
		System.out.println(qu.root(2));
		System.out.println(qu.root(1));

	}

}
