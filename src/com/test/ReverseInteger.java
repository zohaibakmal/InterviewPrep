package com.test;

public class ReverseInteger {

    /*
    * Time: O(log n)
    * */
	public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0){
            isNegative = true;
            x = Math.abs(x);
        }

        int reverse=0;

        while (x>0){
            if (reverse > Integer.MAX_VALUE/10){
                return 0;
            }
            reverse = reverse*10;
            reverse = reverse+x%10;
            x = x/10;
        }
        if (isNegative){
            reverse = reverse*-1;
        }
        return reverse;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(reverse(1534236469));
	}

}
