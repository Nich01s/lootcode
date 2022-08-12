package com.leetcode.msjd6.n0406;

/**
 * @Author: Nic1
 * @Date: 2022/8/6 15:54
 * @Theme: 后继者
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 返回二叉搜索树中指定节点的下一个节点，即中序遍历的下一个节点
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        List<TreeNode> res = new ArrayList<>();//存储遍历结果
        order(root, res);
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) == p) {
                return res.get(i + 1);
            }
        }
        return null;
    }
    public void order(TreeNode node, List<TreeNode> res) {
        if (node == null) {
            return;
        }
        //中序遍历：左-根-右
        order(node.left, res);
        res.add(node);
        order(node.right, res);
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