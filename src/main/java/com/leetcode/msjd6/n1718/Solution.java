package com.leetcode.msjd6.n1718;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Nic1
 * @Date: 2022/2/22 23:58
 * @Theme: 最短超串
 */
//方法：滑动窗口
class Solution {
    public static void main(String[] args) {

    }
    public int[] shortestSeq(int[] big, int[] small) {
        int l = 0;
        int r = 0;
        int[] res = new int[2];//记录结果
        int size = small.length;//当前缺少的个数
        Map<Integer, Integer> map = new HashMap<>();//map作为字典
        for (int i = 0; i < small.length; i++) {
            map.put(small[i], 1);
        }
        while (r < big.length) {
            while (size != 0 && r < big.length) {
                if (map.containsKey(big[r])) {
                    size--;
                }
                r++;
            }

        }
        return res;
    }
}
