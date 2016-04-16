package infinitestreams;

import java.util.ArrayList;
import java.util.List;

class OutputStreamElement {
	
	public int value; 
	public int listIndex;
	
	public OutputStreamElement(int value, int listIndex)
	{
		this.value = value;
		this.listIndex = listIndex;
	}
	
	public String toString()
	{
		return ((Integer)this.value).toString();
	}
}

public class InputStream {

	public List<Integer> inputStream = new ArrayList<Integer>();

	public int readAt(int index)
	{
		//System.out.println("Size is "+this.inputStream.size()+" index is "+index);
		if(this.inputStream.size() <= index)
			return -1;
		else
			return this.inputStream.get(index);
	}
	
	public void addTo(int value)
	{
		this.inputStream.add(value);
	}
}
