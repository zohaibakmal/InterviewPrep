package com.test;

public class DistinctSubsequences {

	private int numSubseq(String S, String T, int si, int ti) {  
		if (si<0 || ti<0 || si<ti) return 0;  

		if (S.charAt(si)==T.charAt(ti)) {  
			if (ti==0){  
				//move pointer of S backwards. Keep since ti has reached 0, 
				//we need to check the preceding elements of S
				return numSubseq(S, T, si-1, ti) + 1;
			}
			else  {
				//compare preceding elements of S with the current.
				//move both backwards and check preceding elements for both S and T
				return numSubseq(S, T, si-1, ti) + numSubseq(S, T, si-1, ti-1);
			}
		} 

		return numSubseq(S, T, si-1, ti);  
	}  

	public int numDistinct(String S, String T) {  
		return numSubseq(S, T, S.length()-1, T.length()-1);  
	}  



	public int numDistincts(String S, String T) {
		int[][] table = new int[S.length() + 1][T.length() + 1];

		//1 subsequence for "" in String S? 
		//0 subsequence for "" in String T
		//last is 0 is because those are full strings
		for (int i = 0; i < S.length(); i++){
			table[i][0] = 1;
		}

		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					table[i][j] += table[i - 1][j] + table[i - 1][j - 1];
				} else {
					table[i][j] += table[i - 1][j];
				}
			}
		}

		return table[S.length()][T.length()];
	}


	public static void main(String[] args) {
		DistinctSubsequences d = new DistinctSubsequences();
		System.out.println(d.numDistincts("abbc", "abc"));

		System.out.println(d.numDistinct("abbcc", "abc"));

	}

}
