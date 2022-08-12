package com.leetcode.test.n2;

import java.util.Arrays;

/**
 * @Author: Nic1
 * @Date: 2022/7/31 10:54
 * @Theme:
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] grades = new int[]{10, 6, 12, 7, 3, 5};
        int i = s.maximumGroups(grades);
        System.out.println(i);

    }

    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int l = grades.length;
        int k = 1;//当前分组大小
        int m = 1;//当前总分组数
        while (m < l) {
            k++;//一个分组大小
            m += k;//当前分组数和
        }
        return m == l ? k : --k;
    }
}
