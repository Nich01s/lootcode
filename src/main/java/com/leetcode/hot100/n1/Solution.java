package com.leetcode.hot100.n1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Nic1
 * @Date: 2022/1/2 21:23
 * @Theme:
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }else {
                map.put(nums[i],i);
            }
        }
        return new int[0];
    }
}