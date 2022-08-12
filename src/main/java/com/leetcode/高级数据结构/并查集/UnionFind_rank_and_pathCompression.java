package com.leetcode.高级数据结构.并查集;

/**
 * @Author: Nic1
 * @Date: 2022/7/30 14:29
 * @Theme: 并查集（基于按秩合并和路径压缩）
 */
public class UnionFind_rank_and_pathCompression {

    public static void main(String[] args) {
        UnionFind_rank_and_pathCompression dsu = new UnionFind_rank_and_pathCompression(6);
        dsu.union(1,2);
        dsu.union(2,3);
        dsu.union(3,4);
        dsu.union(4,5);
        dsu.find(2);
    }

    int root[];
    // 添加了 rank 数组来记录每个顶点的高度，也就是每个顶点的「秩」
    int rank[];

    public UnionFind_rank_and_pathCompression(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    // find方法（路径压缩）
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        //递归：x的根节点值 = x的根节点的根节点值
        return root[x] = find(root[x]);
    }

    // union方法（按秩合并）
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    };
}
