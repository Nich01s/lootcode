package com.leetcode.msjd6.n1716;

/**
 * @Author: Nic1
 * @Date: 2022/3/2 22:38
 * @Theme: 按摩师
 */
//方法：动态规划
class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 4, 5, 3, 1, 1, 3};
        int massage = new Solution().massage(nums);
        System.out.println(massage);
    }

    public int massage(int[] nums) {
        int max = 0;
        if (nums.length == 0) {
            return max;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length == 1) {
            return dp[0];
        }
        dp[1] = nums[1];
        if (nums.length == 2) {
            return Math.max(dp[0], dp[1]);
        }
        dp[2] = nums[2] + nums[0];
        max = Math.max(dp[0], Math.max(dp[1], dp[2]));
        if (nums.length == 3) {
            return max;
        }
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
