
public class PlusOne {

	/*
	 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
	 *
	 * You may assume the integer do not contain any leading zero, except the number 0 itself.
	 * The digits are stored such that the most significant digit is at the head of the list.
	 *
	 * Time: O(n)
	 * */
    public int[] plusOne(int[] digits) {
        int length = digits.length - 1;
        while (length >= 0) {
        	//If there is a chance of a carry, we set the digit to 0 and let the else condition add 1 to the next.
            if (digits[length] == 9) {
                digits[length] = 0;
                length--;
            } else {
                digits[length]++;
                return digits;
            }
        }
        /*
         *	For cases when we need to add an extra digit to the front from the carries. 
         * */
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public int[] plusOne2(int[] digits) {
        int carry = 0;
        for (int i=digits.length-1; i>=0; i--){
            if (i==digits.length-1){
                if (digits[i]+1>9){
                    carry = 1;
                    digits[i] = 0;
                }else{
                    digits[i] =  digits[i] +1;
                    carry=0;
                    break;
                }
            }else{
                if (digits[i]+carry>9){
                    carry = 1;
                    digits[i] = 0;
                }else{
                    digits[i] = digits[i]+carry;
                    carry=0;
                    break;
                }
            }
        }

        if (carry!=0){
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }else{
            return digits;
        }
    }
	
}
