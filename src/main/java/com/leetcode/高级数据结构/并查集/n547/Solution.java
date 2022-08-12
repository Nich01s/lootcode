package com.leetcode.高级数据结构.并查集.n547;

/**
 * @Author: Nic1
 * @Date: 2022/7/31 20:32
 * @Theme: 省份数量
 */
/**
 * 本题隐藏输入条件：isConnected[i][j]==isConnected[j][i]
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int row = isConnected.length;//行
        int col = isConnected[0].length;//列
        UnionFind uf = new UnionFind(row);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);//连接
                }
            }
        }
        //计算省份数量
        int[] res = new int[row];
        for (int i = 0; i < row; i++) {
            res[uf.find(i)]++;//当前城市属于哪个省会
        }
        int num = 0;
        for (int i = 0; i < row; i++) {
            if (res[i] != 0) {//计算省会数量
                num++;
            }
        }
        return num;
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

    //find函数
    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    //union函数
    public void union(int x, int y) {
        int root_x = find(x);
        int root_y = find(y);
        if (root_x != root_y) {
            root[root_y] = root_x;
        }
    }
}
