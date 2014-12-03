package com.test;

public class ChildNSteps {
	
	int countSteps(int n){
		
		if (n<0){
			return 0;
		}
		else if (n==0){
			return 1;
		}
				
		return countSteps(n-1) + countSteps(n-2)+ countSteps(n-3);
	}
	
	public static void main(String [] args){
		ChildNSteps c = new ChildNSteps();
		System.out.println(c.countSteps(3));
		
	}
}
