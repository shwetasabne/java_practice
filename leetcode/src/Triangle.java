import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) 
    {
    	int sum = 0;
    	
    	List lastList = triangle.get(triangle.size()-1);
    	int [] total = new int[lastList.size()];
    	int j = 0;
    	Iterator itr = lastList.iterator();
    	while(itr.hasNext())
    	{
    		total[j] = (Integer) itr.next();
    		j++;
    	}
    	System.out.println(Arrays.toString(total));
    	
    	int secondLastList = triangle.size()-2;
    	for(int i = secondLastList ; i >= 0; i--)
    	{
    		List l = triangle.get(i);
    		//System.out.println("Current list is "+l.toString());
    		Iterator it = l.iterator();
    		int k  = 0;
    		while(it.hasNext())
    		{
    			//System.out.println("Element is "+itr.next());
    			total[k] = (Integer)it.next() + Math.min(total[k], total[k+1]);
    			k++;
    		}
    	}
    	System.out.println("total is "+total[0]);
    	return total[0];
    }
    
    public static void main(String [] args)
    {
    	Triangle t = new Triangle();
    	List<List<Integer>> overall = new ArrayList();
    	
    	//Small lists
    	List<Integer> l1 = new ArrayList<Integer>();
    	l1.add(-1);
    	overall.add(l1);
    	
    	List<Integer> l2 = new ArrayList<Integer>();
    	l2.add(2);
    	l2.add(3);
    	overall.add(l2);
    	
    	List<Integer> l3 = new ArrayList<Integer>();
    	l3.add(1);
    	l3.add(-1);
    	l3.add(-3);
    	overall.add(l3);
    	
    /*	List<Integer> l4 = new ArrayList<Integer>();
    	l4.add(4);
    	l4.add(1);
    	l4.add(8);
    	l4.add(3);
    	overall.add(l4);*/
    	
    	int a = t.minimumTotal(overall);
    }
}
