package com.leetcode.msjd6.n1715;

import java.util.*;

/**
 * @Author: Nic1
 * @Date: 2022/3/4 23:52
 * @Theme: 最长单词
 */
//方法：长度凑整分组，分组内交换位置组合
class Solution {
    public String longestWord(String[] words) {

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) { //如果返回负整数则将o1排在o2签名 如果返回正整数则将
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);//String类的compareTo方法
                } else {
                    return Integer.compare(o2.length(), o1.length());
                }
            }
        });
        Set<String> set = new HashSet<String>(Arrays.asList(words));
        for (String word : words) {
            set.remove(word);//移除当前单词，set具有记忆性，因此越往后单词数量越少
            if (dfs(set, word)) {
                return word;
            }
        }
        return "";
    }

    //递归搜索
    public boolean dfs(Set<String> set, String word) {
        if (word.length() == 0) {
            return true;
        }
        for (int i = 0; i < word.length(); i++) {
            if (set.contains(word.substring(0, i + 1)) && dfs(set, word.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }
}
