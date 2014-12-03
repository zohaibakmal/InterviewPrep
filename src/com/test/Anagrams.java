package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

/*
 * Store strings as anagrams. 
 * Sort the string. That will become a key. Insert the actual string into a linked list
 * Return all values from the hashmap at the end.
 * */

public class Anagrams {

    public List<String> anagrams(String[] strs) {
        
		List <String> result = new LinkedList<String>();
		HashMap <String, List<String>> table = new HashMap <String, List<String>>();
		if (strs==null){
			 return result;
		}
		for (String curr:strs){
			char[] temp = curr.toCharArray();
			Arrays.sort(temp);
			String currCopy = new String(temp);
			if (table.get(currCopy)==null){
				List <String> list = new LinkedList<String>();
				list.add(curr);
				table.put(currCopy, list);
			}else{
				List <String> list = table.get(currCopy);
				list.add(curr);
				table.put(currCopy, list);
			}
		}

		
		for (List<String> list: table.values()){
		    if (list.size()>1)
			    result.addAll(list);
		}
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
