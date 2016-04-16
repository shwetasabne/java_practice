public class MedianSortedArray {
    	 static double medianOfThree(int a, int b, int c){
		
	        int maxI=Math.max(Math.max(a, b),c);
	        int minI=Math.min(Math.min(a,b),c);
	        return (a+b+c-maxI-minI);
	    }
	        
	   static double medianOfFour(int a, int b, int c, int d){
		
	        int maxI=Math.max(Math.max(Math.max(a,b),c),d);
	        int minI=Math.min(Math.min(Math.min(a,b),c),d);
	        return (a+b+c+d-maxI-minI)/2.0;
	    }
	    public static double median(int [] A, int aStart, int aEnd, int [] B, int bStart, int bEnd)
	{
		int aSize = aEnd - aStart + 1 ;
		int bSize = bEnd - bStart + 1;
		if (aSize == 0 ){
			
			return (bSize%2) == 0 ? (B[bSize/2] + B[(bSize/2)-1])/2.0 : B[bSize/2];
		}
		if (bSize == 0) {
			return (aSize%2) == 0 ? (A[aSize/2] + A[(aSize/2)-1])/2.0 : A[aSize/2];
		}
		if (aSize == 1){
			//find median base case
			if(bSize==1){
                return (B[bStart]+A[aStart])/2.0;
            }else if(bSize%2==0){
            	
                return medianOfThree(A[aStart],B[(bSize)/2-1+bStart],B[bSize/2]);
            }else{
                return (B[bSize/2]+medianOfThree(A[aStart],B[(bSize)/2-1+bStart],B[(bSize)/2+1+bStart]))/2.0;
            }
		}
		if (bSize == 1){
			if(aSize==1){
				return (B[bStart]+A[aStart])/2.0;
            }else if(aSize%2==0){
                return medianOfThree(B[bStart],A[(aSize-1)/2+aStart],A[aSize/2]);
            }else{
                return (A[aSize/2]+medianOfThree(B[bStart],A[(aSize)/2-1+aStart],A[(aSize+1)/2+aStart]))/2.0;
            }
		}
		if(aSize == 2){
			if(bSize == 2){
				return medianOfFour(A[aStart], A[aEnd], B[bStart], B[bEnd]);
			}
			else if(bSize%2 == 0){
				System.out.println(" " +B[(bSize+bStart)/2] + " " + A[aEnd]);
				return medianOfFour(Math.max(B[((bSize)/2-2)+bStart ], A[aEnd]), B[((bSize)/2 -1)+bStart], B[((bSize)/2)+bStart], Math.min(B[((bSize)/2+1+bStart)], A[aStart]));
			}
			else {
				
				return medianOfThree(Math.max(A[aEnd],B[(bSize)/2-1+bStart]),B[(bSize)/2+bStart],Math.min(A[aStart],B[((bSize)/2+1+bStart)]) );
			}
		}
		if(bSize == 2){
		
			if(aSize == 2){
				return medianOfFour(A[aStart], A[aEnd], B[bStart], B[bEnd]);
			}
			else if(aSize%2 == 0){
				
				return medianOfFour(Math.max(A[((aSize)/2-2)+aStart ], B[bEnd]), A[((aSize)/2 -1)+aStart], A[((aSize)/2)+aStart], Math.min(A[((aSize)/2+1+aStart)], B[bStart]));
			}
			else {
				
				return medianOfThree(Math.max(B[bEnd],A[(aSize)/2-1+aStart]),A[((aSize)/2)+aStart],Math.min(B[bStart],A[((aSize)/2)+1+aStart]) );
			}
		}
		
		// middle element of A
		int m = (aSize) / 2;
		
		// middle element of B
		int n = (bSize) / 2;
		int k = 0;
		m = aStart + m;
		n = bStart + n;
		System.out.println("m " + m + " n " + n);
	if(A[m] <= B[n]){
			k = (aSize%2 == 0) ? Math.min((aSize/2)-1, (bSize - (bSize/2) -1)) : Math.min((aSize/2), (bSize - (bSize/2) -1) );
			System.out.println("K is "+k);
			return median(A, aStart+k, aEnd, B, bStart, bEnd - k);
		}
		else {
			
			k = ( (bSize % 2 == 0) ? Math.min((aSize-(aSize/2)-1), (bSize/2)-1) : Math.min((aSize-(aSize/2)-1), (bSize/2)) );
			System.out.println("2K is "+k);
			return median(A, aStart, aEnd - k, B, bStart+k, bEnd);
		}

	}
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return MedianSortedArray.median(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1);
    }
}