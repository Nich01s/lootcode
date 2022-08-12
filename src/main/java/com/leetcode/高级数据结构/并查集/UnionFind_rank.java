package com.leetcode.高级数据结构.并查集;

/**
 * @Author: Nic1
 * @Date: 2022/7/30 13:09
 * @Theme: 并查集（按秩合并，秩:每个节点作为根节点所处的高度）
 */
public class UnionFind_rank {

    public static void main(String[] args) {
        UnionFind_rank dsuRank = new UnionFind_rank(10);
        // 1-2-5-6-7 3-8-9 4
        dsuRank.union(1, 2);
        dsuRank.union(2, 5);
        dsuRank.union(5, 6);
        dsuRank.union(6, 7);
        dsuRank.union(3, 8);
        dsuRank.union(8, 9);
        System.out.println(dsuRank.connected(1, 5)); // true
        System.out.println(dsuRank.connected(5, 7)); // true
        System.out.println(dsuRank.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        dsuRank.union(9, 4);
        System.out.println(dsuRank.connected(4, 9)); // true

    }

    int[] root;
    int[] rank;//记录每个节点的当前高度

    public UnionFind_rank(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    //find方法，最坏复杂度：O(n)
    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    //union方法，选择秩大的根节点作为union方法参数中两个节点的根节点
    public void union(int x, int y) {
        int root_x = find(x);
        int root_y = find(y);
        if (root_x != root_y) {
            if (rank[root_x] > rank[root_y]) {
                // 如果x的根节点的高度 > y的根节点的高度
                // 将y的根节点的根节点从自身修改为x的根节点
                root[root_y] = root_x;
            } else if (rank[root_x] < rank[root_y]) {
                // 如果y的根节点的高度大 > x的根节点的高度
                // 将x的根节点的根节点从自身修改为y的根节点
                root[root_y] = root_x;
            } else {
                // 如果x的根节点的高度 = y的根节点的高度
                // 将y的根节点的根节点从自身修改为x的根节点
                root[root_y] = root_x;
                //将x的根节点的高度+1
                rank[root_x] += 1;
            }
        }
    }


    //两节点是否属同一个集合
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

}
