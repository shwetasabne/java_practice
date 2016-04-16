import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Contact {
	
	String name;
	boolean isVisited;
	List<String> cList;
	public Contact(String name, List<String> cList)
	{
		this.name = name;
		this.isVisited = false;
		this.cList = cList;
	}
	
	public String toString()
	{
		return this.name+" "+this.cList.toString();
	}
}

public class DoesContactMatch {


	public static void main(String[] args) {
		
		String[][] A = { 
			//  { 0           1               		2}
				{ "John",     "john@gmail.com", 	"john@fb.com"} ,
				{ "Dan",      "dan@gmail.com", 	"+1234567"},
				{ "john123",   "+5412312", 		"john123@skype.com"}, 
				{ "john1985", "+5412312", 		"john@fb.com"}  
				};
		
		HashMap<String, List> m = new HashMap<String, List>();
		List<Contact> allContacts = new ArrayList<Contact>();
		for(int i=0; i < A.length; i++)
		{
			List<String> temp = new ArrayList<String>();
			for(int j=1; j < A[i].length; j++)
			{
				temp.add(A[i][j]);
			}
			Contact c = new Contact(A[i][0], temp);
			allContacts.add(c);
		}
	//	System.out.println(allContacts.toString());
		for(Contact c : allContacts)
		{
			List<String> details = c.cList;
			for(String s : details)
			{
				if(m.containsKey(s))
				{
					List<Contact> contacts = m.get(s);
					contacts.add(c);
					m.put(s, contacts);
				}
				else
				{
					List<Contact> contacts = new ArrayList<Contact>();
					contacts.add(c);
					m.put(s, contacts);
				}
			}
		}
		System.out.println(m.toString());
		ArrayList<ArrayList<String>> overall = new ArrayList<ArrayList<String>>();
		for(Map.Entry<String, List> entry : m.entrySet())
		{
			List<Contact> contactList = entry.getValue();
			for(Contact c : contactList)
			{
				ArrayList<String> temp = new ArrayList<String>();
			//	c.isVisited = true;
			//	System.out.println("*****");
			//	System.out.println(" key is "+entry.getKey());
				findUnions(c, m, temp);
				
		//		System.out.println("Connection "+ temp.toString());
				if(temp.size() != 0)
					overall.add(temp);
				//return;
			}
		}
		System.out.println(overall.toString());

	}
	
	public static void findUnions(Contact c, HashMap m, ArrayList<String> temp)
	{
		//ArrayList<String> temp = new ArrayList<String>();
		
		for(String s : c.cList)
		{
			if(m.containsKey(s))
			{
				List<Contact> con = (List<Contact>) m.get(s);
				for(Contact c1 : con)
				{
			//		System.out.println("Checking contact "+c1.toString());
					if(!c1.isVisited)
					{
						temp.add(c1.name);
						c1.isVisited = true;
						findUnions(c1, m, temp);
					}
				}
			}
		}
		
		//return temp;
	}

}
