package com.leetcode.hot100.n10;

/**
 * @Author: Nic1
 * @Date: 2022/2/8 21:39
 * @Theme: 正则表达式匹配
 */
//动态规划
/**
 * 状态转移方程：设dp[i][j]为s的前i个字符和p的前j个字符是否匹配:
 * Ⅰ、如果p[i-1]!="*": ①、如果s[i-1]!=p[j-1]则dp[i][j]=false ②、如果s[i-1]==p[j-1]则dp[i][j]=dp[i-1][j-1]
 * Ⅱ、如果p[i-1]=="*": ①、如果s[i-1]!=p[j-2]则dp[i][j]=dp[i][j-2] ②、如果s[i-1]=p[j-2]则dp[i][j]=dp[i][j-2]||dp[i-1][j]
 * 边界条件：dp[0][0]=true
 */
class Solution {
    public boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];//多出一个是用来记录空字符串的
        dp[0][0] = true;
        //以下构造dp数组，dp数组标志着s的前i个字符与p的前j个字符是否正则匹配（其中包括边界dp[0][0]）
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*') {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
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
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}