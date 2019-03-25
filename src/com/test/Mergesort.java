package com.test;

import java.util.Arrays;

public class Mergesort {
	private int[] numbers;
	private int[] helper;

//	private int number;

//	public void sort(int[] values) {
//		this.numbers = values;
//		number = values.length;
//		this.helper = new int[number];
//		mergesort(0, number - 1);
//	}
//
//	private void mergesort(int low, int high) {
//		// check if low is smaller then high, if not then the array is sorted
//		if (low < high) {
//			// Get the index of the element which is in the middle
//			int middle = low + (high - low) / 2;
//
//			// Sort the left side of the array
//			mergesort(low, middle);
//			// Sort the right side of the array
//			mergesort(middle + 1, high);
//			// Combine them both
//			System.out.println("low: "+ low+ " Middle: " + middle+ " High: " +high);
//			merge(low, middle, high);
//		}
//	}
//
//	private void merge(int low, int middle, int high) {
//		// Copy both parts into the helper array
//		for (int i = low; i <= high; i++) {
//			helper[i] = numbers[i];
//		}
//		System.out.println("Helper " + Arrays.toString(helper));
//		int i = low; //low pointerc
//		int j = middle + 1;
//		int k = low; // pointer into our sorted/original array
//		// Copy the smallest values from either the left or the right side back
//		// to the original array
//		while (i <= middle && j <= high) {
//			if (helper[i] <= helper[j]) {
//				numbers[k] = helper[i];
//				i++;
//			} else {
//				numbers[k] = helper[j];
//				j++;
//			}
//			k++;
//		}
//		System.out.println("numbers " + Arrays.toString(numbers));
//
//		// Copy the rest of the left side of the array into the target array
//		while (i <= middle) {
//			numbers[k] = helper[i];
//			k++;
//			i++;
//		}
//
//	}
//
//
//
	public void sort(int [] inputArray){
		this.numbers = inputArray;
		this.helper = new int[inputArray.length];
		divide(0, inputArray.length-1);
	}

	public void divide (int low, int high){

		if (low<high){
			int middle = low + (high-low)/2;

			divide(low, middle);
			divide(middle+1, high);

			merge(low,middle,high);
		}

	}

	public void merge (int low, int middle, int high){

		for (int i=low; i<=high; i++){
			helper[i] = numbers[i];
		}

		int i = low; // index for first sub-array
		int j = middle+1; // index for second sub-array
		int k = low;

		while (i<=middle && j<=high){
			if (helper[i]<=helper[j]){
				numbers [k] = helper[i];
				i++;
			}else{
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}

		//copy the remaining elements in left sub-array into target array.
		while (i<=middle){
			numbers[k] = helper[i];
			k++;
			i++;
		}

		//copy the remaining elements in left sub-array into target array.
		while (j<=high){
			numbers[k] = helper[j];
			k++;
			j++;
		}

	}

	public static void main(String args []){
		
		Mergesort ms = new Mergesort();
		int [] test = {50, 10, 14, 26, 36, 15, 0, 9};
		ms.sort(test);
		System.out.print(Arrays.toString(test));
	}
} 
