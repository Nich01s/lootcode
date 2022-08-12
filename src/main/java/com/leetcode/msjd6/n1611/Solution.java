package com.leetcode.msjd6.n1611;

import java.util.*;

/**
 * @Author: Nic1
 * @Date: 2022/3/4 23:22
 * @Theme: 跳水板
 */
class Solution {
    public static void main(String[] args) {
        int[] ints = new Solution().divingBoard(1, 2, 0);
        System.out.println(Arrays.toString(ints));
    }

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[]{};
        }
        //结果暗含排序且不重复，选择使用TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });//结果要求排序不重复
        for (int i = k; i >= 0; i--) {
            treeSet.add(shorter * i + longer * (k - i));
        }
        int[] res = new int[treeSet.size()];
        int i = 0;
        for (Iterator<Integer> iterator = treeSet.iterator(); iterator.hasNext(); ) {
            res[i] = iterator.next();
            i++;
        }
        return res;
    }
}
