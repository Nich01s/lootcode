package com.leetcode.工具.构建二叉树;

import java.util.LinkedList;

/**
 * @Author: Nic1
 * @Date: 2022/8/6 21:13
 * @Theme: 【工具类】：根据层序遍历重建二叉树
 */
public class LevelOrderRebuildBinaryTreeUtils {
    /**
     * 根据层序遍历，重建二叉树
     */
    public static TreeNode arrayToTree(Integer[] arr) {
        //使用队列遍历二叉树  队列的使用offer(加入新节点)/poll(返回并删除队首元素)
        LinkedList<TreeNode> queue = new LinkedList<>();
        //创建根节点
        TreeNode root = new TreeNode(arr[0]);
        //节点入队列
        queue.push(root);
        int i = 1;
        while (i < arr.length) {
            //从数组中取出值
            Integer value = arr[i];
            //从队列中弹出元素
            TreeNode node = queue.poll();
            if (value != null) {
                //创建左孩子节点, 放入队列, 填充value
                TreeNode leftNode = new TreeNode(value);
                queue.offer(leftNode);
                node.left = leftNode;
            }
            // 取出数组下一个元素
            i++;
            if (i >= arr.length) break;
            value = arr[i];

            if (value != null) {
                //创建右孩子
                TreeNode rightNode = new TreeNode(value);
                queue.offer(rightNode);
                node.right = rightNode;
            }
            i++;
        }
        return root;
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
