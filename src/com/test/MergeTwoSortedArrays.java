package com.test;


/*
* Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

Complexity: O(n+m)
SpaceComplexity: O(n+m)
*
* */
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

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int i = m+n-1; i>=0;i--){
			if (m>=1 && n>=1 && nums1[m-1]>=nums2[n-1]){
				nums1[i] = nums1[m-1];
				m--;
			}else if (m>=1 && n>=1 && nums1[m-1]<nums2[n-1]){
				nums1[i] = nums2[n-1];
				n--;
			}else if (m>=1){
				nums1[i] = nums1[m-1];
				m--;

			}else{
				nums1[i] = nums2[n-1];
				n--;
			}
		}
	}

	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		int insertPosition = m+n - 1;
		while (m>0 && n>0){
			if (nums1[m-1]>=nums2[n-1]){
				nums1[insertPosition] = nums1[m-1];
				m--;
			}else{
				nums1[insertPosition] = nums2[n-1];
				n--;
			}
			insertPosition--;
		}
		while (n>0){
			nums1[insertPosition] = nums2[n-1];
			n--;
			insertPosition--;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1,4,7,0,0,0};
		int [] B = {2,5,9};
		MergeTwoSortedArrays m = new MergeTwoSortedArrays();
		System.out.println(m.mergeArrays(A, B).toString());
	}

}
