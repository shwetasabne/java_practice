package dynamicprog;

public class MinimumStepsToDestination {

	public static int minSteps(int src, int dest, int steps)
	{
		if(Math.abs(src) > dest)
			return Integer.MAX_VALUE;
		
		if(src == dest)
			return steps;
		
		int pos = minSteps(src+steps+1, dest, steps+1);
		int neg = minSteps(src-steps-1, dest, steps+1);
		
		return Math.min(pos, neg);
	}
	
	public static void main(String[] args) {
		
		int out = minSteps(0, 11 ,0);
		System.out.println(out);
	}

}
