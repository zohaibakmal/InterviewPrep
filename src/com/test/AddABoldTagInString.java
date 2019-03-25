package com.test;

import java.util.*;

/*
*

Given a string s and a list of strings dict, you need to add a closed pair of bold tag
<b> and </b> to wrap the substrings in s that exist in dict.

If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag.
Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.

Example 1:
Input:
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"


Example 2:
Input:
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"
Note:
The given dict won't contain duplicates, and its length won't exceed 100.
All the strings in input have length in range [1, 1000].
*
* */

public class AddABoldTagInString {
    public String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = new ArrayList<>();
        for (String str : dict) {
            int index = -1;
            index = s.indexOf(str, index);
            while (index != -1) {
                intervals.add(new Interval(index, index + str.length()));
                index +=1;
                index = s.indexOf(str, index);
            }
        }
        System.out.println(Arrays.toString(intervals.toArray()));
        intervals = merge(intervals);
        System.out.println(Arrays.toString(intervals.toArray()));
        int prev = 0;
        StringBuilder sb = new StringBuilder();
        for (Interval interval : intervals) {
            sb.append(s.substring(prev, interval.start));
            sb.append("<b>");
            sb.append(s.substring(interval.start, interval.end));
            sb.append("</b>");
            prev = interval.end;
        }
        if (prev < s.length()) {
            sb.append(s.substring(prev));
        }
        return sb.toString();
    }

    class Interval {
        int start, end;
        public Interval(int s, int e) {
            start = s;
            end = e;
        }

        public String toString() {
            return "[" + start + ", " + end + "]" ;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new ArrayList<>();
        for (Interval i : intervals) {
            if (i.start <= end) {
                end = Math.max(end, i.end);
            } else {
                res.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }




    /*
    *
    * Let's try to learn which letters end up bold, since the resulting answer will just be the canonical one.
    * We put bold tags around each group of bold letters.
    * To do this, we maintain a boolean array and mark each bold character.
    * */

    public String addBoldTag2(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for(String substr : dict) {
            int start=0;
            while(start >= 0) {
                start = s.indexOf(substr,start);
                if(start<0) break;
                int end = start+substr.length();
                for(int i=start; i<end; i++) {
                    bold[i]=true;
                }
                start++; // Just start from next index, instead of iterating through entire string
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(bold[i] && (i-1<0 || !bold[i-1])) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i)); // Just go character by character rather than cutting up the string
            if(bold[i] && (i+1==s.length() || !bold[i+1])) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
}
