package com.leetcode.dp.n213;

/**
 * @Author: Nic1
 * @Date: 2022/3/17 13:54
 * @Theme: 打家劫舍 II
 */
//方法:dp
//状态转移方程:第一个房屋和最后一个房屋不能同时被偷
class Solution {
    public static void main(String[] args) {
        int rob = new Solution().rob(new int[]{2, 3, 2});
        System.out.println(rob);
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }

        //1.在nums[1]~nums[nums.length-1]范围内偷窃
        int[] arr1 = new int[nums.length - 1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = nums[i + 1];
        }
        int i1 = maxAmount(arr1);

        //2.在nums[0]~nums[nums.length-2]范围内偷窃
        int[] arr2 = new int[nums.length - 1];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = nums[i];
        }
        int i2 = maxAmount(arr2);

        return Math.max(i1, i2);
    }

    //返回当前数组的可偷窃最高金额,很明显要么是以arr[arr.length-1]结尾,要么以arr[arr.length-2]结尾
    public int maxAmount(int[] arr) {
        int[] dp = new int[arr.length];
        //边界条件
        dp[0] = arr[0];
        dp[1] = arr[1];
        dp[2] = arr[2] + arr[0];
        //dp
        for (int i = 3; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + arr[i];
        }
        return Math.max(dp[arr.length - 1], dp[arr.length - 2]);
    }
}
