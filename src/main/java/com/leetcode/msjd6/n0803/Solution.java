package com.leetcode.msjd6.n0803;

/**
 * @Author: Nic1
 * @Date: 2022/8/9 20:43
 * @Theme: 魔术索引【给定的是有许数组】
 */
public class Solution {
    public int findMagicIndex(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            if (index == nums[index]) return index;
            else if (nums[index]>index) index = nums[index];
            else index++;
        }
        return -1;
    }
}
