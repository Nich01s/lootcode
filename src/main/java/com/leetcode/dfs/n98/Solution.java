package com.leetcode.dfs.n98;

/**
 * @Author: Nic1
 * @Date: 2022/4/11 16:21
 * @Theme: 验证二叉搜索树
 */
//方法：只要保证根节点左边所有元素必根节点值小，根节点右边所有值必根节点值大即可
class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return dfs(node.left, lower, node.val) && dfs(node.right, node.val, upper);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}