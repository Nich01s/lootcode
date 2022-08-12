package com.leetcode.dp.n343;

/**
 * @Author: Nic1
 * @Date: 2022/3/18 21:52
 * @Theme: 整数拆分
 */
//方法:dp
//状态转移方程:设dp[i]为正整数i拆分后的乘积最大值,则dp[i]=max{j*(i-j),j*dp[i-j]},其中j从1遍历到i-1
//边界条件:dp[0]=0,dp[1]=0
class Solution {
    public static void main(String[] args) {
        int i = new Solution().integerBreak(59);
        System.out.println(i);
    }

    public int integerBreak(int n) {

        int[] dp = new int[n + 1];
        //边界条件
        dp[0] = 0;
        dp[1] = 0;
        //dp
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) { //j为枚举截取第一段的长度
                max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
