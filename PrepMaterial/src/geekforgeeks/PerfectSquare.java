package geekforgeeks;

public class PerfectSquare {


	public static void main(String[] args) {
		
		double n = 32;
		
		for(double i=2; i < n ; i++){
			
			double temp = Math.log(n) / Math.log(i);
			//System.out.println(Math.log(n)+ " " + Math.log(i) + " " + i + " : " +temp+ " "+Math.round(temp));
			if(Math.abs(Math.round(temp) - temp) < 0.00000000000001){
				System.out.println("true " +i);
				//break;
			}
		}
		System.out.println("done");
	}

}
