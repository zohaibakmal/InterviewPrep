package com.test;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by v652420 on 10/20/17.
 *
 *
 *
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> map = new HashMap <Character, Character>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        int i=0;
        while (i<s.length()){
            if (s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else{
                if (stack.size()==0 || stack.pop()!=map.get(s.charAt(i))){
                    return false;
                }
            }

            i++;

        }
        return stack.size()==0;
    }


    public boolean isValid2(String s) {
        Stack <Character> stack = new Stack<Character>();
        for (int i=0; i<s.length(); i++){
            switch (s.charAt(i)){
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if (stack.isEmpty()){
                        return false;
                    }
                    char popped = stack.pop();
                    if (popped!=s.charAt(i)){
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
}
