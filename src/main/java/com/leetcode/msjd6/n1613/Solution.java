package com.leetcode.msjd6.n1613;

import java.util.Arrays;

/**
 * @Author: Nic1
 * @Date: 2022/3/13 14:45
 * @Theme: 平分正方形
 */
//直线为通过两个正方形的中心形成的直线
class Solution {
    public static void main(String[] args) {
        int[] square1 = new int[]{-176, -235, 338};
        int[] square2 = new int[]{-2, 66, 110};
        double[] doubles = new Solution().cutSquares(square1, square2);
        System.out.println(Arrays.toString(doubles));
    }

    public double[] cutSquares(int[] square1, int[] square2) {
        //计算正方形1的中心坐标
        double x1 = (double) (square1[0] + square1[2] / 2.0);
        double y1 = (double) (square1[1] + square1[2] / 2.0);
        //计算正方形2的中心坐标
        double x2 = (double) (square2[0] + square2[2] / 2.0);
        double y2 = (double) (square2[1] + square2[2] / 2.0);
        if (x1 == x2) {
            //直线为：x=常数
            return new double[]{x1, Math.min(square1[1], square2[1]), x1, Math.max(square1[1] + square1[2], square2[1] + square2[2])};
        }
        if (y1 == y2) {
            //直线为：y=常数
            return new double[]{Math.min(square1[0], square2[0]), y1, Math.max(square1[0] + square1[2], square2[0] + square2[2]), y1};
        }
        //计算通过两个中心点的直线，用(k,b)表示
        double k = (y2 - y1) / (x2 - x1);
        double b = y1 - k * x1;
        //计算通过两个正方形的端点
        if (k > 1 || k < -1) { //上下边相交
            double m = (Math.min(square1[1], square2[1]) - b) / k;//确保x1<x2
            double n = Math.max(square1[1] + square1[2], square2[1] + square2[2]);
            double o = (Math.min(square1[1], square2[1]) - b) / k;
            double p = Math.min(square1[1], square2[1]);
            return new double[]{m, n, o, p};
        } else { //左右边相交
            double m = Math.min(square1[0], square2[0]);
            double n = k * Math.min(square1[0], square2[0]) + b;
            double o = Math.max(square1[0] + square1[2], square2[0] + square2[2]);
            double p = k * Math.max(square1[0] + square1[2], square2[0] + square2[2]) + b;
            return new double[]{m, n, o, p};
        }
    }
}
