package com.leetcode.dfs.n329;

/**
 * @Author: Nic1
 * @Date: 2022/3/18 21:01
 * @Theme: 矩阵中的最长递增路径
 */
//方法：dp
//状态转移方程：
class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        int i = new Solution().longestIncreasingPath(matrix);
        System.out.println(i);
    }

    //定义方向数组
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int rows, cols;

    public int longestIncreasingPath(int[][] matrix) {
        //特判
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        cols = matrix[0].length;
        int[][] cache = new int[rows][cols];
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res = Math.max(res, dfs(matrix, i, j, cache));//更新最长递增路径长度
            }
        }
        return res;
    }

    //深度优先搜索当前给定坐标的最长递增路径
    public int dfs(int[][] matrix, int nowI, int nowJ, int[][] cache) {
        if (cache[nowI][nowJ] != 0) {//cache[i][j] != 0意味着当前(i,j)已经遍历过
            return cache[nowI][nowJ];//返回结果
        }
        cache[nowI][nowJ]++;//路径长度+1
        for (int[] dir : dirs) {
            int newI = nowI + dir[0];
            int newJ = nowJ + dir[1];
            if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && matrix[newI][newJ] > matrix[nowI][nowJ]) { //条件约束
                cache[nowI][nowJ] = Math.max(cache[nowI][nowJ], dfs(matrix, newI, newJ, cache) + 1);//加上上下左右坐标中的最长递增路径
            }
        }
        return cache[nowI][nowJ];
    }
}
