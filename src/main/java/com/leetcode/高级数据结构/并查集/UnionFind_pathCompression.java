package com.leetcode.高级数据结构.并查集;

/**
 * @Author: Nic1
 * @Date: 2022/7/30 14:22
 * @Theme: 并查集（路径压缩，find方法递归）
 */
public class UnionFind_pathCompression {

    int[] root;

    public UnionFind_pathCompression(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    //find方法（递归完成路径压缩）
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

}
