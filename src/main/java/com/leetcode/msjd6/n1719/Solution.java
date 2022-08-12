package com.leetcode.msjd6.n1719;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: Nic1
 * @Date: 2022/2/20 21:48
 * @Theme: 消失的两个数字
 */
//方法1：数学
class Solution1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};
        int[] ints = missingTwo(nums);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] missingTwo(int[] nums) {
        int N = nums.length + 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int sumTwo = (1 + N) * N / 2 - sum;//两数之和

        int limits = sumTwo / 2;
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= limits) {
                sum += nums[i];
            }
        }
        int one = limits * (limits + 1) / 2 - sum;
        return new int[]{one,sumTwo-one};
    }
}

//方法2：异或（对数组按类别进行分组）
class Solution2 {
    public int[] missingTwo(int[] nums) {



        return null;
    }
}
