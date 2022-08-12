package com.leetcode.msjd6.n1722;

import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author: Nic1
 * @Date: 2022/2/20 21:25
 * @Theme: 单词转换
 */
//方法：字典树+dfs
class Solution {
    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot"));
        List<String> ladders = new Solution().findLadders(beginWord, endWord, wordList);
        System.out.println(ladders);
    }

    boolean flag = false;

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null) {
            return null;
        }
        if (beginWord.length() != endWord.length()) {
            return null;
        }
        LinkedHashSet<String> path = new LinkedHashSet<>();//存放结果
        HashSet<String> set = new HashSet<>(wordList);//将字典加入HashSet
        if (!set.contains(endWord)) {
            return new ArrayList<>();
        }
        path.add(beginWord);
        for (int i = 0; i < beginWord.length(); i++) {
            StringBuffer sb = new StringBuffer(beginWord);
            for (int j = 0; j < 26; j++) {
                String s = sb.replace(i, i + 1, String.valueOf((char) ('a' + j))).toString();//将当前位置字符替换
                if (set.contains(s)) {
                    dfs(set, s, endWord, path);
                }
                if (flag) {
                    return new ArrayList<>(path);
                }
            }
        }
        return new ArrayList<>();
    }

    public void dfs(HashSet<String> set, String curStr, String endWord, LinkedHashSet<String> path) {
        if (!set.contains(curStr)) {
            return;
        }
        if (curStr.equals(endWord)) {
            path.add(curStr);
            flag = true;
            return;
        }
        path.add(curStr);
        for (int i = 0; i < curStr.length(); i++) {
            StringBuffer sb = new StringBuffer(curStr);
            for (int j = 0; j < 26; j++) {
                String s = sb.replace(i, i + 1, String.valueOf((char) ('a' + j))).toString();
                if (!path.contains(s)) {
                    dfs(set, s, endWord, path);
                }
                if (flag) {
                    break;
                }
            }
            if (i == curStr.length() - 1 || flag) {
                break;
            }
        }
    }
}
