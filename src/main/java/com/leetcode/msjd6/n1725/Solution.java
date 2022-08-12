package com.leetcode.msjd6.n1725;

import java.util.*;

/**
 * @Author: Nic1
 * @Date: 2022/2/16 16:01
 * @Theme: 单词矩阵
 */
//方法：回溯+字典树
class Solution {

    class Trie {
        Trie[] childs;
        boolean isLeaf;//是否是结尾
        public Trie() {
            childs = new Trie[26];
        }
    }

    Trie root;//首节点不存储
    Map<Integer, Set<String>> map;
    int maxArea;
    int maxLength;
    List<String> ans;//记录结果

    public String[] maxRectangle(String[] words) {
        root = new Trie();
        //构造字典树
        for (String str : words) {
            Trie node = root;
            for (char c : str.toCharArray()) {
                if (node.childs[c - 'a'] == null) {
                    node.childs[c - 'a'] = new Trie();
                }
                node = node.childs[c - 'a'];
            }
            node.isLeaf = true;
        }
        map = new HashMap<>();
        ans = new ArrayList<>();
        maxArea = 0;
        maxLength = 0;
        //给不同长度的单词进行分类
        for (String w : words) {
            int len = w.length();
            maxLength = Math.max(maxLength, len);
            Set<String> set = map.getOrDefault(len, new HashSet<>());//有就获取没就创建一个
            set.add(w);
            map.put(len, set);
        }
        List<String> path = new ArrayList<>();
        for (int key : map.keySet()) {
            path.clear();
            //回溯，需要的参数有：当前长度单词长度，当前路径列表，当前长度单词集合
            dfs(map.get(key), path, key);
        }
        String[] ultimate = new String[ans.size()];
        return ans.toArray(ultimate);
    }

    //回溯（在相同长度单词中进行）
    public void dfs(Set<String> dic, List<String> path, int wordLen) {
        if (wordLen * maxLength <= maxArea) { //剪枝
            return;
        }
        if (path.size() > maxLength) {//终止
            return;
        }
        for (String str : dic) {
            //做选择
            path.add(str);
            boolean[] res = isValid(path);//判断当前path是否有效
            if (res[0]) {//如果暂时满足，继续向path中继续添加单词
                int area = path.size() * path.get(0).length();
                if (res[1] && (area > maxArea)) {
                    maxArea = area;
                    ans = new ArrayList<>(path);//加入结果集
                }
                dfs(dic, path, wordLen);//回溯
            }
            path.remove(path.size() - 1);//撤销选择
        }
    }

    //判断当前path是否有效
    public boolean[] isValid(List<String> input) { //横向一定满足字典树，因此要对纵向是否满足字典树进行验证
        boolean[] res = new boolean[2];//boolean[0]记录是否满足字段树，boolean[1]记录是否满足叶子节点
        boolean allLeaf = true;//记录是否满足叶子节点
        for (int i = 0; i < input.get(0).length(); i++) {
            Trie node = root;//构造字典树
            for (int j = 0; j < input.size(); j++) {
                int c = input.get(j).charAt(i) - 'a';
                if (node.childs[c] == null) {
                    return new boolean[]{false, false};
                }
                node = node.childs[c];
            }
            if (!node.isLeaf) {
                allLeaf = false;//满足条件但结尾不是叶子节点
            }
        }
        return new boolean[]{true, allLeaf};
    }
}
