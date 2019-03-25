package com.test;

public class InsertionSort {

    public int [] sort (int [] input){

        int temp =0;
        for (int i=1; i<input.length; i++){
            for (int j=i; j>0 ; j--){
                if(input[j]<input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1]=temp;
                }
            }

        }
        return input;
    }

    public static void main(String [] args){
        InsertionSort i = new InsertionSort();

        int [] testArray = {10,34,2,56,7,67,88,42};
        int [] finalArray = i.sort(testArray);
        System.out.println(finalArray);
    }

}
