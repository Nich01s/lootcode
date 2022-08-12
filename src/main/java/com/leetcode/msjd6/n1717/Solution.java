package com.leetcode.msjd6.n1717;


import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author: Nic1
 * @Date: 2022/2/23 0:03
 * @Theme: 多次搜索
 */
class Solution {
    public static void main(String[] args) {
        String big = "";//"mississippi";
        String[] smalls = new String[]{"a", "b", "c"};//new String[]{"is", "ppi", "hi", "sis", "i", "ssippi"};
        int[][] ints = new Solution().multiSearch(big, smalls);
        System.out.println(Arrays.toString(ints));
    }

    //定义字典树
    class Trie {
        boolean isLeaf;
        Trie[] childs;

        public Trie() {
            isLeaf = false;
            this.childs = new Trie[26];
        }
    }

    public int[][] multiSearch(String big, String[] smalls) {
        //if (big.length() == 0 || smalls.length == 0) {
        //    return new int[smalls.length][];
        //}
        List<List<Integer>> res = new ArrayList<>();
        LinkedHashMap<String, List<Integer>> linkedHashMap = new LinkedHashMap<>();//记录插入顺序的HashMap

        for (int i = 0; i < smalls.length; i++) {
            linkedHashMap.put(smalls[i], new ArrayList<Integer>());
        }

        //将smalls字符数组加入字典树
        Trie root = new Trie();
        for (int i = 0; i < smalls.length; i++) {
            Trie node = root;
            char[] c = smalls[i].toCharArray();
            for (int j = 0; j < c.length; j++) {
                if (node.childs[c[j] - 'a'] == null) {
                    node.childs[c[j] - 'a'] = new Trie();
                }
                node = node.childs[c[j] - 'a'];
            }
            node.isLeaf = true;
        }
        //使用big字符串的每个下标起始后缀，遍历字典树
        for (int i = 0; i < big.length(); i++) {
            String suffix = big.substring(i);
            List<Integer> list2 = isValued(root, suffix);
            if (!list2.isEmpty()) {
                for (int j = 0; j < list2.size(); j++) {
                    String str = suffix.substring(0, list2.get(j) + 1);
                    if (linkedHashMap.containsKey(str)) {
                        List<Integer> list = linkedHashMap.get(str);
                        list.add(i);
                        linkedHashMap.put(str, list);
                    }
                }
            }
        }
        for (String str : linkedHashMap.keySet()) {
            res.add(linkedHashMap.get(str));
        }
        int[][] arr = new int[smalls.length][];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = new int[res.get(i).size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                arr[i][j] = res.get(i).get(j);
            }
        }
        return arr;
    }

    //检测字符串是否符合字典树，返回符合字典树的结尾处下标
    public List<Integer> isValued(Trie node, String suffix) {//使用后缀遍历字典树，记j为遍历深度
        List<Integer> list = new ArrayList<>();
        int j = 0;
        while (j < suffix.length() && node.childs[suffix.charAt(j) - 'a'] != null) {
            if (node.childs[suffix.charAt(j) - 'a'].isLeaf) {
                list.add(j);
            }
            node = node.childs[suffix.charAt(j) - 'a'];
            j++;
        }
        return list;//只要j!=0就意味着当前big后缀的前缀满足部分字典树
    }
}
