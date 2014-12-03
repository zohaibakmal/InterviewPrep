package com.test;

import java.util.Arrays;

public class RemoveDuplicatesFromArray {

/*	public int removeDuplicates(int[] A) {
		int duplicates = countDuplicates(A);
		int [] B = new int[A.length-duplicates];
		int j = 0;
		for (int i =0; i<A.length;i++){
			if (i<1){
				B[j] = A[i];
				continue;
			}else if(A[i-1]==A[i]){
				continue;
			}
			
			++j;
			B[j] = A[i];
		}
		A = B;
		System.out.println(Arrays.toString(A));
		return A.length;
	}
	public int [] moveElementsBack(int [] A,int i){
		
		for (;i<A.length;i++){
			A[i-1] = A[i] ;
		}
		return A;
	}
	
	public int countDuplicates(int [] A){
		int count = 0;
		for (int i=0; i<A.length;i++){
			if (i<1){
				continue;
			}else{
				if (A[i-1]==A[i]){
					count++;
				}
			}
		}
		return count;
	}	
*/
	public int removeDuplicates(int[] A){
    	if (A.length<2){
    	    return A.length;
    	}
    	int count = 1;
    	for (int i = 1;i<A.length;i++){
    	    if (A[i-1]!=A[i]){
    	        A[count] = A[i];
    	        count++;
    	    }
    	    else{
    	        continue;
    	    }
    	}
    	return count;
    }
		public static void main(String [] args){
		RemoveDuplicatesFromArray rm = new RemoveDuplicatesFromArray();
		int [] test = {1,1,3,3,3,5,6};
		System.out.println(rm.removeDuplicates(test));
	}

}
