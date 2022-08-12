package com.leetcode.msjd6.n0804;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Nic1
 * @Date: 2022/8/9 21:49
 * @Theme: 幂集
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subsets(new int[]{1, 2, 3}));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(res, cur, nums, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> cur, int[] nums, int start) {
        res.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(res, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
