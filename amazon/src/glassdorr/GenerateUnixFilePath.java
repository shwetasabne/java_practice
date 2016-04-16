package glassdorr;

import java.util.Arrays;



public class GenerateUnixFilePath {

	public void getRealPath(String s)
	{
		int j = 0;
		//int i = 0;
		
		String [] input = s.split("/");
		
		String [] output = new String[input.length];
		
		for(int i=0; i < input.length; i++)
		{
			if(input[i].equals(".."))
			{
				--j;
			}
			else if(input[i].equals("."))
			{
				continue;
			}
			else {
				output[j] = input[i];
				++j;
			}
		}
		String output1 = "";
		for(int i=0; i< output.length; i++)
		{
			if(output[i] == null || output[i].equals("") )
			{
				continue;
			}
			else
			{
				output1+= output[i];
			}
		}
		System.out.println(output1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateUnixFilePath g = new GenerateUnixFilePath();
		g.getRealPath("/a/b/c/../../d/./e");
	}

}
