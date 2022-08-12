package com.leetcode.test.n84.n2;

/**
 * @Author: Nic1
 * @Date: 2022/8/6 22:27
 * @Theme:
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        long l = s.countBadPairs(new int[]{4, 1, 3, 3});
        System.out.println(l);
    }

    public long countBadPairs(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int diff = nums[0];//每个位置下标与值之差
        int cnt = 0;
        // 每当出现一个下标与其差值之差不为diff时
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - i != diff) {
                cnt++;
            }
        }
        int k = nums.length - 1;
        int res = 1;
        for (int i = 0; i < cnt; i++) {
            res *= k;
        }
        return res;
    }
}
