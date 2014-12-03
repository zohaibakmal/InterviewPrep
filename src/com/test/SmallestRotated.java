package com.test;

public class SmallestRotated {

	/*	public int findMin(int[] num) {
		return findMin(num, 0, num.length-1);
	}

	public int findMin(int[] num, int left, int right){

		if ((right-left)<=1){
			if (num[left]<num[right]){
				return num[left];
			}else{
				return num[right];
			}
		}

		int mid = (left + right)/2;

		//sorted from left to mid. Smallest is either left most or on the right side
		if (num[left]<=num[mid]){ 
			if (num[left]>=num[right]){
				left = mid+1;
				return (findMin(num, left, right));
			}else
				return num[left];
		}else{ // mid to right is sorted. Smallest is either mid or to the left
			if (num[mid]<num[mid-1]){
				return num[mid];
			}
			else{
				right = mid-1;
				return findMin(num, left, right);
			}
		}
	}

	 */




	public int findMin(int[] num) {
		if(num == null || num.length == 0) {
			return -1; 
		}
		int left = 0;
		int right = num.length-1;
		while(left < right) {
			if(num[left] < num[right]) {
				return num[left];
			}
			int mid = (right+left)/2;
			//rigth to mid is sorted. Look on the left side
			if(num[left] > num[mid]) {
				right = mid;
			} 
			// left to mid is sorted. Look on right side
			else if(num[left] < num[mid]) { 
				left = mid;
			} 
			//nothing much we can do. O(n)
			else { 
					if(num[left] == num[right]) {
						left++;
						right--;
					} else { 
						left = mid+1;
					}
			}
		}
		return num[left];
	}   

	public static void main(String[] args) {
		SmallestRotated sr = new SmallestRotated();
		int [] num ={1,1,3}; 
		System.out.println(sr.findMin(num));
	}

}
