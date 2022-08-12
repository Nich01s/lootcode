package com.leetcode.dp.n72;

/**
 * @Author: Nic1
 * @Date: 2022/3/15 16:16
 * @Theme: 编辑距离
 */
//方法:dp：
//状态转移方程：dp[i][j]为word1前i个字符串转成word2前j个字符串，使用的最少操作数
//边界条件：
class Solution {
    public static void main(String[] args) {
        int i = new Solution().minDistance("horse", "ros");
        System.out.println(i);
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        //边界条件
        dp[0][0] = 0;
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;//每一步都是删除操作
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;//每一步都是插入操作
        }
        //状态转移
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;//dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
