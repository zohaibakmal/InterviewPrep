package com.test;

public class StringToFloat {

	public static void getFloat(String input){
		float number = 0.0f;
		float pointIndex = input.indexOf(".")-1;
		float multiplier = (float) (1.0f * Math.pow(10, pointIndex));
		String [] inputString = input.split("\\.");
		
		float value = 0.0f;
		
		for (int i=0; i<inputString[0].length();i++){
			value = StringToFloat(inputString[0].charAt(i));
			number = number + (value%10)*multiplier;
			multiplier = multiplier/10;
		}
		
		for (int i=0; i<inputString[1].length();i++){
			value = StringToFloat(inputString[1].charAt(i));
			number = number + (value%10)*multiplier;
			multiplier = multiplier/10;
		}
		
		System.out.println("index of . =" + pointIndex);
		System.out.println("Value =" + number);
	}
	
	public static float StringToFloat(char input){
		switch(input){
		case '0':
			return 0.0f;
		case '1':
			return 1.0f;
		case '2':
			return 2.0f;
		case '3':
			return 3.0f;
		case '4':
			return 4.0f;
		case '5':
			return 5.0f;
		case '6':
			return 6.0f;
		case '7':
			return 7.0f;
		case '8':
			return 8.0f;
		case '9':
			return 9.0f;		
		default:
			return -1.0f;	
		}
				
	}
	
	public static void main(String[] args) {
	
		getFloat("345.00");

	}

}
