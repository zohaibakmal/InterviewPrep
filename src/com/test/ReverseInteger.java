package com.test;

public class ReverseInteger {

/*	public static int reverse(int x) {
		int reverse=0;
		int x_copy = x;
		int multiplier = 1;

		while (Math.abs(x)>0){
			reverse = reverse * 10 ;
			reverse = reverse + Math.abs(x)%10;
			x = x/10;
			multiplier = multiplier *10;
		}
		if (x_copy*(-1)>0){
			reverse = -1* reverse;
		}
		return reverse;

	}*/
	
	public int reverse(int x) {
        boolean isNegative = false;
        if (x * (-1)>0){
            isNegative = true;
            x = Math.abs(x);
        }
        
        int result = 0;
        boolean first = true;
        while (x>0){
            if (result > Integer.MAX_VALUE/10)
                return 0;
            result = result*10;
            result += x%10;
            x= x/10;
        }
        if (isNegative){
            result = result* (-1);
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(reverse(1534236469));
	}

}
