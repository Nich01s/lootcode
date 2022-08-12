package com.leetcode.msjd6.n1617;

/**
 * @Author: Nic1
 * @Date: 2022/3/12 21:12
 * @Theme: 连续数列
 */
//方法1:dp
class Solution1 {
    public static void main(String[] args) {
        int i = new Solution1().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

//方法2：分治法
class Solution2 {
    public int maxSubArray(int[] nums) {



        return 0;
    }
}