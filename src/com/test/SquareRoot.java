package com.test;

public class SquareRoot {

	public int sqrt(int x) {
		if(x == 0 || x == 1){
			return x;
		}
		int l = 1, r = x, res=0;
		while(l <= r){
			int m = (l + r)/2;
			if(m == x / m){ 
				return m;
			}else if(m > x / m){
				r = m - 1;
			}else{
				l = m + 1;
				res = m;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
