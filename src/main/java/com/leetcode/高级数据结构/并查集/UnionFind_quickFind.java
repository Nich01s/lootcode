package com.leetcode.高级数据结构.并查集;

/**
 * @Author: Nic1
 * @Date: 2022/7/30 10:28
 * @Theme: 并查集（quick-find版本）
 */
public class UnionFind_quickFind {

    public static void main(String[] args) {
        UnionFind_quickFind qf = new UnionFind_quickFind(10);
        // 1-2-5-6-7 4 3-8-9
        qf.union(1,2);
        qf.union(2,5);
        qf.union(5,6);
        qf.union(6,7);
        qf.union(3,8);
        qf.union(8,9);
        System.out.println(qf.connected(1,5));
        System.out.println(qf.connected(5,7));
        System.out.println(qf.connected(4,9));
        qf.union(9,4);
        System.out.println(qf.connected(4,9));
        //

    }

    //数组-（对于quickFind版本的并查集，其root[]数组保存的是当前序号节点各自最终的根节点）
    int[] root;

    public UnionFind_quickFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            //初始化数组，每个元素的根节点为自己
            root[i] = i;
        }
    }

    //find方法-找到指定节点的根节点，复杂度：O(1)
    public int find(int x) {
        return root[x];
    }

    //union方法-合并两个节点使其根节点保持一致（不同集合的两个节点不能调用此方法，即不能被合并），复杂度：O(n)
    public void union(int x, int y) {
        int root_x = find(x);
        int root_y = find(y);
        //如果序号x节点的根节点与序号y节点的根节点不一致
        if (root_x != root_y) {
            //遍历root数组（每次都要完整遍历一遍）
            for (int i = 0; i < root.length; i++) {
                //所有根节点为root_y的节点，将其根节点修改成root_x
                if (root[i] == root_y) {
                    root[i] = root_x;
                }
            }
        }
    }

    //两节点是否属同一个集合
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

}
