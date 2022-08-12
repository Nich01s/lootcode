package com.leetcode.daily.n0805;

/**
 * @Author: Nic1
 * @Date: 2022/8/5 0:02
 * @Theme: 在二叉树中增加一行
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * 层序遍历
 */
public class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        Deque<TreeNode> queue = new LinkedList<>();//使用队列
        queue.offer(root);//根节点入队
        int level = 1;//记录当前所在深度
        while (!queue.isEmpty()) {
            int size = queue.size();//返回当前队列中元素数
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                // 在目标层插入节点
                if (level == depth - 1) {
                    TreeNode l = new TreeNode(val);
                    TreeNode r = new TreeNode(val);
                    l.left = poll.left;
                    r.right = poll.right;
                    poll.left = l;
                    poll.right = r;
                } else {
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
            }
            level++;
        }
        return root;
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
