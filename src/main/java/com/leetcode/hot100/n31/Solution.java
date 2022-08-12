package com.leetcode.hot100.n31;

import java.util.Arrays;

/**
 * @Author: Nic1
 * @Date: 2022/2/9 21:23
 * @Theme: 下一个排列
 */

//从后向前找出第一个比当前数小的数，交换位置，然后将后面的数升序排列
class Solution {
    public static void main(String[] args) {
        int[] nums = {4, 2, 0, 2, 3, 2, 0};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void nextPermutation(int[] nums) {
        int maxJ = -1;
        int tempI = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (j > maxJ) {
                        maxJ = j;
                        tempI = i;
                    }
                }
            }
        }
        if (maxJ != tempI) {
            int temp = nums[maxJ];
            nums[maxJ] = nums[tempI];
            nums[tempI] = temp;
            Arrays.sort(nums, maxJ + 1, nums.length);
        } else {
            Arrays.sort(nums);
        }
    }
}
