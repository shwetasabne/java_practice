

abstract class Base {
	
	 final static int counter = 0;
	 public  abstract void printAb();
	 public  void printAb(String s){
		 System.out.println("Printing "+s);
	 }
}
public class Concepts extends Base{

	@Override
	public void printAb(String t)
	{
		System.out.println("child ");
		super.printAb(t);
	}
	public void printAb() {
		
		super.printAb("het "+super.counter);
		
	}

	public static void printAb(String s, int r)
	{
		System.out.println("static "+counter);
		
	}
	
	public static void main(String []args)
	{
		
		Concepts c = new Concepts();
		if(counter == 0)
		{
			
		}
		c.printAb("shweta");
		c.printAb("s", 0);
	}

}
