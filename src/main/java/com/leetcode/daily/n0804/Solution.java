package com.leetcode.daily.n0804;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Nic1
 * @Date: 2022/8/4 10:35
 * @Theme:
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.minSubsequence(new int[]{1, 1});
    }

    public List<Integer> minSubsequence(int[] nums) {
        int size = nums.length;
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += nums[i];
        }
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int cur = 0;
        for (int i = size - 1; i >= 0; i--) {
            cur += nums[i];
            res.add(nums[i]);
            if (total-cur<cur){
                break;
            }
        }
        return res;
    }
}
