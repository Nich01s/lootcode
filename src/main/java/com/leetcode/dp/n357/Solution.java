package com.leetcode.dp.n357;

import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: Nic1
 * @Date: 2022/3/19 21:54
 * @Theme: 计算各个位数不同的数字个数
 */
//方法:dp
//状态转移方程:设dp[i]为长度为i位的整数各位不同数字个数,则dp[i]=9*9*8*7*...,最后将结果相加即可得出答案
class Solution {
    public static void main(String[] args) {
        int i = new Solution().countNumbersWithUniqueDigits(12);
        System.out.println(i);
    }

    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; //10^0
        if (n == 0) {
            return 1;
        }
        dp[1] = 9;//10^1  第一位数字不能是0
        if (n == 1) {
            return 10;
        }
        dp[2] = 9 * 9;
        int res = dp[0] + dp[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * (10 - i + 1);
            res += dp[i];
        }
        return res;
    }
}
