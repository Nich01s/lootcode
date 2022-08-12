package com.leetcode.test.n1;

import java.util.Arrays;

/**
 * @Author: Nic1
 * @Date: 2022/7/31 10:30
 * @Theme:
 */
class Solution {
    public int minimumOperations(int[] nums) {

        int k = 0;//记录操作次数
        while (!isAll0(nums)) {
            //选出当前数组中最小正整数
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    min = Math.min(min, nums[i]);
                }
            }
            //全部非0元素减去当前最小正整数
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    nums[i] -= min;
                }
            }
            k++;
        }
        return k;
    }

    //返回当前数组是否全为0
    public boolean isAll0(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
