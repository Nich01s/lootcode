package com.leetcode.dp.n44;

/**
 * @Author: Nic1
 * @Date: 2022/4/11 10:41
 * @Theme: 通配符匹配
 */
//状态转移方程：设dp[i][j]为s的前i个字符是否能匹配p的前j个字符
class Solution {
    public boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*') {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else { //p的第j个字符为*，可以匹配任意字符串
                    if (matches(s, p, i, j - 1)) {

                    } else {

                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    //检查s的第i个字符是否与p的第j个字符匹配
    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '?') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}