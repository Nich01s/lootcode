package com.leetcode.dp.n118;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Nic1
 * @Date: 2022/3/16 19:50
 * @Theme: 杨辉三角
 */
//方法：dp
//状态转移方程：设dp[i]为第i行数组，则dp[i] =
class Solution {
    public static void main(String[] args) {
        List<List<Integer>> generate = new Solution().generate(30);
        System.out.println(generate.toString());
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] dp = new int[numRows][];
        //边界条件
        dp[0] = new int[]{1};
        if (numRows == 1) {
            List<List<Integer>> tem = new ArrayList<>();
            tem.add(new ArrayList<>(Arrays.asList(1)));
            return tem;
        }
        dp[1] = new int[]{1, 1};
        for (int i = 2; i < numRows; i++) {
            int[] temp = new int[dp[i - 1].length + 1];//每行数组都比前一行+1
            temp[0] = 1;//开头元素必为1
            for (int j = 1; j < temp.length - 1; j++) {
                temp[j] = dp[i - 1][j - 1] + dp[i - 1][j];//中间元素由上一行对应坐标元素求和所得
            }
            temp[temp.length - 1] = 1;//结尾元素必为1
            dp[i] = temp;//赋值
        }
        //dp转为二维数组
        for (int i = 0; i < dp.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < dp[i].length; j++) {
                list.add(dp[i][j]);
            }
            res.add(list);
        }
        return res;
    }
}
