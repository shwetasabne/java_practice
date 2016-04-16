package geekforgeeks;

public class AreaCoveredByPath {

	
	public int findArea(boolean [][] a)
	{
		int area = 0;
		
		int j = 0;
		while(j < a[0].length-1)
		{
			int min = a[0].length;
			int max = 0;
			for(int i=0; i < a.length; i++)
			{
				if(a[i][j] && a[i][j+1])
				{
					if(i  < min)
						min = i;
					if(i > max)
						max = i;
				}
				
			}
			System.out.println("for j = "+j +" and j+1 = "+(j+1)+" min = "+min +" max = "+max );
			if(min < max)
			{
				area += (1 * (max-min));
			}
			j++;
		}
			
		return area;
	}
	
	public static void main(String[] args) {
		
		AreaCoveredByPath r = new AreaCoveredByPath();
		boolean [][] a = new boolean[5][5];
		
		a[0][0] = false;
		a[0][1] = false;	
		a[0][2] = false;
		a[0][3] = false;
		a[0][4] = false;
		
		a[1][0] = false;
		a[1][1] = true;	
		a[1][2] = true;
		a[1][3] = false;
		a[1][4] = false;
		
		a[2][0] = false;
		a[2][1] = true;	
		a[2][2] = true;
		a[2][3] = true;
		a[2][4] = false;
		
		a[3][0] = false;
		a[3][1] = true;	
		a[3][2] = true;
		a[3][3] = true;
		a[3][4] = false;
		
		a[4][0] = false;
		a[4][1] = false;	
		a[4][2] = false;
		a[4][3] = false;
		a[4][4] = false;
		
		for(int i =0 ; i < 5; i++)
		{
			for(int j=0; j<5; j++)
			{
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
		
		int area = r.findArea(a);
		System.out.println("*** Area is "+area);
	}

}
