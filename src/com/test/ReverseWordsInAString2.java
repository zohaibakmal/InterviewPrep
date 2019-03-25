package com.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ReverseWordsInAString2 {
    public void reverseWords(char[] str) {
        Stack <List<Character>> stack = new Stack();
        int j = 0;
        while (j<str.length){
            List <Character> currentWord = new LinkedList();
            while(j<str.length && str[j]!=' ' ){
                currentWord.add(str[j]);
                j++;
            }
            stack.push(currentWord);
            j++;
        }
        j=0;
        while (!stack.isEmpty()){
            if(j!=0){
                str [j] = ' ';
                j++;
            }
            List <Character> currentWord = stack.pop();
            for(Character item:currentWord){
                str [j] = item;
                j++;
            }
        }
    }

    public static void main(String[] args){
        ReverseWordsInAString2 t = new ReverseWordsInAString2();
        //System.out.println(t.inputString);
        //t.reverse("123456789");
        //System.out.println(t.inputString);
        t.reverseWords(new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'});
    }
}
