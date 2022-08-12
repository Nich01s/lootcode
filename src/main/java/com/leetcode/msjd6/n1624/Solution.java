package com.leetcode.msjd6.n1624;

import java.util.*;

/**
 * @Author: Nic1
 * @Date: 2022/3/11 23:04
 * @Theme: 数对和
 */
class Solution {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().pairSums(new int[]{1,10}, 11);
        System.out.println(lists);
    }

    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();//key为出现的数字,value为数字出现的次数
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != 0) {
                res.add(new ArrayList<>(Arrays.asList(nums[i], target - nums[i])));
                map.put(target - nums[i], map.get(target - nums[i]) - 1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return res;
    }
}
