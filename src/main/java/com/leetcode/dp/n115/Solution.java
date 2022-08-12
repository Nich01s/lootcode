package com.leetcode.dp.n115;

/**
 * @Author: Nic1
 * @Date: 2022/3/16 19:01
 * @Theme: 不同的子序列
 */
//方法：dp
//状态转移方程：设dp[i][j]为s的前i个字符中子序列为t的前j个字符出现的次数
class Solution {
    public static void main(String[] args) {
        int i = new Solution().numDistinct("babgbag", "bag");
        System.out.println(i);
    }

    public int numDistinct(String s, String t) {

        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        //边界条件
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1; //s的前i个字符中t的前0个字符出现的个数为1
        }
        //dp
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (ch1[i - 1] != ch2[j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; //注意有两种情况：①s用了第i个字符进行匹配 ②s没有用第j个字符进行匹配 —— 反正是t的第j个字符一定被匹配了，但是不移一定用来了s的第i个字符与其匹配即使两者字符相同
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
