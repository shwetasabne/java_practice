package quickunion;

public class QuickUnionUF {
	
	private int[] id;
	
	public QuickUnionUF(int N)
	{
		id = new int[N];
		for(int i=0; i <= N-1; i++)
		{
			id[i] = i; // set id of each object to itself
					  // N times access the array
		}
	}

	// Return the root of int i
	public int root(int i)
	{
		if(i != id[i])
		{
			i = id[i];
		}
		return i;
	}
	
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
	
	public boolean connected (int p, int q)
	{
		return (root(p) == root(q));
	}
}
