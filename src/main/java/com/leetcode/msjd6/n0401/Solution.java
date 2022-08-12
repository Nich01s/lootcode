package com.leetcode.msjd6.n0401;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Nic1
 * @Date: 2022/8/6 12:52
 * @Theme: 节点间通路【dfs】
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] graph = new int[][]{{0, 1}, {0, 2}, {0, 4}, {1, 3}, {1, 4}, {2, 3}, {3, 4}};
        System.out.println(s.findWhetherExistsPath(5, graph, 3, 0));
    }

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        List<List<Integer>> edges = new ArrayList<>();//存储边
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        int len = graph.length;
        for (int i = 0; i < len; i++) {
            edges.get(graph[i][0]).add(graph[i][1]);//一个节点的出度可能>=1，dfs从其出度进行遍历
        }
        return dfs(edges, start, target);
    }

    public boolean dfs(List<List<Integer>> edges, int start, int target) {
        if (start == target) {
            return true;
        }
        List<Integer> list = edges.get(start);
        for (int i = 0; i < list.size(); i++) {
            if (dfs(edges, list.get(i), target)) {
                return true;
            }
        }
        return false;
    }
}
