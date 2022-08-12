package com.leetcode.dfs.n133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Nic1
 * @Date: 2022/4/12 9:20
 * @Theme: 无向图克隆
 */
class Solution {
    Map<Node, Node> hasClone = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return dfs(node);
    }

    //深度优先搜索遍历原无向图
    public Node dfs(Node node) {
        //如果node已被克隆，直接返回对应克隆节点
        if (hasClone.containsKey(node)) {
            return hasClone.get(node);
        }
        //如果node未克隆，创建新节点
        Node clone = new Node(node.val);
        hasClone.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor));
        }
        return clone;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}