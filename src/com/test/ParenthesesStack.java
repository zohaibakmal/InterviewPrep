package com.test;

import java.util.Stack;

public class ParenthesesStack {

	public boolean isValid(String s) {
	    if(s == null)
	        return true;

	    Stack<Character> stack = new Stack<>();
	    for(char c: s.toCharArray())
	        switch(c){
	        case '(': case '{': case '[':
	            stack.push(c); break;
	        case ')': 
	            if(stack.isEmpty() || stack.pop() != '(')
	                return false;
	            break;
	        case '}':
	            if(stack.isEmpty() || stack.pop() != '{')
	                return false;
	            break;
	        case ']':
	            if(stack.isEmpty() || stack.pop() != '[')
	                return false;
	        }
	    return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
