package com.leetcode.daily.n0806;

import java.util.*;

/**
 * @Author: Nic1
 * @Date: 2022/8/6 11:34
 * @Theme: 数组中的字符串匹配
 */
public class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>(Arrays.asList(words));
        int size = list.size();
        //字符数组按长度进行排序
        Collections.sort(list, (o1, o2) -> o1.length() - o2.length());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (list.get(j).contains(list.get(i))) {
                    res.add(list.get(i));
                    break;
                }
            }
        }
        return res;
    }
}
