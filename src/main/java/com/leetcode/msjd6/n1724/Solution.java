package com.leetcode.msjd6.n1724;

import java.util.Arrays;

/**
 * @Author: Nic1
 * @Date: 2022/2/20 12:46
 * @Theme: 最大子矩阵
 */
//方法：二维前缀和（二维降一维再求一维最大前缀和）
class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{-4,-5}};
        int[] maxMatrix = new Solution().getMaxMatrix(matrix);
        System.out.println(Arrays.toString(maxMatrix));
    }

    public int[] getMaxMatrix(int[][] matrix) {
        int rowLen = matrix.length;//行数
        int colLen = matrix[0].length;//列数
        //计算每一列前缀和
        int[][] colPrefixSum = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (i > 0) {
                    colPrefixSum[i][j] = colPrefixSum[i - 1][j] + matrix[i][j];
                } else {
                    colPrefixSum[i][j] = matrix[i][j];
                }
            }
        }
        //计算列前缀和差分（此步骤实质上将二维降为一维）
        int[][][] colPrefixSumDiff = new int[rowLen][rowLen][colLen];//第一个索引为行1，第二个索引为行2，第三个索引为当前所在列
        int maxSubMatrixSum = Integer.MIN_VALUE;
        int[] res = new int[4];//记录结果坐标
        for (int i1 = 0; i1 < rowLen; i1++) {//当前基准行
            for (int i2 = 0; i2 <= i1; i2++) {//当前遍历行
                for (int j = 0; j < colLen; j++) {//当前所在列
                    if (i2 == 0) {
                        colPrefixSumDiff[i2][i1][j] = colPrefixSum[i1][j];
                    } else {
                        colPrefixSumDiff[i2][i1][j] = colPrefixSum[i1][j] - colPrefixSum[i2 - 1][j];//计算一维差分
                    }
                }
                int[] dp = new int[colLen];//记录当前行1与行2围成一维列数组的最大子序和
                //使用动态规划寻找
                dp[0] = colPrefixSumDiff[i2][i1][0];
                maxSubMatrixSum = Math.max(dp[0], maxSubMatrixSum);
                int beginJ = 0;
                for (int j = 1; j < colLen; j++) {
                    if (dp[j - 1] > 0) {
                        dp[j] = dp[j - 1] + colPrefixSumDiff[i2][i1][j];
                    } else {
                        dp[j] = colPrefixSumDiff[i2][i1][j];
                        beginJ = j;//记录起始列
                    }
                    if (dp[j] > maxSubMatrixSum) {
                        maxSubMatrixSum = dp[j];
                        res[0] = i2;//i2<i1
                        res[1] = beginJ;
                        res[2] = i1;
                        res[3] = j;
                    }
                }
            }

        }
        return res;
    }
}

