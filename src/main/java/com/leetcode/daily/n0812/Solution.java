package com.leetcode.daily.n0812;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Nic1
 * @Date: 2022/8/12 19:49
 * @Theme: 用户分组
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] groupSizes = new int[]{3, 3, 3, 3, 3, 1, 3};
        System.out.println(s.groupThePeople(groupSizes));
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<List<Integer>> ans = new ArrayList<>();
        //n+1的哈希表
        List[] hash = new ArrayList[n + 1];
        for (int i = 0; i < groupSizes.length; i++) {
            //哈希表的key
            int key = groupSizes[i];
            if (hash[key] == null) {
                hash[key] = new ArrayList();
            }
            //添加人
            hash[key].add(i);
            //组内人数和key相同 划分为一个组
            if (hash[key].size() == key) {
                ans.add(new ArrayList<>(hash[key]));
                hash[key].clear();
            }
        }
        return ans;
    }
}