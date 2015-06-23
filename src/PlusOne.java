
public class PlusOne {

	/*
	 * 
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
	
}
