
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


    /*
    * Simple Solution
    * Merge the two arrays into a single sorted array and find the median of the merged array;
    *
    * Time: O(n+m)
    * Space: O(n+m)
    * */

	public double findMedianSortedArraysSimple(int[] nums1, int[] nums2) {
		int totalLength = nums1.length+nums2.length;
		int [] mergedArray = new int [totalLength];
		int mergeIdx=0;
		int p1=0;
		int p2=0;

		while (p1<nums1.length && p2<nums2.length){
			if (nums1[p1]<=nums2[p2]){
				mergedArray[mergeIdx] = nums1[p1];
				p1++;
			}else{
				mergedArray[mergeIdx] = nums2[p2];
				p2++;
			}
			mergeIdx++;
		}

		while (p1<nums1.length){
			mergedArray[mergeIdx] = nums1[p1];
			p1++;
			mergeIdx++;
		}
		while (p2<nums2.length){
			mergedArray[mergeIdx] = nums2[p2];
			p2++;
			mergeIdx++;
		}

		if ((nums1.length+nums2.length) %2 ==1){
			return mergedArray[(totalLength)/2];
		}else{
			double m1 = mergedArray[(totalLength)/2];
			double m2 = mergedArray[(totalLength)/2-1];
			return (m1+m2)/2;
		}
	}


	/**
	 * Solution
	 * Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
	 * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
	 * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.
	 *
	 * Time complexity is O(log(min(x,y))
	 * Space complexity is O(1)
	 *
	 * https://leetcode.com/problems/median-of-two-sorted-arrays/
	 * https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation/4
	 */
	public double findMedianSortedArraysEff(int[] nums1, int[] nums2) {
		//if nums1 length is greater than switch them so that nums1 is smaller than nums2.
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}
		int x = nums1.length;
		int y = nums2.length;

		int low = 0;
		int high = x;
		while (low <= high) {
			int partitionX = (low + high)/2;
			int partitionY = (x + y + 1)/2 - partitionX;

			//if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
			//if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				//We have partitioned array at correct place
				// Now get max of left elements and min of right elements to get the median in case of even length combined array size
				// or get max of left for odd length combined array size.
				if ((x + y) % 2 == 0) {
					return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
				} else {
					return (double)Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
				high = partitionX - 1;
			} else { //we are too far on left side for partitionX. Go on right side.
				low = partitionX + 1;
			}
		}
		//Only we we can come here is if input arrays were not sorted. Throw in that scenario.
		throw new IllegalArgumentException();
	}



	public static void main(String[] args) {
		FindMedianSortedArrays m = new FindMedianSortedArrays();
		 int []ar1 = {1, 2};
		 int []ar2 = {3,4};
		 System.out.println(m.findMedianSortedArrays(ar1, ar2));

	}
	
	public double findMedian(int [] A, int low, int high){
		 if (A.length-1%2==0)
		        return (double) A[(A.length-1)/2];
		    else
		        return (double) (A[(A.length-1)/2]+ A[(A.length)/2])/2;
	}

}


//	int idx1=0;
//	int idx2=0;
//	boolean last1 = false;
//
//        for (int i=0; i< (nums1.length+nums2.length)/2;i++){
//		if (nums1[idx1] <= nums2[idx2]){
//		idx1++;
//		last1=true;
//		}else{
//		idx2++;
//		last1=false;
//		}
//		}
//
//		if ((nums1.length+nums2.length)%2 == 0){
//		return (nums1[idx1]+nums2[idx2])/2;
//		}else{
//		if(last1){
//		return nums1[idx1];
//		}else{
//		return nums2[idx2];
//		}
//		}