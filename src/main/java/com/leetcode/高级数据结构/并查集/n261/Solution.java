package com.leetcode.高级数据结构.并查集.n261;

/**
 * @Author: Nic1
 * @Date: 2022/8/1 10:06
 * @Theme: 以图判树
 */

/**
 * 每遍历一条边，将两个点相连，如果出现一个点还主动相连，就已经连在一起了，就说明图中有环
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 0}};
        boolean b = s.validTree(3, edges);
        System.out.println(b);
    }

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            uf.union(edges[i][0], edges[i][1]);
        }
        return uf.size == 1;
    }
}

class UnionFind {
    int[] parents;
    int size;

    public UnionFind(int n) {
        this.parents = new int[n];
        this.size = n;
        for (int i = 0; i < n; i++)
            parents[i] = i;
    }

    public void union(int i, int j) {
        int p1 = find(i);
        int p2 = find(j);
        if (p1 == p2) return;

        if (p1 < p2) {
            parents[p2] = p1;
        } else {
            parents[p1] = p2;
        }
        size--;
    }

    public int find(int i) {
        int p = i;
        while (p != parents[p]) {
            p = parents[p];
        }
        // 路径压缩
        while (parents[i] != p) {
            int t = parents[i];
            parents[i] = p;
            i = t;
        }
        return p;
    }
}