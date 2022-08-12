package com.leetcode.dp.n120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Nic1
 * @Date: 2022/3/16 21:06
 * @Theme: 三角形最小路径和
 */
//方法：dp
//状态转移方程：设dp[i][j]为第i层下标j的数的最小路径和
class Solution {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(-10)));
        //triangle.add(new ArrayList<>(Arrays.asList(3, 4)));
        //triangle.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        //triangle.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));

        int i = new Solution().minimumTotal(triangle);
        System.out.println(i);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[triangle.size()][];//数组每行长度不同
        //边界条件，沿三角形边都是边界条件
        dp[0] = new int[1];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            int[] tmp = new int[triangle.get(i).size()];//创建数组
            dp[i] = tmp;
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][triangle.get(i).size() - 1] = dp[i - 1][triangle.get(i - 1).size() - 1] + triangle.get(i).get(triangle.get(i).size() - 1);
        }
        //dp
        for (int i = 1; i < triangle.size(); i++) { //遍历行
            for (int j = 1; j < triangle.get(i).size() - 1; j++) { //遍历中间列
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        //遍历最后一行，获取最小路径和
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            min = Math.min(min, dp[triangle.size() - 1][i]);
        }
        return min;
    }
}
