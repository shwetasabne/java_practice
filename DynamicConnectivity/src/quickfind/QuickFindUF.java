package quickfind;
/**
 * 
 */

/**
 * @author shwetasabne
 *
 */
public class QuickFindUF {
	
	private int[] id;
	
	public QuickFindUF(int N)
	{
		id = new int[N];
		for(int i=0; i <= N-1; i++)
		{
			id[i] = i; // set id of each object to itself
					  // N times access the array
		}
	}

	// This method accepts the ids
	// If their values are equal --> connected
	public boolean connected (int p, int q)
	{
		return (id[p] == id[q]); // Access array 2 times for p and q
	}
	
	public void union (int p, int q)
	{
		int pid = id[p];	// Change all elements with id[p] to id[q]
		int qid = id[q];	//(2N + 2) array access
		for(int i= 0; i < id.length; i++)
		{
			// If we don't pick out id[p] first then it results in problem
			// That is because id[p], changes when there is a match and now we compare with a new value of id[p]
			// which is wrong
			if(id[i] == pid)
			{
				System.out.println(id[i] + "matches " + id[p]);
				System.out.println("Updating "+ id[i] + "to " + qid);
				id[i] = qid;
 			}
		}
	}
	
	public void showConnections()
	{
		for(int i=0; i < id.length; i++)
		{
			System.out.println(i + " => " + id[i]);
		}
	}
}
