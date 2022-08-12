package com.leetcode.msjd6.n0404;

/**
 * @Author: Nic1
 * @Date: 2022/8/2 22:08
 * @Theme:
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root);
    }

    //【递归思想】：每层返回自己树的高度
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    public boolean dfs(TreeNode root) {
        //叶子节点一定平衡
        if (root == null) {
            return true;
        } else {
            //根据左右子树高度返回结果
            return Math.abs(height(root.left) - height(root.right)) <= 1 && dfs(root.left) && dfs(root.right);
        }
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