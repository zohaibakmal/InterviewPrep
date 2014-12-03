
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
		if (A.length==0&&B.length==0)
			return -1;
		else if (A.length==0){
			findMedian(B, 0, B.length-1);
		}
		else if (B.length==0){
			findMedian(A, 0, A.length-1);
		}
        return findMedian (A,B,0,A.length-1,0,B.length-1);
    }
    
    public double findMedian(int A[], int B[], int aLow, int aHigh, int bLow, int bHigh){
    	if (aHigh-aLow<2 && bHigh-bLow<2){
    		 return (double)(Math.max(A[aLow],B[bLow]) + Math.min(A[aHigh],B[bHigh])) / 2;
            //return  ((double)(A[aHigh]+A[aLow])/2 + (double)(B[bHigh]+B[bLow])/2)/2;
        }
    	double medianA = findMedian(A, aLow, aHigh);
        double medianB = findMedian(B, bLow, bHigh);
        
        if (medianA==medianB){
            return medianA;
        }

        //look in left side of A & right side of B
        if (medianA>medianB){
            if (aHigh-aLow>1)
                aHigh = (aLow+aHigh)/2;    
            if (bHigh-bLow>1)
                bLow = (bLow+bHigh)/2+1;
   //         return findMedian(A, B, aLow, aHigh, bLow, bHigh);
        }
        
        //look in right side of A & left side of B
        else{
            if (aHigh-aLow>1)
                aLow = (aLow+aHigh)/2+1;
            if (bHigh-bLow>1)
                bHigh = (bLow+bHigh)/2;
     
        }
        return findMedian(A, B, aLow, aHigh, bLow, bHigh);  
    }
	public static void main(String[] args) {
		FindMedianSortedArrays m = new FindMedianSortedArrays();
		 int []ar1 = {1, 2};
		 int []ar2 = {1,2,3};
		 System.out.println(0%2);
		 System.out.println(m.findMedianSortedArrays(ar1, ar2));

	}
	
	public double findMedian(int [] A, int low, int high){
		 if (A.length-1%2==0)
		        return (double) A[(A.length-1)/2];
		    else
		        return (double) (A[(A.length-1)/2]+ A[(A.length)/2])/2;
	}

}
