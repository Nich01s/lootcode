package com.leetcode.dp.n97;

/**
 * @Author: Nic1
 * @Date: 2022/3/16 14:28
 * @Theme: 交错字符串
 */
//方法：dp
//状态转移方程：设dp[i][j]为s3的前i+j个字符能否由s1的前i个字符和s2的前j个字符连接而成
class Solution {
    public static void main(String[] args) {
        boolean interleave = new Solution().isInterleave("", "", "");
        System.out.println(interleave);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        char[] ch3 = s3.toCharArray();
        if (l1 + l2 != l3) {
            return false;
        }
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        //边界条件
        dp[0][0] = true;
        for (int i = 1; i <= l1; i++) { //s3的前i个字符全部s1由构成
            if (s1.substring(0, i).equals(s3.substring(0, i))) {
                dp[i][0] = dp[i - 1][0] && ch1[i - 1] == ch3[i - 1];
            }
        }
        for (int i = 1; i <= l2; i++) { //s3的前i个字符全部s2由构成
            if (s2.substring(0, i).equals(s3.substring(0, i))) {
                dp[0][i] = dp[0][i - 1] && ch2[i - 1] == ch3[i - 1];
            }
        }
        //dp
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                dp[i][j] = (dp[i - 1][j] && ch3[i + j - 1] == ch1[i - 1]) || (dp[i][j - 1] && ch3[i + j - 1] == ch2[j - 1]);
            }
        }
        return dp[l1][l2];
    }
}