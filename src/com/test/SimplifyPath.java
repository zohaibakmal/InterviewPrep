package com.test;

import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        String [] parts = path.split("/");
        Stack<String> stack = new Stack();
        for(String item: parts){
            if(item.length()!=0){
                switch (item){
                    case "..":
                        if(stack.size()>0){
                            stack.pop();
                        }
                        break;
                    case ".":
                        break;
                    default:
                        stack.push(item);
                        break;
                }
            }
        }
        if(stack.size()==0){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for(String item: stack){
            sb.append("/"+item);
        }
        return sb.toString();
    }

    public static void main(String [] args){
        simplifyPath("/a/./b/../../c/");
    }
}
