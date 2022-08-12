package com.leetcode.高级数据结构.并查集.n684;

/**
 * @Author: Nic1
 * @Date: 2022/8/1 10:40
 * @Theme: 冗余连接
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] edges = new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] redundantConnection = s.findRedundantConnection(edges);
        System.out.println(redundantConnection);

    }

    public int[] findRedundantConnection(int[][] edges) {

        int size = edges.length;
        UnionFind uf = new UnionFind(size+1);//size+1，因为节点编号是从1开始的
        for (int i = 0; i < size; i++) {
            if (uf.find(edges[i][0]) == uf.find(edges[i][1])) {
                return new int[]{edges[i][0], edges[i][1]};
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return null;
    }
}

class UnionFind {

    int[] root;

    public UnionFind(int size) {
        root = new int[size];
        for (int i = 0; i < root.length; i++) {
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
