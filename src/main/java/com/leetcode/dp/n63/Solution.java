package com.leetcode.dp.n63;

/**
 * @Author: Nic1
 * @Date: 2022/3/15 14:35
 * @Theme: 不同路径 II
 */
//方法：dp
//状态转移方程：
//设dp[i][j]为走到(i,j)坐标处一共有多少种路径
//则当obstacleGrid[i][j]==0时，dp[i][j] = dp[i-1][j]+dp[i][j-1]，当obstacleGrid[i][j]=1时，dp[i][j]=0
//边界条件：dp[0][0] = 1，dp[i][0] = 1,dp[0][j] = 1
class Solution {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0, 0, 0, 0}, {0, 0, 1, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {1, 0, 0, 0}};
        int i = new Solution().uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;//行数
        int n = obstacleGrid[0].length;//列数
        int[][] dp = new int[m][n];
        //构造边界条件
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                for (; i < m; i++) {
                    dp[i][0] = 0;
                }
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = 1;
            } else {
                for (; j < n; j++) {
                    dp[0][j] = 0;
                }
                break;
            }
        }
        //计算
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
