package com.test;

import java.util.HashMap;

public class ReverseBits {

    HashMap <Byte, Integer>cache = new HashMap<Byte, Integer>();
    public int reverseBits(int n) {
    	//convert int to 4 bytes. 
        byte [] bytes = new byte[4];
        for (int i=0; i<4; i++){
            bytes [i] = (byte) (n>>>8*i & 0xFF);
        }
        int result=0;
        
        for (int i=0;i<4;i++){
            result += reverseBytes(bytes[i]);
            //shift result left by three 8 which is the length of the byte.
            if (i < 3)
            result <<= 8;
        }
        return result;
    }
    
    public int reverseBytes(byte b){
        Integer value = cache.get(b); // first look up from cache
        if (value != null)
            return value;
        value = 0;
        // reverse by bit
        for (int i = 0; i < 8; i++) {
            value += ((b >>> i) & 1);
            if (i < 7)
                value <<= 1;
        }
        cache.put(b, value);
        return value;
    }
    
}
