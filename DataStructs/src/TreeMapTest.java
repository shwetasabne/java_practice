import java.util.Map;
import java.util.TreeMap;


public class TreeMapTest {

	public static void main(String [] args){
		TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();
		m.put(2, 10);
		m.put(1, 20);
		
		for(Map.Entry<Integer, Integer> entry : m.entrySet()){
			System.out.println(entry.getKey() + " "+ entry.getValue());
		}
	}
}
