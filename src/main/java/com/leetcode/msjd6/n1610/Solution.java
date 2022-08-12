package com.leetcode.msjd6.n1610;

/**
 * @Author: Nic1
 * @Date: 2022/3/13 22:19
 * @Theme: 生存人数
 */
//方法：计算区间
class Solution {
    public static void main(String[] args) {
        int[] birth = new int[]{1900, 1901, 1902, 1949, 1949};
        int[] death = new int[]{1950, 1948, 1951, 1952, 1953};
        int i = new Solution().maxAliveYear(birth, death);
        System.out.println(i);
    }

    public int maxAliveYear(int[] birth, int[] death) {
        int max = 0;//记录当前最大值
        int min = 0;//记录下标
        int[] arr = new int[101];
        for (int i = 0; i < birth.length; i++) {
            for (int j = birth[i]; j <= death[i]; j++) {
                arr[j - 1900]++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                min = i;
            }
        }
        return min + 1900;
    }
}
