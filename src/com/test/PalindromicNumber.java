package com.test;

public class PalindromicNumber {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        int reverse = reverse(x);
        if (reverse==x){
            return true;
        }else{
            return false;
        }
        
    }
    
    public int reverse(int x) {
        int result = 0;
        while (x>0){
            if (result > Integer.MAX_VALUE/10)
                return -1;
            result = result*10;
            result += x%10;
            x= x/10;
        }
        return result;
    }
}
