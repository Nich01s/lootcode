package com.leetcode.msjd6.n1621;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: Nic1
 * @Date: 2022/3/11 23:41
 * @Theme: 交换和
 */
//方法：排序+二分查找
class Solution {
    public static void main(String[] args) {
        int[] array1 = new int[]{519, 886, 282, 382, 662, 4718, 258, 719, 494, 795};
        int[] array2 = new int[]{52, 20, 78, 50, 38, 96, 81, 20};
        int[] swapValues = new Solution().findSwapValues(array1, array2);
        System.out.println(Arrays.toString(swapValues));
    }

    public int[] findSwapValues(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int sum1 = 0;
        int sum2 = 0;
        for (int i : array1) {
            sum1 += i;
        }
        for (int i : array2) {
            sum2 += i;
        }
        int diff = Math.abs(sum1 - sum2);
        if (diff % 2 == 1) {
            return new int[]{};
        }
        for (int i = 0; i < array1.length; i++) {
            int index = binSearch(array2, array1[i] + diff / 2, 0, array2.length - 1);
            if (index == -1) {
                index = binSearch(array2, array1[i] - diff / 2, 0, array2.length - 1);
            }
            if (index != -1) {
                return new int[]{array1[i], array2[index]};
            }
        }
        return new int[]{};
    }

    //二分查找
    public int binSearch(int[] array2, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array2[mid] == target) {
                return mid;
            } else if (array2[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
