package com.leetcode.dp.n174;

/**
 * @Author: Nic1
 * @Date: 2022/3/17 12:26
 * @Theme: 地下城游戏
 */
//方法:dp
//状态转移方程:设dp[i][j]为到坐标i,j处的所需的最低健康点数,则dp[i][j]=
class Solution {
    public static void main(String[] args) {
        int[][] dungeon = new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int i = new Solution().calculateMinimumHP(dungeon);
        System.out.println(i);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        //边界条件
        dp[0][0] = dungeon[0][0];
        for (int i = 1; i < dungeon.length; i++) {
            dp[i][0] = dp[i - 1][0] + dungeon[i][0];
        }
        for (int j = 1; j < dungeon[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + dungeon[0][j];
        }
        //dp
        for (int i = 1; i < dungeon.length; i++) {
            for (int j = 1; j < dungeon[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + dungeon[i][j];
            }
        }
        return 0;
    }
}
