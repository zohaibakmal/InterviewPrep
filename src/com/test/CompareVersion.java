package com.test;

public class CompareVersion {

    /*
    * O(MAX(M,N));
    * Space (M+N)
    *
    * Special cases: We need to take into account cases such as 1.0 vs 1.0.0 etc
    * */
    public int compareVersion(String version1, String version2) {
        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");
        int result = 0;
        int i=0,j=0;
        while(i<v1.length || j<v2.length){
            int val1=0,val2=0;
            if(i<v1.length)
                val1 = Integer.parseInt(v1[i]);
            if(j<v2.length)
                val2 = Integer.parseInt(v2[j]);
            if(val1>val2)
            {
                result = 1;
                break;
            }
            else {
                if(val2 > val1){
                    result = -1;
                    break;}}
            i++;j++;
        }

        return result;
    }

    public static void main(String [] args){
        CompareVersion c = new CompareVersion();
        c.compareVersion("0.1", "1.1");
    }
}
