package com.leetcode.msjd6.n1606;

import java.util.Arrays;

/**
 * @Author: Nic1
 * @Date: 2022/3/14 21:12
 * @Theme: 最小差
 */
//方法：双指针
    //溢出问题使用long代替int
class Solution {
    public static void main(String[] args) {
        int i = new Solution().smallestDifference(new int[]{-2147483648, 1}, new int[]{2147483647, 0});
        System.out.println(i);
    }

    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long min = Integer.MAX_VALUE;
        int up = 0;//指针
        int down = 0;//指针
        while (up < a.length || down < b.length) {
            while (up < a.length && a[up] < b[down]) {
                min = Math.min(min, Math.abs((long)a[up++] - (long)b[down]));
            }
            if (up == a.length) {
                break;
            }
            while (down < b.length && b[down] <= a[up]) {
                min = Math.min(min, Math.abs((long)b[down++] - (long)a[up]));
            }
            if (down == b.length) {
                break;
            }
        }
        return (int)min;
    }
}
