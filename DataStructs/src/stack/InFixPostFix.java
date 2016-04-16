package stack;

import java.util.HashMap;

public class InFixPostFix {

	private HashMap precedence_map = new HashMap();
	
	public InFixPostFix(){
		
		this.precedence_map.put('(', 3);
		this.precedence_map.put(')', 3);
		this.precedence_map.put('*', 2);
		this.precedence_map.put('/', 2);
		this.precedence_map.put('+', 1);
		this.precedence_map.put('-', 1);
	}
	
	public String generatePostFix(String infix){
		
		StringBuilder sb = new StringBuilder();
		DynArrayStack dn = new DynArrayStack();
		
		for (int i=0; i < infix.length(); i ++){
			System.out.println("Processing " +  infix.charAt(i));
			System.out.println("String is " + sb.toString());
			System.out.println("Stack is ");
			dn.printStack();
			System.out.println("*******");
			// Implies that the char is a char
			if(( (int) infix.charAt(i)  <= 90  && (int) infix.charAt(i) >= 65 ) ||
			   ( (int) infix.charAt(i)  <= 122  && (int) infix.charAt(i) >= 97 ))
			{
				System.out.println("if");
				sb.append(infix.charAt(i));
			}
			else if( infix.charAt(i) == ')'){
				System.out.println("else if");
				char last_popped = 0 ;
				while(last_popped != '('){
					last_popped = dn.pop();
					sb.append(last_popped);
				}
			}
			else{
				System.out.println("else");
				int curr_precedence = (Integer)precedence_map.get(infix.charAt(i));
				int itr_precedence = 0;
				char popper = 0;
				while( ! ( dn.isStackEmpty() ) && ( curr_precedence < itr_precedence) || ( infix.charAt(i) == '(')){
					dn.printStack();
					popper = dn.pop();
					System.out.println(popper);
					itr_precedence = (Integer)precedence_map.get(popper);
					sb.append(popper);
					System.out.println(sb);
				}
				
				dn.push(infix.charAt(i));
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InFixPostFix ifp = new InFixPostFix();
		String st = ifp.generatePostFix("A*B-(C+D)+E");
		System.out.println(st);
	}

}
