package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExclusiveTime {

    public int[] exclusiveTime(int n, List<String> logs) {
        int [] map = new int [n];
        Stack <Integer> stack = new Stack();
        String []parts2 = logs.get(0).split(":");
        int initId = Integer.parseInt(parts2[0]);
        stack.push(initId);
        int prevTime = 0;
        for (int i=1; i<logs.size();i++){
            String current = logs.get(i);
            String [] parts = current.split(":");

            int id = Integer.parseInt(parts[0]);
            int time = Integer.parseInt(parts[2]);

            if(parts[1].equals("start")){
                map[stack.peek()] += time-prevTime;
                stack.push(id);
                prevTime = time;
            }else{

                map[stack.peek()] += time-prevTime +1;
                stack.pop();
                prevTime = time+1;
            }

        }
        return map;
    }

    public static void main(String [] args){
        ExclusiveTime exclusiveTime = new ExclusiveTime();
        List <String> list = new ArrayList<>();
        list.add("0:start:0");
        list.add("1:start:2");
        list.add("0:end:6");
        list.add("0:end:6");
        exclusiveTime.exclusiveTime(2, list);

    }
}
