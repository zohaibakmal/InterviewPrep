package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {

		if (intervals==null||intervals.size()<2){
			return intervals;
		}
		// sort intervals in ascending order
		Collections.sort(intervals, new ListComparator());
		
		// final result
		List<Interval> result = new ArrayList<Interval>();
		
		
		Interval previousInterval = intervals.get(0);
		for (int i=1; i<intervals.size();i++){
			Interval currentInterval = intervals.get(i);
			// if Previous Interval end is greater than current start, choose the max of previous and current interval ends
			if (previousInterval.end >= currentInterval.start){
				previousInterval.end = Math.max(currentInterval.end, previousInterval.end);
			}else{
				//otherwise, add previous interval.
				result.add(previousInterval);
				previousInterval = currentInterval;
			}
		}
		result.add(previousInterval);
		return result;

	}
}
class Interval {
	int start;
	int end;
	Interval() { start = 0; end =0; }
	Interval(int s, int e) { start = s; end = e; }
}

class ListComparator implements Comparator <Interval>{

	public int compare(Interval i1, Interval i2){
		return i1.start - i2.start;
	}

}


