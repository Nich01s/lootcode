package com.leetcode.daily.n0809;

/**
 * @Author: Nic1
 * @Date: 2022/8/9 8:31
 * @Theme: 逐步求和得到正数的最小值
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 2};
        int i = s.minStartValue(nums);
        System.out.println(i);
    }

    public int minStartValue(int[] nums) {
        int sum = 0;
        int minSum = 0;//设置为0可返回nums数组全部是正数的结果
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            minSum = Math.min(minSum, sum);
        }
        return 1 - minSum;
    }
}
