package com.leetcode.msjd6.n1620;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Nic1
 * @Date: 2022/2/17 20:06
 * @Theme: T9键盘
 */
//方法：字典树
class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = nums.length;
        int[] ak = new int[nums.length + 1];
        ak[0] = 0;
        for (int i = 0; i < n; i++) {
            ak[i + 1] = ak[i] + nums[i];
        }
        System.out.println(Arrays.toString(ak));
    }

    //字典树
    class Trie {
        Trie[] childs;
        boolean isLeaf;

        public Trie() {
            this.childs = new Trie[26];
        }
    }

    Trie root;//字典树首节点（先构造再查询）

    public List<String> getValidT9Words(String num, String[] words) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        //构造字典树
        root = new Trie();
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


        return null;
    }

    public void dfs() {

    }

    //查询字典树
    public boolean[] isValid(String str) { //boolean[0]记录是否满足字典树,boolean[1]记录是否满足为叶子节点


        return null;
    }

}
