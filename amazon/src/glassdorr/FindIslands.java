package glassdorr;

public class FindIslands {

	private class Vertex {
		
		char label;
		Vertex [] adjacents;
		boolean isVisited;
		public Vertex(char label)
		{
			this.label = label;
		}
	}

	public Vertex [] vertices;
	public void init()
	{
		Vertex a = new Vertex('a');
		Vertex b = new Vertex('b');
		Vertex c = new Vertex('c');
		Vertex d = new Vertex('d');
		
		a.adjacents = new Vertex[]{b};
		b.adjacents = new Vertex[]{c};
		c.adjacents = new Vertex[]{d};
		d.adjacents = new Vertex[]{};
		
		Vertex m = new Vertex('m');
		Vertex n = new Vertex('n');
		m.adjacents = new Vertex[]{n};
		n.adjacents = new Vertex[]{};
		
		vertices = new Vertex[]{a,b,c,d,m,n};
	}

	public void dfs(Vertex v)
	{
		v.isVisited = true;
		for(Vertex adj : v.adjacents)
		{
			if(!adj.isVisited)
			{
				dfs(adj);
			}
		}
	}

	public int countIslands()
	{
		int count = 0;
		
		for(int i=0 ; i < vertices.length ; i++)
		{
			if(!vertices[i].isVisited)
			{
				dfs(vertices[i]);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		
		FindIslands f = new FindIslands();
		f.init();
		System.out.println(f.countIslands());

	}

}
