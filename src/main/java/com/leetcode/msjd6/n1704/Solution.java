package com.leetcode.msjd6.n1704;

/**
 * @Author: Nic1
 * @Date: 2022/3/11 21:26
 * @Theme: 消失的数字
 */
class Solution {
    public static void main(String[] args) {
        int i = new Solution().missingNumber(new int[]{3, 0, 1});
        System.out.println(i);
    }

    public int missingNumber(int[] nums) {

        int[] arr = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = 1;
        }
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                index = i;
            }
        }
        return index;
    }
}
