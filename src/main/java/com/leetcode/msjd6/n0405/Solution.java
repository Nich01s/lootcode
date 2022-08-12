package com.leetcode.msjd6.n0405;

/**
 * @Author: Nic1
 * @Date: 2022/8/6 14:51
 * @Theme: 合法二叉搜索树
 */

/**
 * 检查一棵二叉树是否为二叉搜索树:（方法1）
 *    对于左子树：区间范围是：[当前节点值，right]
 *    对于右子树：区间范围是：[left,当前节点值]
 * 方法2：
 *    中序遍历结果一定是升序排列的
 * 注意边界输入：[2147483647]
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return recur(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean recur(TreeNode node, long left, long right) {
        if (node == null) return true;
        int val = node.val;
        if (val <= left || val >= right) return false;
        return recur(node.right, val, right) && recur(node.left, left, val);
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