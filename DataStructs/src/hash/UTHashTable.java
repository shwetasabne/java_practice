package hash;

public class UTHashTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable ht = new HashTable();
		ht.put("name", "Shweta");
		ht.put("company", "NetApp");
	//	ht.dump();
		System.out.println(ht.size());
		System.out.println(ht.containsKey("name"));
		System.out.println(ht.get("name"));
		

		ht.remove("company");
		System.out.println(ht.containsKey("company"));
		System.out.println(ht.size());
		
	}

}
