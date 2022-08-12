package com.leetcode.高级数据结构.并查集.n130;

/**
 * @Author: Nic1
 * @Date: 2022/7/31 20:58
 * @Theme: 被围绕的区域（解法之一：并查集）
 */

/**
 * 并查集一般使用一维数组记录，本题中需将二维数组用node方法转化为一维坐标
 * （实际上可以看作是二维数组直接伸展为一维，这样每个原二维坐标都可以唯一表示为一维坐标）
 * 合并条件：上下左右有O就进行合并
 */
public class Solution {

    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        UnionFind uf = new UnionFind(row * col + 1);
        //使用一个虚拟节点（一维），作为所有边界的根节点
        int rootOfBod = row * col;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    //遇到O就进行union操作
                    //如果是边界上的O，将其与虚拟根节点union
                    if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                        uf.union(rootOfBod, coorTrans(i, j, col));
                    }
                    //如果是边界以内的O，将其与上下左右的O进行union操作
                    else {
                        if (i > 0 && board[i - 1][j] == 'O') {
                            uf.union(coorTrans(i, j, col), coorTrans(i - 1, j, col));
                        }
                        if (i < row && board[i + 1][j] == 'O') {
                            uf.union(coorTrans(i, j, col), coorTrans(i + 1, j, col));
                        }
                        if (j > 0 && board[i][j - 1] == 'O') {
                            uf.union(coorTrans(i, j, col), coorTrans(i, j - 1, col));
                        }
                        if (j < col && board[i][j + 1] == 'O') {
                            uf.union(coorTrans(i, j, col), coorTrans(i, j + 1, col));
                        }
                    }
                }
            }
        }
        //遍历矩阵，所有与虚拟节点不连接的'O'全部置为'X',所有与虚拟节点连接的'O'全部置为'X'
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (!uf.isConnected(coorTrans(i, j, col), rootOfBod)) {
                    board[i][j] = 'X';
                }
                //else {
                //    board[i][j] = 'X';
                //}
            }
        }
    }

    //二维坐标转一维坐标
    public int coorTrans(int x, int y, int col) {
        return x * col + y;
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

    //find方法
    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    //union方法
    public void union(int x, int y) {
        int root_x = find(x);
        int root_y = find(y);
        if (root_x != root_y) {
            root[root_y] = root_x;
        }
    }

    //isConnected方法
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}