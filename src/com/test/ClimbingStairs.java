package com.test;

/**
 * Created by v652420 on 10/23/17.
 *
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.
 */
public class ClimbingStairs {

    /*
    * Simple Recursive Solution.
    *
    * Time Complexity: O(2^n). Size of tje recursion tree will ne 2^n
    *
    * Space Complexity: O(n). The depth of the recursion tree can go upto n.
    * */

    public int climbStairsBruteForce(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return climbStairsBruteForce(n-1) + climbStairsBruteForce(n-2);
    }



    /*
    * Uses memoization.
    * We keep track of result for ith computation. If ith computation is found, we return it.
    * Otherwise, we recurse and store the ith result.
    *
    * Time: O(n)
    * Space: O(n)
    * */
    public int climbStairs(int n) {
        int [] memo = new int[n];
        return climbStairs(n, memo);
    }

    private int climbStairs(int n, int [] memo){
        if(n==0){
            return 0;
        }
        if(n==1){
            memo[n-1] = 1;
        }
        if(n==2){
            memo[n-1] = 2;
        }
        if(memo[n-1]==0){
            memo[n-1] = climbStairs(n-1,memo) +  climbStairs(n-2,memo);
        }
        return memo[n-1];
    }




    public int memoRecursive (int n, int current ,int [] memo){
        if (current ==n){
            return 1;
        }
        if (current>n){
            return 0;
        }
        if (memo[current]>0){
            return memo[current];
        }
        memo[current] = memoRecursive(n, current+1, memo)+ memoRecursive(n, current+2, memo);
        return memo[current];
    }

    public int climbStairsMemo(int n) {
        int [] memo = new int[n+1];

        return memoRecursive(n,0, memo);
    }







    /*
    * As we can see this problem can be broken into subproblems, and it contains the optimal substructure property
    * i.e. its optimal solution can be constructed efficiently from optimal solutions of its subproblems,
    * we can use dynamic programming to solve this problem.
    *
    * One can reach step 'i'​​ in one of the two ways:
    *
    * 1. Taking a single step from (i-1) step
    * 2. Taking a step of 2 from (i-2) step
    *
    * So, the total number of ways to reach step i​​ is equal to
    * sum of ways of reaching (i-1)​th​ step and ways of reaching (i-2)th step
    *
    * Let dp[i] denote the number of ways to reach step i
    *
    * dp[i]=dp[i-1]+dp[i-2]
    *
    * Time Complexity = O(n). Single loop on n
    * Space Complexity = O(n). DP array of size n is used.
    * */
    public int climbStairsDP(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /*
    * In the above approach we have used dp array where dp[i]=dp[i-1]+dp[i-2]. It can be easily analysed that dp[i] is nothing but i​th​​ fibonacci number.
    *
    * Fib(n)=Fib(n-1)+Fib(n-2)
    *
    * Now we just have to find n​th​​ number of the fibonacci series having 1 and 2 their first and second term respectively i.e. Fib(1)=1 and Fib(2)=2.
    *
    * Time Complexity = O(n). Single loop on n
    * Space Complexity = O(1).
    * */

    public int climbStairsFib(int n){
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }





    public static void main(String [] args){
        ClimbingStairs c = new ClimbingStairs();

        System.out.println(c.climbStairsMemo(10));
    }

}
