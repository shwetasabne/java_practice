package quickfind;

public class QuickFindUFClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		QuickFindUF qf = new QuickFindUF(10);
		//qf.showConnections();
		
		qf.union(2, 3);
		qf.union(3, 1);
		qf.union(9, 5);
		qf.union(5, 2);
		qf.union(2, 1);
		
		qf.showConnections();
		
		System.out.println(qf.connected(1, 8));
		System.out.println(qf.connected(0, 1));
		System.out.println(qf.connected(9, 2));
		
	}

}
