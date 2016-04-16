package others;

import java.util.*;

public class DFSPrintPaths {

	private class Vertex {
		char label;
		Vertex [] adjacents ;
		boolean isVisited;
		
		public Vertex(char label)
		{
			this.label = label;
			this.isVisited = false;
		}
	}
	
	public Vertex graph[] = new Vertex[8]; 
	
	public void createGraph()
	{
		Vertex a = new Vertex('a');
		Vertex b = new Vertex('b');
		Vertex c = new Vertex('c');
		Vertex d = new Vertex('d');
		Vertex e = new Vertex('e');
		Vertex f = new Vertex('f');
		Vertex m = new Vertex('m');
		Vertex n = new Vertex('n');
		
		graph[0] = a;
		graph[1] = b;
		graph[2] = c;
		graph[3] = d;
		graph[4] = e;
		graph[5] = f;
		graph[6] = m;
		graph[7] = n;
		
		m.adjacents = new Vertex[]{n};
		n.adjacents = new Vertex[]{m};
		
		a.adjacents = new Vertex[]{b};
		b.adjacents = new Vertex[]{c,a};
		c.adjacents = new Vertex[]{b, d, e};
		d.adjacents = new Vertex[]{c, f};
		e.adjacents = new Vertex[]{c, f};
		f.adjacents = new Vertex[]{d, e};
	}
	
	
	public void dfs(Vertex s)
	{
		s.isVisited = true;
		for( Vertex ad : s.adjacents)
		{
			if(!ad.isVisited)
			{
	//			System.out.print(ad.label + " ");
				dfs(ad);
			}
		}
	}
	
	public  int countConnectedComponents()
	{
		int count = 0;
		for(Vertex v : this.graph)
		{
			if(!v.isVisited)
			{
				this.dfs(v);
				count++;
			}
		}
		return count;
	}

	public void printAllPathsForAllNodes()
	{
		for(Vertex v : this.graph)
		{
			System.out.println("Printing paths for "+ v.label);
			this.dfs(v);
			for(Vertex v1 : this.graph)
			{
				v1.isVisited = false;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		DFSPrintPaths d = new DFSPrintPaths();
		d.createGraph();
	//	d.printAllPathsForAllNodes();
		System.out.println(d.countConnectedComponents());

	}

}
