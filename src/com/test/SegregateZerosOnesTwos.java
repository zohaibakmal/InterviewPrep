package com.test;

import java.util.Arrays;
/*
 * The array is divided into four sections:
 * a[0..low] zeroes (red)
 * a[low+1..mid] ones (white)
 * a[mid+1..Hi] unknown
 * a[high+1..N] twos (blue)
 * 
 * */
public class SegregateZerosOnesTwos {

	void sort012(int [] a)
	{
		int low = 0;
		int high = a.length - 1;
		int mid = 0;

		

		while(mid <= high)
		{
			/*while ((a[high]==2) && high >= mid)
				--high;

			if (high < mid)
				break;*/
			
			if (a[mid]==0){
				swap(a,low,mid);
				low++;
				mid++;
			}

			else if (a[mid]==1){
				mid++;
			}
			else if (a[mid]==2){
				swap(a, mid, high);
				high--;
			}
			/*
			switch(a[mid])
			{
			case 0:
				swap(a, low++, mid++);
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(a, mid, high--);
				break;
			}*/
		}
	}

	void segregate0and1(int arr[])
	{
		/* Initialize left and right indexes */
		int left = 0, right = arr.length-1;     

		while(left < right)
		{
			/* Increment left index while we see 0 at left */
			while(arr[left] == 0 && left < right)
				left++;

			/* Decrement right index while we see 1 at right */
			while(arr[right] == 1 && left < right)
				right--;

			/* If left is smaller than right then there is a 1 at left
	      and a 0 at right.  Exchange arr[left] and arr[right]*/
			if(left < right)
			{
				swap(arr,left,right);
				//				arr[left] = 0;
				//				arr[right] = 1;
				left++;
				right--;
			}
		}
	}   

	void swap(int []arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SegregateZerosOnesTwos s = new SegregateZerosOnesTwos();
		int [] a = {0,1,1,0,2,1,0};
		s.sort012(a);
		System.out.println(Arrays.toString(a));
		int [] arr = {0,1,1,0,1,1,0};
		s.segregate0and1(arr);
		System.out.print(Arrays.toString(arr));
	}

}
