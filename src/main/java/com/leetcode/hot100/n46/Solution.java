package com.leetcode.hot100.n46;

import java.util.*;

/**
 * @Author: Nic1
 * @Date: 2022/2/19 22:00
 * @Theme: 全排列
 */
//方法：dfs+回溯
class Solution {
    public static void main(String[] args) {
        List<List<Integer>> permute = new Solution().permute(new int[]{1});
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();//记录结果
        List<Integer> path = new ArrayList<>();//记录当前路径
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        dfs(res, set, nums);
        return res;
    }

    public void dfs(List<List<Integer>> res, Set<Integer> set, int[] nums) {
        if (set.size() == nums.length) {
            res.add(new ArrayList<>(set));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                dfs(res, set, nums);
                set.remove(nums[i]);
            }
        }
    }
}
