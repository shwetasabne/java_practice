package glassdorr;

import java.util.Stack;

public class TopologicalSort {

	private class Vertex {
		char label ;
		Vertex [] adjacents;
		boolean isVisited;
		public Vertex(char label)
		{
			this.label = label;
			this.isVisited = false;
		}
		
		public String toString()
		{
			return String.valueOf(this.label);
		}
	}
	
	
	public  Vertex[] vertices  ;
	
	public void createGraphs()
	{
		Vertex a = new Vertex('0');
		Vertex b = new Vertex('1');
		Vertex c = new Vertex('2');
		Vertex d = new Vertex('3');
		Vertex e = new Vertex('4');
		Vertex f = new Vertex('5');
		
		a.adjacents = new Vertex[]{};
		b.adjacents = new Vertex[]{};
		c.adjacents = new Vertex[]{d};
		d.adjacents = new Vertex[]{b};
		e.adjacents = new Vertex[]{a, b};
		f.adjacents = new Vertex[]{a, c};
		
		vertices = new Vertex[]{a,b,c,d,e,f};
	}
	
	public void topoSort()
	{
		Stack<Vertex> s = new Stack();
		
		for(Vertex v : vertices)
		{
			if(!v.isVisited)
				dfsTopo(v, s);
		}
		
		System.out.println(s.toString());
	}
	
	public void dfsTopo(Vertex v, Stack s)
	{
		v.isVisited = true;
		System.out.println("DFS on "+String.valueOf(v.label));
		for(Vertex adj : v.adjacents)
		{
			if(!adj.isVisited)
			{
				dfsTopo(adj, s);
			}
		}
		s.push(v);
	}
	
	public static void main(String[] args) {
		
		TopologicalSort s = new TopologicalSort();
		s.createGraphs();
		s.topoSort();
	}

}
