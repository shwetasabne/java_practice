package stack;

public class UTStack {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		//Operations using ArrayStack
		System.out.println("Testing Array Stack");
		ArrayStack ar = new ArrayStack(2);
		ar.push(2);
		ar.push(4);
		ar.printStack();
		ar.push(3);
		int lastelement = ar.pop();
		System.out.println("Last inserted element " + lastelement);

		//Operations use DynArrayStack
		
		//Operations use LinkStack
		System.out.println("Testing List Stack");
		ListStack sa = new ListStack();
		sa.push(2);
		sa.push(4);
		sa.push(6);
		sa.printStack();
		lastelement = sa.pop();
		System.out.println("Last inserted element " + lastelement);
		lastelement = sa.pop();
		System.out.println("Last inserted element " + lastelement);
	}

}
