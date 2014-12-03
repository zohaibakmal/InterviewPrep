package com.test;

public class magicIndex {

	public int findMagicIndex(int [] array){
		
		int end = array.length-1;
		int mid = end/2;
		int low = 0;
		
		return findIndex(array, low, end);
	}
	
	public int findIndex(int [] array, int low, int high ){
		int mid = (low+high)/2;
		
		if (low>=high){
			return -1;
		}
		if (mid==array[mid]){
			return mid;
		}
		else if (array[mid]>mid){ // look into left half
			return findIndex(array, low, mid);
		}
		else { // look into left half
			return findIndex(array, mid, high);
		}
		
	}
	
	public static void main(String[] args) {
		magicIndex mi = new magicIndex();
		int [] test = {-40, -20, -1,1, 2, 3, 5, 7 ,9, 12, 13};
		System.out.println(mi.findMagicIndex(test));
	}

}
