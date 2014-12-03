package com.test;

public class MultiplicationTable {

	public void printTable(int input){
		
		for (int i=1; i<=12; i++){
			System.out.print(input*i + " ");
		}
		System.out.println();
		
	}
	
	public void printGrid (){
		for (int i=1; i<=12; i++){
			printTable(i);
		}
	}
	
	public static void main(String[] args) {
	
		MultiplicationTable mt = new MultiplicationTable();
		mt.printGrid();
	}

}
