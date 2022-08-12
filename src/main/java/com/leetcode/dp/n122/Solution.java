package com.leetcode.dp.n122;

/**
 * @Author: Nic1
 * @Date: 2022/3/16 22:35
 * @Theme: 买卖股票的最佳时机 II
 */
//方法1:dp
//状态转移方程:设dp[i]为第i天能够获得的最大利润,则当prices[i]>prices[i-1]时 dp[i] = dp[i-1]+prices[i]-prices[i-1] else dp[i] = dp[i-1]
class Solution1 {
    public static void main(String[] args) {
        int i = new Solution1().maxProfit(new int[]{7, 6, 4, 3, 1});
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        //边界条件
        dp[0] = 0;
        //dp
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                dp[i] = dp[i - 1] + prices[i] - prices[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[prices.length - 1];
    }
}

//方法2:爬坡法,双指针
class Solution2 {
    public int maxProfit(int[] prices) {


        return 0;
    }
}
