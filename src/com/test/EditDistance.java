package com.test;

public class EditDistance {

    public int minDistance(String word1, String word2) {

        int m=word1.length();
        int n=word2.length();
        
        int[][] matrix=new int[m+1][n+1];

        // when i or j=0 means empty string, the distance is the length of another string
        for (int i=0; i<m+1; i++){
            
            matrix[i][0]=i;
        }
        for (int j=0; j<n+1; j++){
            
            matrix[0][j]=j;
        }
        for(int i=1; i<m+1; i++){
            for (int j=1; j<n+1; j++){
                
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    
                     // current char in word1 is equal to char in word2, mean no change at this step.
                     //nums[i][j] is nums[i-1][j-1](mean the min times of change word1 to word2 without considering current chars)
                    matrix[i][j]=matrix[i-1][j-1];
                }
                else{
                     // nums[i-1][j-1] +1 is times of using  replacement at this step
                     // nums[i-1][j]+1 is times of using insert at this step
                     // nums[i][j-1]+1 is times of using delete at this step
                	int replace = matrix[i-1][j-1]+1;
    				int insert = matrix[i-1][j]+1;
    				int delete = matrix[i][j-1]+1;
                    matrix[i][j]=Math.min(replace, Math.min(insert, delete));
                }
            }
            
        }
        return matrix[m][n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
