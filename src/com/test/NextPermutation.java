package com.test;

public class NextPermutation {

	/*
	* Take the example:
	* Num =	[1,5,8,4,7,6,5,3,1]
	* Idx = [0,1,2,3,4,5,6,7,8]
	* 1. Find the longest non-increasing suffix.
	* 		Find the pair such that nums[i-1]<num[i].
	* 	 	From the example above, we see that such pair is num[3]<num[4]. I.e. 4 is less than 7.
	* 2. Find the number that is one larger then nums[i-1].
	* 		Since the numbers to the right of nums[i] are sorted in descending order, we can begin our search from the end.
	* 		Increment pointers until we have found our number num[j].
	* 		From the example, num[6]>num[3]. I.e. 5 is greater then 4.
	* 3. Swap nums[i-1] with nums[j].
	* 		From the example, the resultant array will be
	* 		Num' =	[1,5,8,5,7,6,4,3,1]
	* 		Idx  =  [0,1,2,3,4,5,6,7,8]
	* 4. Reverse the suffix. I.e. numbers from num[i] - num[length-1];
	* 		Num' =	[1,5,8,5,1,3,4,6,7]
	*
	* */

	public void nextPermutation(int[] num) {
		int n=num.length;
		if(n<2)
			return;
		int index=n-1;        
		while(index>0){
			//Find the longest non-increasing suffix. 
			//Identify the pivot
			if(num[index-1]<num[index])
				break;
			index--;
		}
		//if number already largest. Just Reverse it.
		if(index==0){
			reverseSort(num,0,n-1);
			return;
		}
		else{
			//Find the right right most successor to the pivot in the suffix window.
			int val=num[index-1];
			int j=n-1;
			while(j>=index){
				if(num[j]>val)
					break;
				j--;
			}
			//swap with the pivot
			swap(num,j,index-1);
			//reverse the suffix
			reverseSort(num,index,n-1);
			return;
		}
	}

	public void swap(int[] num, int i, int j){
		int temp=0;
		temp=num[i];
		num[i]=num[j];
		num[j]=temp;
	}

	public void reverseSort(int[] num, int start, int end){   
		if(start>end)
			return;
		for(int i=start;i<=(end+start)/2;i++)
			swap(num,i,start+end-i);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
