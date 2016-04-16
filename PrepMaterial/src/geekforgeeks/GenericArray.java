package geekforgeeks;

import java.util.Arrays;

public class GenericArray {

	public void checkDuplicates(int [] arr)
	{
		if(arr.length == 0)
			return ;
		int output = arr[0];
		for(int i =1; i < arr.length; i++)
		{
			arr[i] = arr[i]^arr[i-1] ^i;
		}
		System.out.println(output);
	}
	
	public void seive(int N)
	{
		boolean [] isPrime = new boolean[N+1];
		for(int i=2; i <=N; i++)
		{
			isPrime[i] = true;
		}
		
		for(int i=2; i*i <= N; i++)
		{
			if(isPrime[i])
			{
				for(int j=i; i*j <=N ; j++)
				{
					isPrime[i*j] = false;
				}
			}
		}
		for(int i=2; i<=N; i++)
		{
			if(isPrime[i])
				System.out.print(i+" ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericArray g = new GenericArray ();
		int [] a = {1,2,3,3,4};
	//	g.checkDuplicates(a);
		g.seive(20);
	}

}
