package com.leetcode.hot100.n39;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Nic1
 * @Date: 2022/2/10 23:23
 * @Theme: 组合总和
 */
//dfs，注意如何剪枝，如对于[2，2，3]和[2，3，2]都满足的情况只能取其一
class Solution {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res, path, candidates, target, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int begin) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(res, path, candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
