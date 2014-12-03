package com.test;

public class MissingIntegerInLargeFile {


	public static void missingInteger(){
		long numberOfInts = ((long) Integer.MAX_VALUE) +1;
		byte [] bitfield = new byte [(int) (numberOfInts/8)];
		System.out.println(2/8);
		System.out.println(2/8);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		missingInteger();

	}

}
