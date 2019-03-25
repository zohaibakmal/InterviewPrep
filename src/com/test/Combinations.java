package com.test;

/*
* Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

* */

import java.util.LinkedList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        combine(result, new LinkedList<Integer>(), 1, 0, n, k);
        return result;
    }

    public void combine (List<List<Integer>> result,List<Integer> current, int currentN, int length, int n, int k){
        if(length == k){
            result.add(new LinkedList(current));
            return;
        }
        for (int i=currentN; i<=n; i++){
            // for(int j=length;j<k; k++){
            current.add(i);
            combine(result, current, i+1, length+1, n, k);
            current.remove(current.size()-1);
            // }
        }
    }
}
