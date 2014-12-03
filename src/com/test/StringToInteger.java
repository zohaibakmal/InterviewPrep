package com.test;

public class StringToInteger {

	public static int atoi(String str) {
	    int sign = 1, value=0, i=0;
		str = str.trim(); // remove whitespaces
		if (str.length()==0){
		    return value;
		}
		if (str.charAt(0)=='-'){
			sign = -1;
			str = str.substring(1);
		}else if(str.charAt(0)=='+'){
		    //sign = -1;
			str = str.substring(1);
		}
		while (str.length()>i&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
			if (value>Integer.MAX_VALUE/10 || (value==Integer.MAX_VALUE/10 && str.charAt(i)-'0'>=8)){ //takes care of overflow
				if (sign==1)
					return Integer.MAX_VALUE;
				else 
					return Integer.MIN_VALUE;
			}
			value = 10 * value +(str.charAt(i++)-'0'); 
			//char's are actually of the same type / length as shorts. 
			//Now when you have a char that represents a ASCII/unicode digit (like '1'), 
			//and you subtract the smallest possible ASCII/unicode digit from it (e.g. '0'), 
			//then you'll be left with the digit's corresponding value (hence, 1)
		}
		return value * sign;
	}
	public static void main(String[] args) {
		System.out.println(atoi("1"));
		System.out.println("1".charAt(0));
	}

}
