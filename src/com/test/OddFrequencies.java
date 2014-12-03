package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Set;

public class OddFrequencies {

	
	public static ArrayList oddFreq(String [] input){
		
		ArrayList finalList = new ArrayList();
		HashMap <String,Integer> map = new HashMap<String,Integer>();
		
		for (int i=0; i<input.length; i++){
			if (map.containsKey(input[i])){
				int value = map.get(input[i]);
				map.put(input[i], value+1);
			}
			else {
				map.put(input[i],1);
			}
		}
		
		Iterator itr = map.entrySet().iterator();
		/*		
		while (itr.hasNext()){
			Map.Entry <String,Integer> pair = (Map.Entry<String,Integer>) itr.next();
			if (pair.getValue()%2==1){
				finalList.add(pair.getKey());
			}
		}
		*/
		for (String keys:map.keySet()){
			if (map.get(keys)%2==1){
				finalList.add(keys);
			}
		}
		
		return finalList;
		
	}
	
	public static void main(String[] args) {
		String[] input = {"1","1","1","2","2","2","3", "3"};
		System.out.print(oddFreq(input));

	}

}
