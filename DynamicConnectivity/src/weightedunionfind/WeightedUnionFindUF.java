package weightedunionfind;

public class WeightedUnionFindUF {
	
	private int[] id;
	private int[] sz;
	
	public WeightedUnionFindUF(int N)
	{
		id = new int[N];
		sz = new int[N];
		for(int i=0; i <= N-1; i++)
		{
			id[i] = i; // set id of each object to itself
					  // N times access the array
			sz[i] = 1; // Set size of each tree to 1 for now
		}
	}
	
	public int root(int i)
	{
		while(i != id[i])
		{
			i = id[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q)
	{
		return (root(p) == root(q));
	}

	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		if(sz[i] > sz[j])
		{
			id[j] = i;
			sz[i] += sz[j];
		}
		else
		{
			id[i] = j;
			sz[j]+=sz[i];
		}
	}
	
	public void showConnections()
	{
		for(int i=0; i<id.length; i++)
		{
			System.out.println(i + "=>" + id[i]);
		}
	}
}
