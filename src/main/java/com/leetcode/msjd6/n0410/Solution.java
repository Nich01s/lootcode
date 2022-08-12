package com.leetcode.msjd6.n0410;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Nic1
 * @Date: 2022/8/6 19:37
 * @Theme:
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        t2.left = t4;
        TreeNode t1 = new TreeNode(1);
        t1.right = t2;
        TreeNode tt3 = new TreeNode(3);
        TreeNode tt2 = new TreeNode(2);
        tt3.left = tt2;
        Solution s = new Solution();
        boolean b = s.checkSubTree(t1, tt3);
        System.out.println(b);
    }

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        //在t1中找出所有的值=t2根节点值的节点
        List<TreeNode> list = new ArrayList<>();
        recur(t1, list);
        for (int i = 0; i < list.size(); i++) {
            if (dfs(list.get(i), t2)) {
                return true;
            }
        }
        return false;
    }

    //遍历t1
    public void recur(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        recur(node.left, list);
        list.add(node);
        recur(node.right, list);
    }

    //判断以t1为根节点的树，与以t2为根节点的树，是否相同
    public boolean dfs(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }
        return (node1.val == node2.val) && dfs(node1.left, node2.left) && dfs(node1.right, node2.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}