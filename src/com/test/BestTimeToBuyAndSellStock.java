package com.test;

public class BestTimeToBuyAndSellStock {

    /*
    * Time: O(n^2)
    * Space: O(1)
    * */
    public int maxProfitBruteForce(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        for(int i=0; i<prices.length;i++){
            for (int j=i; j<prices.length;j++){
                maxProfit = Math.max(maxProfit, prices[j]-prices[i]);
            }
        }
        return Math.max(maxProfit,0);
    }


    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyMin = Integer.MAX_VALUE;
        for(int i: prices){
            if(i<buyMin){
                buyMin= i;
            }
            if((i-buyMin) >maxProfit){
                maxProfit= i-buyMin;
            }
        }
        return maxProfit;
    }

}
