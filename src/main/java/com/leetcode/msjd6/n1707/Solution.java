package com.leetcode.msjd6.n1707;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Nic1
 * @Date: 2022/3/9 22:54
 * @Theme: 婴儿名字
 */
//方法：并查集
class Solution {
    Map<String, String> parent;
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        parent = new HashMap<>();
        for (String name : names) {
            int i = name.indexOf("(");
            String s = name.substring(0, i);
            parent.put(s, s);//初始化
        }
        //合并
        for (String synonym : synonyms) {
            String[] s = synonym.split(",");
            String name1 = s[0].substring(1);
            String name2 = s[1].substring(0, s[1].length() - 1);
            if (!parent.containsKey(name1)) {
                parent.put(name1, name1);//初始化
            }
            if (!parent.containsKey(name2)) {
                parent.put(name2, name2);//初始化
            }
            String root1 = find(name1);
            String root2 = find(name2);
            if (!root1.equals(root2)) {//字典序小的作为根节点
                if (root1.compareTo(root2) < 0) {
                    parent.put(root2, root1);
                } else {
                    parent.put(root1, root2);
                }
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (String name : names) {
            int i = name.indexOf("(");
            String nAme = name.substring(0, i);
            int freq = Integer.parseInt(name.substring(i + 1, name.length() - 1));
            String root = find(nAme);//找到当前名称的根节点
            map.put(root, map.getOrDefault(root, 0) + freq);
        }
        String[] res = new String[map.size()];
        int k = 0;
        for (String name : map.keySet()) {
            res[k++] = name + "(" + map.get(name) + ")";
        }
        return res;
    }

    //查找
    public String find(String name) {
        //路径压缩
        while (!parent.get(name).equals(name)) {
            parent.put(name, parent.get(parent.get(name)));
            name = parent.get(name);
        }
        return name;
    }
}
