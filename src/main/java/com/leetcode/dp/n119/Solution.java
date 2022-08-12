package com.leetcode.dp.n119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Nic1
 * @Date: 2022/3/16 20:18
 * @Theme: 杨辉三角 II
 */
class Solution {
    public static void main(String[] args) {
        List<Integer> row = new Solution().getRow(1);
        System.out.println(row.toString());
    }

    public List<Integer> getRow(int rowIndex) {
        int[][] dp = new int[rowIndex + 1][];
        //边界条件
        dp[0] = new int[]{1};
        if (rowIndex == 0) {
            return new ArrayList<>(Arrays.asList(1));
        }
        dp[1] = new int[]{1, 1};
        for (int i = 2; i <= rowIndex; i++) {
            int[] temp = new int[dp[i - 1].length + 1];//每行数组都比前一行+1
            temp[0] = 1;//开头元素必为1
            for (int j = 1; j < temp.length - 1; j++) {
                temp[j] = dp[i - 1][j - 1] + dp[i - 1][j];//中间元素由上一行对应坐标元素求和所得
            }
            temp[temp.length - 1] = 1;//结尾元素必为1
            dp[i] = temp;//赋值
        }
        //dp转为二维数组
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < dp[rowIndex].length; j++) {
            list.add(dp[rowIndex][j]);
        }
        return list;
    }
}
