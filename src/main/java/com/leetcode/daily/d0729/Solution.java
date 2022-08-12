package com.leetcode.daily.d0729;

/**
 * @Author: Nic1
 * @Date: 2022/7/29 14:38
 * @Theme: 有效的正方形
 */
public class Solution {
    public static void main(String[] args) {
        int[] p1 = {0, 0};
        int[] p2 = {0, 0};
        int[] p3 = {0, 0};
        int[] p4 = {0, 0};
        boolean b = validSquare(p1, p2, p3, p4);
        System.out.println(b);
    }

    static int[][] points = new int[3][2];//第一个点为直角顶点

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (isIsoscelesAndRightTriangle(p1, p2, p3) && isIsoscelesAndRightTriangle(p1, p2, p4) && isIsoscelesAndRightTriangle(p1, p3, p4) && isIsoscelesAndRightTriangle(p2, p3, p4)) {
            return true;
        }
        return false;
    }

    //返回三个点是否构成等腰直角三角形
    public static boolean isIsoscelesAndRightTriangle(int[] point1, int[] point2, int[] point3) {
        //如果三条边中，有两条边长相等
        if (twoSideEqualLength(point1, point2, point3)) {
            //如果这三个点构成直角
            if (twoPointsDistance(points[0], points[1]) + twoPointsDistance(points[0], points[2]) == twoPointsDistance(points[1], points[2])) {
                return true;
            }
        }
        return false;
    }

    //判断三条边是否有两条边长相等，且长度不为0
    public static boolean twoSideEqualLength(int[] point1, int[] point2, int[] point3) {
        if (twoPointsDistance(point1, point2) == twoPointsDistance(point1, point3) && twoPointsDistance(point1, point2) != 0) {
            points[0] = point1;
            points[1] = point2;
            points[2] = point3;
            return true;
        }
        if (twoPointsDistance(point2, point1) == twoPointsDistance(point2, point3)&& twoPointsDistance(point2, point1) != 0) {
            points[0] = point2;
            points[1] = point1;
            points[2] = point3;
            return true;
        }
        if (twoPointsDistance(point3, point1) == twoPointsDistance(point3, point1)&& twoPointsDistance(point3, point1) != 0) {
            points[0] = point3;
            points[1] = point1;
            points[2] = point2;
            return true;
        }
        return false;
    }

    //计算两点间距离平方
    public static int twoPointsDistance(int[] point1, int[] point2) {
        return (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]);
    }
}
