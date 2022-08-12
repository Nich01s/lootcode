package com.leetcode.msjd6.n1604;

/**
 * @Author: Nic1
 * @Date: 2022/3/14 23:03
 * @Theme: 井字游戏
 */
class Solution {
    public static void main(String[] args) {
        String tictactoe = new Solution().tictactoe(new String[]{"XO", " X"});
        System.out.println(tictactoe);
    }

    public String tictactoe(String[] board) {
        int N = board.length;
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i].charAt(j) == 'O') {
                    arr[i][j] = 1;
                } else if (board[i].charAt(j) == 'X') {
                    arr[i][j] = -1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }
        boolean flag = false;//记录是否有空格
        //行检测
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    flag = true;
                }
                sum += arr[i][j];
            }
            if (sum == N) {
                return "O";
            } else if (sum == -N) {
                return "X";
            }
        }//以上检测若无任何返回说明所有行都无连线
        //列检测
        for (int j = 0; j < N; j++) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i][j] == 0) {
                    flag = true;
                }
                sum += arr[i][j];
            }
            if (sum == N) {
                return "O";
            } else if (sum == -N) {
                return "X";
            }
        }//以上检测若无任何返回说明所有列都无连线
        //对角线检测
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i][i];
        }
        if (sum == N) {
            return "O";
        } else if (sum == -N) {
            return "X";
        }//以上检测若无任何返回说明所有左上右下对角线无连线
        sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i][N - i - 1];
        }
        if (sum == N) {
            return "O";
        } else if (sum == -N) {
            return "X";
        }//以上检测若无任何返回说明所有右上左下对角线无连线

        return flag ? "Pending" : "Draw";
    }
}
