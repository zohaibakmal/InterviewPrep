package com.test;

public class StrStrNeedleInHaystack {
    public int strStrBruteForce(String haystack, String needle) {
        if (needle.length()==0){
            return 0;
        }

        for (int i=0; i<haystack.length();i++){
            boolean found = true;
            if (haystack.charAt(i)==needle.charAt(0)){
                for (int j=1; j<needle.length() && (i+j) < haystack.length();j++){
                    if(haystack.charAt(i+j)!=needle.charAt(j)){
                        found=false;
                        break;
                    }
                }
                if (found && (i+needle.length()) <= haystack.length()){
                    return i;
                }
            }
        }

        return -1;
    }


}
