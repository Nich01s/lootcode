package com.leetcode.msjd6.n1705;

import java.util.*;

/**
 * @Author: Nic1
 * @Date: 2022/3/10 22:20
 * @Theme: 字母与数字
 */
class Solution {
    public static void main(String[] args) {
        String[] array = new String[]{};
        String[] longestSubarray = new Solution().findLongestSubarray(array);
        System.out.println(Arrays.toString(longestSubarray));
    }

    public String[] findLongestSubarray(String[] array) {
        if (array.length == 0) {
            return new String[]{};
        }
        int[] arr = new int[array.length];
        //字母为1，数组为-1
        for (int i = 0; i < array.length; i++) {
            int ch = array[i].charAt(0);
            if (ch < 48 || ch > 57) {//字母
                arr[i] = 1;
            } else {//数字
                arr[i] = -1;
            }
        }
        //计算前缀和
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        //前缀和中数字相等的区间字母和数字个数相等（左开右闭区间）
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prefix.length; i++) {
            if (!map.containsKey(prefix[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(prefix[i], list);
            } else {
                List<Integer> list = map.get(prefix[i]);
                list.add(i);
                map.put(prefix[i], list);//key为前缀和中出现的数字，value为出现过的下标的数组
            }
        }
        int startIndex = 0;
        int endIndex = 0;
        int maxLen = 0;
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() >= 2) {
                int len = list.get(list.size() - 1) - list.get(0);
                if (len > maxLen) {
                    maxLen = len;
                    startIndex = list.get(0) + 1;//左开
                    endIndex = list.get(list.size() - 1);//右闭
                }
            }
        }
        if (map.containsKey(0)) {
            List<Integer> list = map.get(0);
            int len = list.get(list.size() - 1) + 1;
            if (len >= maxLen) {
                maxLen = len;
                startIndex = 0;
                endIndex = list.get(list.size() - 1);
            }
        }
        String[] res = new String[maxLen];
        if (maxLen > 0) {
            int k = 0;
            for (int i = startIndex; i <= endIndex; i++) {
                res[k++] = array[i];
            }
        }
        return res;
    }
}
