package com.test;

public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
