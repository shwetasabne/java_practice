package glassdorr;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class TempComp implements Comparator<Integer>
{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		if(o1 < o2)
			return 1;
		else if(o1 == o2)
			return 0;
		else
			return -1;
	}
	
}
public class LargestNumberWithKSwaps {

	static TempComp t = new TempComp();
	public static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(11, t);
	public void getMaxNumber(int num, int k, String prefix, String numSuffix)
	{
	//	System.out.println("Prefix is "+prefix + " num is "+numSuffix);
		if(k == 0)
		{
		//	System.out.println ("**** Possibility is " + Integer.valueOf(prefix+numSuffix));
			pq.add(Integer.valueOf(prefix+numSuffix));
		}
		else
		{
			int [] temp = findSwappedWithGreatestDigit(Integer.valueOf(numSuffix));
			for(int i=0; i < temp.length; i++){
			//	System.out.println("temp is "+temp[i]);
				 for(int j=0; j < Integer.toString(temp[i]).length(); j++)
					 getMaxNumber(num, k-1, prefix+String.valueOf(String.valueOf(temp[i]).charAt(j)), String.valueOf(temp[i]).substring(0,j)+String.valueOf(temp[i]).substring(j+1));
			}
		}
	}
	
	/*public int getMaxNumber(int num, int k, String prefix, String numSuffix)
	{
		System.out.println("Prefix is "+prefix + " num is "+numSuffix);
		if(k == 0)
			return Integer.valueOf(prefix+numSuffix);
		else
		{
			int temp = findSwappedWithGreatestDigit(Integer.valueOf(numSuffix));
			System.out.println("temp is "+temp);
			return getMaxNumber(num, k-1, prefix+String.valueOf(String.valueOf(temp).charAt(0)), String.valueOf(temp).substring(1));
		}
	}*/
	
	public int [] findSwappedWithGreatestDigit(int num)
	{
		String temp = Integer.toString(num);
		
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		int i =0;
		//System.out.println("Temp is " +temp);
		char [] charArr = temp.toCharArray();
		for(char ch : temp.toCharArray())
		{
	//		System.out.println(Integer.valueOf(String.valueOf(ch)));
			if(Integer.valueOf(String.valueOf(ch)) >= max)
			{
				maxIndex = i;
				max = Integer.valueOf(String.valueOf(ch));
			}
			i++;
		}
		// get a greater number by deciding the swap position and not just 0
		int maxNumber = Integer.MIN_VALUE;
		
		int [] possibleCombos = new int[charArr.length];
		int k = 0;
		for(int j=0; j< charArr.length; j++)
		{
			int tempNumber = swapAndCheck(charArr.clone(), j, maxIndex);
			possibleCombos[k] = tempNumber;
		//	System.out.println(Arrays.toString(charArr)+" After comparing "+maxIndex+ " and "+j+" num is "+tempNumber);
			if ( tempNumber > maxNumber)
				maxNumber =  tempNumber;
			k++;
		}
		return possibleCombos;
	/*	return maxNumber;*/
		//return maxIndex;
	}
	
	public int swapAndCheck(char [] tempCharArr, int i, int maxIndex)
	{
		char t = tempCharArr[i];
		tempCharArr[i] = tempCharArr[maxIndex];
		tempCharArr[maxIndex] = t;
		
		return Integer.valueOf(String.valueOf(tempCharArr));
	}
	public static void main(String[] args) {
	
		LargestNumberWithKSwaps l = new LargestNumberWithKSwaps();
		//System.out.println(l.findSwappedWithGreatestDigit(132));
		l.getMaxNumber(876959, 2, "", String.valueOf(7899));
		System.out.println(pq.poll());
	}

}
