package com.leetcode.msjd6.n1712;

/**
 * @Author: Nic1
 * @Date: 2022/3/2 22:57
 * @Theme: BiNode
 */
//方法：中序遍历，将当前节点设置为上一个遍历到的节点的右孩子
class Solution {
    TreeNode preNode;//作为当前节点的上一个节点

    public TreeNode convertBiNode(TreeNode root) {
        TreeNode ans = new TreeNode(-1);//作为起始空姐点
        preNode = ans;
        dfs(root);
        return ans.right;
    }

    //中序遍历
    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        node.left = null;//将当前节点左孩子设置为null
        preNode.right = node;//将当前节点设置为上一个遍历到的节点的右孩子（或者理解为将当前节点设置为下一个节点的左孩子）
        preNode = node;
        dfs(node.right);
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