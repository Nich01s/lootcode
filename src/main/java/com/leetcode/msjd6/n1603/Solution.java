package com.leetcode.msjd6.n1603;

/**
 * @Author: Nic1
 * @Date: 2022/3/15 13:49
 * @Theme: 交点
 */
class Solution {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        //x1 = start1[0]
        //x2 = start1[1]
        //y1 = end1[0]
        //y2 = end1[1]
        double k1 = 0;
        double b1 = 0;
        double k2 = 0;
        double b2 = 0;
        k1 = (double) (end1[0] - end1[1]) / (double) (start1[0] - start1[1]); //k1 = (y2-y1)/(x2-x1)
        b1 = (double) end1[0] - (double) (end1[1] - end1[0]) * start1[0] / (start1[1] - start1[0]);//b1 = y1 - (y2-y1)*x1/(x2-x1)
        k2 = (double) (end2[0] - end2[1]) / (double) (start2[0] - start2[1]);
        b2 = (double) end2[0] - (double) (end2[1] - end2[0]) * start2[0] / (start2[1] - start2[0]);
        if (k1 == k2 && b1 == b2) {
            if (start2[0] > start1[0]) {

            }
        }
        //计算交点坐标
        double x = (b2 - b1) / (k1 - k2);
        double y = k1 * x + b1;
        if (k1 != k2) {
            if (start1[0] >= x && start1[1] <= x) {//交点在区间内
                return new double[]{x, y};
            } else {
                return null;
            }
        }
        return null;
    }
}
