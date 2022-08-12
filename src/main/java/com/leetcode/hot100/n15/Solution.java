package com.leetcode.hot100.n15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Nic1
 * @Date: 2022/2/8 22:24
 * @Theme: 三数之和
 */

class Solution {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();//存放结果
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);//排序
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return res;
        }
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {//去重
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int num = nums[i] + nums[l] + nums[r];
                if (num < 0) {
                    l++;
                } else if (num > 0) {
                    r--;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    //左右指针去重
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    l++;
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                }
            }

        }
        return res;
    }


    //手动排序
    //public static int[] sort(int[] nums) {
    //    for (int i = nums.length - 1; i >= 1; i--) {
    //        for (int j = 0; j < i; j++) {
    //            if (nums[j] > nums[j + 1]) {
    //                int temp = nums[j];
    //                nums[j] = nums[j + 1];
    //                nums[j + 1] = temp;
    //            }
    //        }
    //    }
    //    return nums;
    //}
}
