package com.leetcode.msjd6.n0812;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Nic1
 * @Date: 2022/3/11 23:46
 * @Theme: 八皇后
 */
class Solution {
    public static void main(String[] args) {
        List<List<String>> lists = new Solution().solveNQueens(8);
        System.out.println(lists);
        System.out.println(lists.size());
        //String a = "a";
        //System.out.println(a.hashCode());
        //a = "b";
        //System.out.println(a.hashCode());
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        String[][] arr = new String[n][n];
        for (int j = 0; j < arr[0].length; j++) {
            dfs(res, n, arr, 0, j);
        }
        return res;
    }

    public void dfs(List<List<String>> res, int N, String[][] arr, int x, int y) {
        if (x == 8 && N == 0) {
            for (String[] sts : arr) {
                for (int i = 0; i < sts.length; i++) {
                    if (sts[i] == null) {
                        sts[i] = ".";
                    }
                }
            }
            List<String> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < arr[0].length; j++) {
                    sb.append(arr[i][j]);
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        if (!horAndVerValid(arr, x, y) || !diagonalValid(arr, x, y)) {//剪枝
            return;
        }
        arr[x][y] = "Q";//放置皇后
        //进入下一行遍历
        for (int j = 0; j < arr[0].length; j++) {
            dfs(res, N - 1, arr, x + 1, j);//
        }
        arr[x][y] = null;
    }

    //检测当前坐标对角线上是否有皇后，返回false意为当前坐标不满足条件
    public boolean diagonalValid(String[][] arr, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if ("Q".equals(arr[i][j])) {
                    if ((x - i == y - j) || (j - x == y - i)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //检测当前坐标纵向是否有皇后
    public boolean horAndVerValid(String[][] arr, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if ("Q".equals(arr[i][j])) {
                    if ((j == y)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
