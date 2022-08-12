package com.leetcode.高级数据结构.并查集.n721;

import java.util.*;

/**
 * @Author: Nic1
 * @Date: 2022/8/4 11:09
 * @Theme: 账户合并
 */
public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();
        Map<String, Integer> map1 = new HashMap<>();//邮箱地址—>编号
        Map<String, String> map2 = new HashMap<>();//邮箱地址—>账号
        int numOfEmail = 0;
        //记录两个Map
        for (int i = 0; i < size; i++) {
            List<String> list = accounts.get(i);//当前账户字符串
            String name = list.get(0);//当前账户名
            int size1 = list.size();
            for (int k = 1; k < size1; k++) {
                String email = list.get(k);
                if (!map1.containsKey(email)) {
                    map1.put(email, i);
                    map2.put(email, list.get(0));
                }
            }
        }
        // 合并操作：对所有邮箱地址对应的编号进行合并
        // 并查集大小就是编号数量
        UnionFind uf = new UnionFind(map1.size());
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstEmailIndex = map1.get(firstEmail);
            for (int i = 2; i < account.size(); i++) {
                String nextEmail = account.get(i);
                int nextEmailIndex = map1.get(nextEmail);
                uf.union(firstEmailIndex, nextEmailIndex);
            }
        }
        //定义[编号-邮箱地址集合]集合
        Map<Integer, List<String>> map = new HashMap<>();
        for (String email : map1.keySet()) {
            int index = uf.find(map1.get(email));//获取每个邮箱地址的根编号
            List<String> account = map.getOrDefault(index, new ArrayList<String>());
            //将当前邮箱地址加入其根编号对应的list集合中
            account.add(email);
            map.put(index, account);
        }
        List<List<String>> merged = new ArrayList<>();
        for (List<String> emails : map.values()) {
            Collections.sort(emails);
            String name = map2.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;
    }
}

class UnionFind {
    int[] root;

    public UnionFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    //find
    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    //union
    public void union(int x, int y) {
        int root_x = find(x);
        int root_y = find(y);
        if (root_x != root_y) {
            root[root_y] = root_x;
        }
    }
}
