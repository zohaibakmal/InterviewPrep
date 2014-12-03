package com.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
 
public class ReadCVS {
 
  public static void main(String[] args) {
 
	ReadCVS obj = new ReadCVS();
	obj.run();
 
  }
 
  public void run() {
 
	String csvFile = "E:/WorkSpace/workspace/InterviewPrep/TestFile.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
	HashSet<String> set = new HashSet<String>();
	HashMap<String, String> map = new HashMap <String, String>();
	try { 
		br = new BufferedReader (new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			String[] stringExtracted = line.split(cvsSplitBy);
			for (int i=0; i<stringExtracted.length; i++){
				set.add(stringExtracted[i]);
				map.put(stringExtracted[i], null);
			}
			System.out.println("StringExtracted: " + set);
 
		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
	System.out.println("Done");
  }
}
