package com.test;

public class NextPermutation {

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
