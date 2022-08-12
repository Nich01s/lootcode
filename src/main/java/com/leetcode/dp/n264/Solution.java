package com.leetcode.dp.n264;

/**
 * @Author: Nic1
 * @Date: 2022/3/17 19:50
 * @Theme: 丑数 II
 */
//方法:dp
//状态转移方程:设dp[i]为第i个丑数,则dp[i]=min{dp[a]*2,dp[b]*3,dp[c]*5},其中一定有:c<b<a<i
//以上暗含条件:①dp[c-1]*5<dp[i]<dp[c+1]*5,②dp[b-1]*3<dp[i]<dp[b+1]*3,③dp[a-1]*2<dp[i]<dp[a+1]*2
class Solution {
    public static void main(String[] args) {
        int i = new Solution().nthUglyNumber(1);
        System.out.println(i);
    }

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        //定义3个指针
        int p2 = 0;//乘2的指针
        int p3 = 0;//乘3的指针
        int p5 = 0;//乘5的指针
        //边界条件
        dp[0] = 1;
        //dp
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i] == dp[p2] * 2) {
                p2++;
            }
            if (dp[i] == dp[p3] * 3) {
                p3++;
            }
            if (dp[i] == dp[p5] * 5) {
                p5++;
            }
        }
        return dp[n-1];
    }
}
