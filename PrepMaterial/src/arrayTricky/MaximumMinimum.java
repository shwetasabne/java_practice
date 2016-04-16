package arrayTricky;

class MinMax {
	
	int min; 
	int max;
}


public class MaximumMinimum {

	public MinMax  returnMinMax(int [] a, int low, int high)
	{
		MinMax ret = new MinMax();
		MinMax ml = new MinMax();
		MinMax mr = new MinMax();
		
		if(low == high)
		{
			ret.max = a[low];
			ret.min = a[high];
			return ret;
		}
		if(high == low+1)
		{
			if(a[low] > a[high])
			{
				ret.min = a[high];
				ret.max = a[low];
				return ret;
			}
			else
			{
				ret.min = a[low];
				ret.max = a[high];
				return ret;
			}
		}
		int mid = (low+high)/2;
		ml = returnMinMax(a, low, mid);
		mr = returnMinMax(a, mid+1, high);
		
		if(ml.min < mr.min)
		{
			ret.min = ml.min;
		}
		else
		{
			ret.min = mr.min;
		}
		if(ml.max > mr.max)
		{
			ret.max = ml.max;
		}
		else
		{
			ret.max = mr.max;
		}
		return ret;
	}

	public static void main(String[] args) {
		
		int [] a = {5,6,3,0,1,9,-8};
		MaximumMinimum m = new MaximumMinimum();
		
		MinMax l = m.returnMinMax(a, 0, a.length-1);
		System.out.println(l.max+" "+l.min);
	}

}
