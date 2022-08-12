package com.leetcode.msjd6.n0802;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Nic1
 * @Date: 2022/8/9 19:47
 * @Theme: 迷路的机器人【只能向右或向下走】
 */
public class Solution {
    int m;
    int n;
    int[][] obstacleGrid;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        this.obstacleGrid = obstacleGrid;
        List<List<Integer>> res = new ArrayList<>();//记录路径
        boolean[][] visited = new boolean[m][n];//记录已经遍历过的坐标
        dfs(res, visited, 0, 0);
        return res;
    }

    public boolean dfs(List<List<Integer>> res, boolean[][] visited, int x, int y) {
        //当坐标已经走过 或 坐标上有障碍物 或 已越界，直接返回
        if (x >= m || y >= n || visited[x][y] || obstacleGrid[x][y] == 1) {
            return false;
        }
        //将当前坐标加入res
        res.add(new ArrayList<>(Arrays.asList(x, y)));
        //当到达右下角，直接返回true
        if (x == m - 1 && y == n - 1) {
            return true;
        }
        //标记已走
        visited[x][y] = true;
        if (dfs(res, visited, x + 1, y) || dfs(res, visited, x, y + 1)) {
            return true;
        }
        //回溯
        res.remove(res.size() - 1);
        return false;
    }
}
