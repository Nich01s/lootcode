package com.leetcode.daily.n0731;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Nic1
 * @Date: 2022/7/31 13:21
 * @Theme: 最大层内元素和
 */
public class Solution {

    public int maxLevelSum(TreeNode root) {

        int minLevel = 0;//记录最大和层中的较小层
        Long maxSum = Long.MIN_VALUE;//记录最大和

        Queue<TreeNode> queue = new LinkedList<>();//辅助队列
        queue.offer(root);//根节点入队
        int level = 1;//当前所在层

        while (!queue.isEmpty()) {
            long sum = 0L;//统计当前层和
            int size = queue.size();//返回当前队列中元素数
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();//出队
                sum += poll.val;//求和
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                minLevel = level;
            }
            level++;
        }
        return minLevel;
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