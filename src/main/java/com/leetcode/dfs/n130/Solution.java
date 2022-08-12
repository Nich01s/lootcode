package com.leetcode.dfs.n130;

/**
 * @Author: Nic1
 * @Date: 2022/4/11 17:33
 * @Theme: 被围绕的区域
 */
//方法：沿边向内延申
class Solution {
    int[][] dirs = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};//方向

    public void solve(char[][] board) {
        boolean[][] isUsed = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, isUsed, i, 0);
            }
            if (board[i][board.length - 1] == 'O') {
                dfs(board, isUsed, i, board.length - 1);
            }
        }
        for (int j = 1; j < board[0].length - 1; j++) {
            if (board[0][j] == 'O') {
                dfs(board, isUsed, 0, j);
            }
            if (board[board.length - 1][j] == 'O') {
                dfs(board, isUsed, board.length - 1, j);
            }
        }
        //更换被包围的O
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!isUsed[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    //沿边深度优先搜索
    public void dfs(char[][] board, boolean[][] isUsed, int x, int y) {
        if (board[x][y] == 'X') {
            return;
        }
        isUsed[x][y] = true;//标记
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && !isUsed[newX][newY]) {//不越界
                dfs(board, isUsed, newX, newY);
            }
        }
    }
}
