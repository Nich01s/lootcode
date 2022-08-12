package com.leetcode.高级数据结构.并查集.n695;

/**
 * @Author: Nic1
 * @Date: 2022/8/1 20:50
 * @Theme: 岛屿的最大面积（解法之一：并查集）
 */

/**
 * 并查集、二维坐标转一维坐标、计算每个集合元素个数
 */
public class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] grid = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}};
        int i = s.maxAreaOfIsland(grid);
        System.out.println(i);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;//记录最大岛屿面积
        int row = grid.length;
        int col = grid[0].length;
        int size = row * col;
        UnionFind uf = new UnionFind(size);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    if (j < col - 1 && grid[i][j + 1] == 1) {
                        uf.union(convert(i, j, col), convert(i, j + 1, col));
                    }
                    if (i < row - 1 && grid[i + 1][j] == 1) {
                        uf.union(convert(i, j, col), convert(i + 1, j, col));
                    }
                }
            }
        }
        //遍历计算当前区域
        int[] res = new int[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int root = uf.find(convert(i, j, col));//(i,j)坐标的根
                    max = Math.max(max, ++res[root]);
                }
            }
        }
        return max;
    }

    //二维坐标转一维坐标
    public int convert(int x, int y, int col) {
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
