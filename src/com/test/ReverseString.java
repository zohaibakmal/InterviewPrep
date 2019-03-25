package com.test;

public class ReverseString {
	
	char [] inputString;
	int j;
	String reversed;
	
	public String reverse (String input){
		j=input.length()-1;
		inputString = input.toCharArray();
		
		for (int i=0; i<input.length()/2; i++){
				swap(inputString, i, j--);
		}
		
		return inputString.toString();
	}


	public String reverseString (String input){
		int start = 0;
		int end =input.length()-1;
		char [] inputString = input.toCharArray();

		while(start<end){
			swap(inputString, start, end);
			start++;
			end--;
		}


		return inputString.toString();
	}
	
	public void reverseRecusivly(char [] input, int startIndex, int endIndex){
		
		if ((endIndex-startIndex)==1){
			reversed = input.toString();
			return;
		}
		
		else {
			swap(input, startIndex, endIndex-1);
			reverseRecusivly(input, ++startIndex, --endIndex);
		}
	}
	
	public void swap(char [] input, int sourceIndex, int destinationIndex){
		char temp = input[sourceIndex];
		input[sourceIndex] = input[destinationIndex];
		input[destinationIndex] = temp;
	}
	
	public static void main(String[] args){
		ReverseString t = new ReverseString();
		//System.out.println(t.inputString);		
		//t.reverse("123456789");
		//System.out.println(t.inputString);	
		t.reverseString("hello");
		System.out.println(t.reversed);
	}
}
