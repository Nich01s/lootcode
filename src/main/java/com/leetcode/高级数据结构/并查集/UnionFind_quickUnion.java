package com.leetcode.高级数据结构.并查集;

/**
 * @Author: Nic1
 * @Date: 2022/7/30 12:47
 * @Theme: 并查集（quick-union版本）
 */
public class UnionFind_quickUnion {

    public static void main(String[] args) {
        UnionFind_quickUnion qu = new UnionFind_quickUnion(10);
        qu.union(1, 2);
        qu.union(2, 5);
        qu.union(5, 6);
        qu.union(6, 7);
        qu.union(3, 8);
        qu.union(8, 9);
        System.out.println(qu.connected(1, 5)); // true
        System.out.println(qu.connected(5, 7)); // true
        System.out.println(qu.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        qu.union(9, 4);
        System.out.println(qu.connected(4, 9)); // true

    }

    //数组-（对于quickUnion版本的并查集，其root[]数组保存的是当前序号节点各自的父节点）
    int[] root;

    public UnionFind_quickUnion(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    //find方法，最坏复杂度：O(n)
    public int find(int x) {
        while (x != root[x]) {
            //通过每次返回的父节点的值循环搜寻
            x = root[x];
        }
        return x;
    }

    //union方法，复杂度：O(n)，因为调用了find方法，因此取决于find方法
    public void union(int x, int y) {
        int root_x = find(x);
        int root_y = find(y);
        if (root_x != root_y) {
            //将y节点的根节点的根节点值修改为x的根节点值
            root[root_y] = root_x;
        }
    }

    //两节点是否属同一个集合
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

}
