package com.test;

import java.util.ArrayList;
import java.util.List;

public class Parentheses {

	public List<String> generateParenthesis2(int n) {
		ArrayList <String> list = new ArrayList <String>();
		addParen(list, n, n, new StringBuilder());
		return list;
	}

	public void addParen(ArrayList<String> list, int leftRem, int rightRem, StringBuilder sb){

		if (leftRem < 0 || rightRem < leftRem ){
			return;
		}
		if (leftRem == 0 && rightRem == 0){
			list.add(sb.toString());
		}
		else{
			if (leftRem>0){
				sb.append('(');
				addParen(list, leftRem - 1, rightRem, sb);
				sb.deleteCharAt(sb.length()-1);
			}

			if (rightRem > leftRem){
				sb.append(')');
				addParen(list, leftRem, rightRem - 1, sb);
				sb.deleteCharAt(sb.length()-1);
			}
		}
	}






	/*
	* Our complexity analysis rests on understanding how many elements there are in generateParenthesis(n).
	* This analysis is outside the scope of this article, but it turns out this is the n-th Catalan number 1/n+1 (2n choose n	)
	* This is bounded asymptotically by 4^n/(n*√​n)
	*
	* Time Complexity : O(4^n/​√n). Each valid sequence has at most n steps during the backtracking procedure.
	*
	* Space Complexity : O(4^n/​√n) and uses O(n) space to store the sequence.
	*
	* */
	public List<String> generateParenthesis(int n) {
		ArrayList <String> list = new ArrayList <String>();
		addParen(list, n, n, "");
		return list;
	}

	public void addParen(ArrayList<String> list, int leftRem, int rightRem, String curr){

		if (leftRem < 0 || rightRem < leftRem ){
			return;
		}
		if (leftRem == 0 && rightRem == 0){
			list.add(curr);
		}
		else{
			if (leftRem>0){
				addParen(list, leftRem - 1, rightRem, curr+'(');
			}

			if (rightRem > leftRem){
				addParen(list, leftRem, rightRem - 1, curr+')');
			}
		}
	}

	public static void main(String[] args) {
		Parentheses p = new Parentheses();
		System.out.println(p.generateParenthesis(2));
	}

}
