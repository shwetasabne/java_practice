import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


class FileSorter {
		String origFileName;
		int numericPart;
		
		public FileSorter(String filename)
		{
			this.origFileName = filename;
			String temp = filename.replaceAll("[^0-9]+", "");
			
			this.numericPart = Integer.valueOf(temp);
		}
		
		public String toString()
		{
			return this.origFileName;
		}


}

public class SortFilesLogically {

	public static void main(String[] args) {
		
		FileSorter[] f = new FileSorter[4];
		f[0] = new FileSorter("file1");
		f[1] = new FileSorter("folder100");
		f[2] = new FileSorter("file2");
		f[3] = new FileSorter("file10");
		
		for(FileSorter f1 : f)
		{
			System.out.println(f1.toString());
		}
		
		Comparator<FileSorter> comp = new Comparator<FileSorter>()
				{

					@Override
					public int compare(FileSorter o1, FileSorter o2) {
						if(o1.numericPart < o2.numericPart)
							return -1;
						else if(o1.numericPart > o2.numericPart)
							return 1;
						else
							return 0;
					}
			
				};
		Arrays.sort(f, comp);
		System.out.println("after");
		for(FileSorter f1 : f)
		{
			System.out.println(f1.toString());
		}
	}

}
