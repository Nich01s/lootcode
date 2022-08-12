package com.leetcode.dp.n221;

/**
 * @Author: Nic1
 * @Date: 2022/3/17 15:18
 * @Theme: 最大正方形
 */
//方法:dp
//状态转移方程: 设dp[i][j]为以(i,j)为右下角的最大正方形边长,则当matrix[i][j]=0时,dp[i][j]=0,否则dp[i][j]= dp[i-1][j-1]延边的最短有效边长
class Solution {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'0', '1', '1', '1', '0', '1', '0', '0'},
                {'0', '1', '1', '1', '1', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '1', '1', '1', '0'},
                {'0', '1', '0', '1', '1', '1', '1', '1'}};//{'0', '1', '1', '1', '0', '1', '0', '0'}, {'0', '1', '1', '1', '1', '0', '0', '1'}, {'1', '1', '1', '1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '1', '1', '1', '0'}, {'0', '1', '0', '1', '1', '1', '1', '1'}
        int i = new Solution().maximalSquare(matrix);
        System.out.println(i);
    }

    public int maximalSquare(char[][] matrix) {
        int max = 0;//记录最大边长
        int[][] dp = new int[matrix.length][matrix[0].length];
        //边界条件
        max = 0;
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(max, dp[i][0]);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            max = Math.max(max, dp[0][j]);
        }
        //dp
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (dp[i - 1][j - 1] != 0) {
                        int minLen = 0;
                        int d = dp[i - 1][j - 1];
                        for (int k = 1; k <= d; k++) {
                            if (matrix[i - k][j] == '1' && matrix[i][j - k] == '1') {
                                minLen++;
                            } else {
                                break;
                            }
                        }
                        dp[i][j] = 1 + minLen;
                        max = Math.max(max, dp[i][j]);
                    } else {
                        dp[i][j] = 1;
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }
        return max * max;
    }
}
