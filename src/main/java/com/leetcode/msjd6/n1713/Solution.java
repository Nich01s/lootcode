package com.leetcode.msjd6.n1713;

/**
 * @Author: Nic1
 * @Date: 2022/3/4 23:54
 * @Theme: 恢复空格
 */
//方法：dp+字典树

import java.util.Arrays;

/**
 * 状态转移方程：
 * 设dp[i]是前i个字符中的最少未识别字符量
 */
class Solution {
    public static void main(String[] args) {
        String[] dictionary = {"looked", "just", "like", "her", "brother"};//potimzz
        String sentence = "jesslookedjustliketimherbrother";//potimzzpotimzz
        int respace = new Solution().respace(dictionary, sentence);
        System.out.println(respace);
    }

    //定义字典树
    class Trie {
        Trie[] childs;
        boolean isLeaf;

        public Trie() {
            this.childs = new Trie[26];
        }
    }

    Trie root;

    public int respace(String[] dictionary, String sentence) {
        if (sentence == null || sentence.length() < 1) {
            return 0;
        }
        root = new Trie();
        //构建字典树
        for (int i = 0; i < dictionary.length; i++) {
            Trie node = root;
            for (int j = 0; j < dictionary[i].length(); j++) {
                if (node.childs[dictionary[i].charAt(j) - 'a'] == null) {
                    node.childs[dictionary[i].charAt(j) - 'a'] = new Trie();
                }
                node = node.childs[dictionary[i].charAt(j) - 'a'];
            }
            node.isLeaf = true;
        }
        //设dp[i]是前i个字符中的最少未识别字符量
        int[] dp = new int[sentence.length() + 1];
        dp[0] = 0;//边界条件
        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                String sub = sentence.substring(j, i);
                if (isValid(root, sub)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                } else {
                    dp[i] = Math.min(dp[i], dp[j] + i - j);
                }
            }
        }
        return dp[sentence.length()];
    }

    //检测当前字符是否在字典中
    public boolean isValid(Trie node, String str) {
        int j = 0;
        while (j < str.length() && node.childs[str.charAt(j) - 'a'] != null) {
            node = node.childs[str.charAt(j) - 'a'];
            j++;
        }
        return (j == str.length()) && node.isLeaf;
    }
}
