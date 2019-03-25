package com.test;

public class ZipCar {

    public int findClosest(int [] input) throws Exception{

        if (input==null || input.length==0){
            throw new Exception("Must have a valid input");
        }

        int difference = Integer.MAX_VALUE;
        int value = 0;

        for(int item: input){
            int diff = 0-item; //-8
            diff = Math.abs(diff); //8
            if(difference>diff){
                difference = diff;
                value = item;
            }else if(diff==difference){
                value = Math.max(value, item);
            }
        }
        return value;
    }

    public static void main (String [] args){
        ZipCar car = new ZipCar();
        try {
            System.out.println(car.findClosest(new int[]{}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
