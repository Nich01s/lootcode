package com.leetcode.msjd6.n1616;

import java.util.Arrays;

/**
 * @Author: Nic1
 * @Date: 2022/3/12 21:44
 * @Theme: 部分排序
 */
//方法：上下坡法
class Solution {
    public static void main(String[] args) {
        int[] ints = new Solution().subSort(new int[]{});
        System.out.println(Arrays.toString(ints));
    }

    public int[] subSort(int[] array) {

        //从左向右遍历数组，判断当前array[i]是否比max小，是则将last置为当前下标，否则直接更新max————只要发现下坡就纪录下坡处下标值
        int last = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < max) {
                last = i;
            } else {
                max = array[i];
            }
        }

        //从右向左遍历数组，判断当前array[len-1-i]是否比min大，是则将first置为当前下标，否则直接更新min————只要发现上坡就记录上坡处下标值
        int first = array.length - 1;
        int min = Integer.MAX_VALUE;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > min) {
                first = i;
            } else {
                min = array[i];
            }
        }
        return (last == 0 && first == array.length - 1) ? new int[]{-1, -1} : new int[]{first, last};
    }
}
