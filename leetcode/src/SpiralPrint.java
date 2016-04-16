import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SpiralPrint {

	public List printElements(int firstRow,  int lastRow, int firstCol,int lastCol, int [][] a, int elementCount, List<Integer> list)
	{
		
		System.out.println("Hey "+ firstRow + " "+lastRow+" "+firstCol + " "+lastCol);
		for(int i= firstCol; i < lastCol; i++)
		{
			if(list.size() >= (a.length * a[0].length))
			{
				System.out.println("breaking");
				return list;
			}
			list.add(a[firstRow][i] );
			System.out.print(a[firstRow][i] + " * " + elementCount + " . ");
			elementCount++;
			System.out.println("List size is "+list.size());
		}
		
		for(int i= firstRow; i < lastRow; i++)
		{
			if(list.size() >= (a.length * a[0].length))
			{
				System.out.println("breaking");
				return list;
			}
			list.add(a[i][lastCol] );
			System.out.print(a[i][lastCol] + " ! ");
			elementCount++;
		}

		for(int i = lastCol ; i > firstCol; i--)
		{
			if(list.size() >= (a.length * a[0].length))
			{
				System.out.println("breaking");
				return list;
			}
			System.out.println(" ****** list size is "+list.size() + " elem "+ (a.length * a[0].length));
			list.add(a[lastRow][i]);
			System.out.print(a[lastRow][i]+" ^ "+ list.size());
			elementCount++;
		}

		for(int i = lastRow; i > firstRow; i-- )
		{
			if(list.size() >= (a.length * a[0].length))
				return list;
			list.add(a[i][firstCol]);
			System.out.print(a[i][firstCol] + " % ");
			elementCount++;
		}
		if(firstRow == lastRow && lastCol == lastRow)
			list.add(a[firstRow][lastRow]);
		System.out.println("List now is "+list.toString());
		return list;
	}
	
	public static void main(String [] args)
	{
		SpiralPrint sp = new SpiralPrint();
		
		int [][] a = new int[4][4];
		a[0][0] = 1;
		a[0][1] = 2;
		a[0][2] = 3;
		a[0][3] = 4;
		
		a[1][0] = 5;
		a[1][1] = 6;
		a[1][2] = 7;
		a[1][3] = 8;
		
		a[2][0] = 9;
		a[2][1] = 10;
		a[2][2] = 11;
		a[2][3] = 12;
		
		a[3][0] = 13;
		a[3][1] = 14;
		a[3][2] = 15;
		a[3][3] = 16;
		a[3][0] = 10;
		a[3][1] = 11;
		a[3][2] = 12;
		
		/*int [][] a = new int[2][1];
		a[0][0] = 3;
		a[1][0] = 2;
		/*a[0][2] = 3;*/
//		System.out.println(a.length+" total "+(4*3));
		
		//System.out.println(Arrays.toString(a));
		for(int i=0; i < a.length; i++)
		{
			for(int j=0; j < a[0].length; j++)
			{
				System.out.print(a[i][j]+"*" + "  ");
			}
			System.out.println();
		}
		
		int elementCount = 0;
		int i = 0;
		List<Integer> list = new ArrayList();
		while(list.size() <= (a.length * a[0].length))
		{
			System.out.println("here");
			if(a.length-1-i >= i || a[0].length-1-1 >= i)
			{
				list = sp.printElements(i, a.length-1-i, i , a[0].length-1-i,  a, elementCount, list);
				i++;
			}
			else
			{
				break;
			}
		//	System.out.println("Element count is "+elementCount+" new  i "+i);
		}
		

		System.out.println("final count "+list.toString());
	}
}
