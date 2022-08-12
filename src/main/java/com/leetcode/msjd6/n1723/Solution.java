package com.leetcode.msjd6.n1723;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: Nic1
 * @Date: 2022/2/20 21:22
 * @Theme: 最大黑方阵（4条黑边）
 */
class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 0}, {
                 0, 1, 0, 1, 1, 0, 0, 0, 1, 1 }, {
                 0, 0, 1, 1, 0, 0, 1, 1, 1, 0 }, {
                 0, 1, 1, 1, 0, 1, 0, 0, 1, 0 }, {
                 1, 1, 0, 1, 1, 0, 1, 0, 0, 1 }, {
                 0, 1, 1, 0, 0, 0, 0, 1, 1, 0 }, {
                 1, 0, 0, 0, 0, 1, 1, 1, 1, 1 }, {
                 1, 0, 1, 0, 1, 0, 0, 0, 1, 0 }, {
                 1, 1, 1, 1, 0, 1, 0, 1, 0, 0 }, {
                 0, 0, 0, 0, 0, 0, 0, 1, 1, 0 }};
        //int[][] matrix = new int[][]{{0, 0, 0}, {0, 0, 1}, {0, 1, 1}};
        int[] square = findSquare(matrix);
        System.out.println(Arrays.toString(square));
    }

    public static int[] findSquare(int[][] matrix) {
        int len = matrix.length;
        int[] res = new int[3];//记录结果
        int max = 0;
        int[][] curCoorMaxSize = new int[len][len];
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (matrix[i][j] == 0) {
                    flag = true;
                    int L = j;//向左列号
                    int LSize = 0;
                    int D = i;//向下行号
                    int DSize = 0;
                    while (L < len && matrix[i][L] == 0) {
                        LSize++;
                        L++;
                    }
                    while (D < len && matrix[D][j] == 0) {
                        DSize++;
                        D++;
                    }
                    curCoorMaxSize[i][j] = Math.min(LSize, DSize);//当前坐标的最大Size
                }
            }
        }
        if (!flag) {
            return new int[]{};
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (curCoorMaxSize[i][j] != 0) {
                    for (int l = curCoorMaxSize[i][j]; l >= 1; l--) {
                        int a = 1;//获取当前坐标的最大size
                        while (a < l && matrix[i + l - 1][j + a] == 0 && matrix[i + a][j + l - 1] == 0) {
                            a++;
                        }
                        if (a == l && l > max) {
                            max = l;
                            res = new int[]{i, j, l};
                        }
                    }
                }
            }
        }
        return res;
    }
}
