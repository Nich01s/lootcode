package com.leetcode.msjd6.n0801;

/**
 * @Author: Nic1
 * @Date: 2022/7/31 20:10
 * @Theme:
 */

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 设n台阶的走法有dp[i]种，则
 * 状态转移方程：dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
 * 边界条件：dp[0] = 0, dp[1] = 1, dp[2] = 2, dp[3] = 4
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.waysToStep(1));
        System.out.println(s.waysToStep(2));
        System.out.println(s.waysToStep(3));
        System.out.println(s.waysToStep(1000000));
    }

    public int waysToStep(int n) {
        if (n <= 2) {
            return n;
        }
        long[] dp = new long[n + 1];
        //dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % (1000000000 + 7);
        }
        return (int) dp[n];
    }
}
