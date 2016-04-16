package stacksandqueue;

public class BitWise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 7;
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toBinaryString((num >> 2) & 0x1) );
		System.out.println(Integer.toBinaryString(0x1));
	}

}
