package com.leetcode.daily.d0728;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Nic1
 * @Date: 2022/7/28 18:24
 * @Theme: 数组序号转换
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{40, 10, 20, 30};
        int[] res = arrayRankTransform(arr);
        System.out.println(res.toString());
    }

    public static int[] arrayRankTransform(int[] arr) {
        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i];
        }
        Arrays.sort(a);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], map.size() + 1);
            }
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}
