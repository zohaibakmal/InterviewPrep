package com.test;

public class BestTimeToBuyAndSell2 {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        boolean hasStock = false;
        for(int i=0;i<prices.length;i++){
            if(!hasStock){
                if(shouldBuy(prices, i)){
                    totalProfit -= prices[i];
                    hasStock = true;
                }
            }else{
                if(shouldSell(prices, i)){
                    totalProfit+=prices[i];
                    hasStock = false;
                }
            }
        }
        return totalProfit;
    }

    private boolean shouldBuy(int [] prices, int currentDay){
        if(currentDay>=prices.length-1){
            return false;
        }else if(prices[currentDay]<prices[currentDay+1]){
            return true;
        }else{
            return false;
        }
    }

    private boolean shouldSell(int [] prices, int currentDay){
        if(currentDay>=prices.length-1){
            return true;
        }else if(prices[currentDay]<prices[currentDay+1]){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String [] args){
        BestTimeToBuyAndSell2 bestTimeToBuyAndSell2 = new BestTimeToBuyAndSell2();
        System.out.println((bestTimeToBuyAndSell2.maxProfit(new int[]{7,1,5,3,6,4})));
    }
}
