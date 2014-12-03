package com.test;

public class MergeTwoSortedArrays {

	public int [] mergeArrays(int [] A, int [] B){
		int insertAtPointer = A.length-1;
		int endA = findEndOfA(A);
		int endB = B.length -1;
		
		for (int i=0; i<A.length; i++){
			if (endB<0){
				A[insertAtPointer] = A[endA];
				endA--;
				insertAtPointer--;
			}
			else if(endA<0){
				A[insertAtPointer] = B[endB];
				endB--;
				insertAtPointer--;
			}
			else if (A[endA]>B[endB]){
				A[insertAtPointer] = A[endA];
				endA--;
				insertAtPointer--;
			}else{
				A[insertAtPointer] = B[endB];
				endB--;
				insertAtPointer--;
			}
		}
		
		return A;
	}
	
	int findEndOfA(int [] A){
		int i= A.length-1;
		for ( ; i>0; i--){
			if (A[i]<=A[i-1]){
				continue;
			}
			else {
				break;
			}
		}
		return i;
	}
	
	public void merge(int A[], int m, int B[], int n) {

	    for(int i = m + n - 1; i>=0; i--)
	    {
	        if( m>0 && n>0)
	        {
	            if(B[n-1] > A[m-1])
	            {
	                A[i] = B[n-1];
	                n--;
	            }
	            else
	            {
	                A[i] = A[m-1];
	                m--;
	            }
	        }
	        else if(m>0)
	        {
	            A[i] = A[m-1];
	            m--;       
	        }
	        else if(n>0)
	        {
	            A[i] = B[n-1];
	            n--;  
	        }
	    }
	    return;

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1,4,7,0,0,0};
		int [] B = {2,5,9};
		MergeTwoSortedArrays m = new MergeTwoSortedArrays();
		System.out.println(m.mergeArrays(A, B).toString());
	}

}
