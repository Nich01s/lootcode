package com.leetcode.dfs.n210;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Nic1
 * @Date: 2022/4/16 18:54
 * @Theme:
 */
class Solution {

    //存储有向图，对应prerequisites数组
    List<List<Integer>> edges;
    //标记每个节点的状态，0未搜索1搜索中2已搜索
    int[] visited;
    //使用数组模拟栈
    int[] result;
    //判断有向图中是否有环
    boolean valid = true;
    //栈下标
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        //每次挑选一个[未搜索]的节点，开始进行dfs







        return null;
    }
}