package com.leetcode.msjd6.n1619;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Nic1
 * @Date: 2022/3/12 17:14
 * @Theme: 水域大小
 */
class Solution {
    public int[] pondSizes(int[][] land) {

        boolean[][] used = new boolean[land.length][land[0].length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0 && used[i][j]) {
                    dfs(list, land, used, 0, i, j);

                }
            }
        }
        return null;
    }

    public void dfs(List<Integer> list, int[][] land, boolean[][] used, int area, int x, int y) {
        if (x < 0 || x >= land.length || y < 0 || y >= land[0].length || used[x][y]) {

        }
        if (land[x][y] == 0 && !used[x][y]) {
            used[x][y] = true;
            area++;
        }
        //定义8个方向
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {}, {}, {}, {}};//上左下右
        for (int i = 0; i < dir.length; i++) {
            int newI = x + dir[i][0];
            int newJ = y + dir[i][1];
            dfs(list, land, used, area, newI, newJ);
        }
    }
}
