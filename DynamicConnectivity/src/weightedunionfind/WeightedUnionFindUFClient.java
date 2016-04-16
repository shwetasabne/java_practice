package weightedunionfind;

import quickunion.QuickUnionUF;

public class WeightedUnionFindUFClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeightedUnionFindUF wu = new WeightedUnionFindUF(10);
		
		wu.union(0, 1);
		wu.union(0, 2);
		wu.union(0, 3);
		wu.union(0, 4);
		wu.union(0, 5);
		wu.union(8, 9);
		wu.union(8, 7);
		wu.union(7, 6);
		
		wu.showConnections();
		
		wu.union(7, 4);
		wu.showConnections();

	}

}
