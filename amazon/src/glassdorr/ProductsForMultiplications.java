package glassdorr;

import java.util.Arrays;

public class ProductsForMultiplications {

	public int [] prodArray (int [] a)
	{
		int [] prods = new int[a.length];
		
		int p = 1;
		for(int i=0; i < a.length; i++)
		{
			prods[i] = p;
			p *=a[i];
		}
		p =1;
		for(int i= a.length-1; i >=0; i--)
		{
			prods[i]*=p;
			p*=a[i];
		}
		System.out.println(Arrays.toString(prods));
		return prods;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a= {1,2,3,4,5};
		ProductsForMultiplications p = new ProductsForMultiplications();
		p.prodArray(a);

	}

}
