package com.leetcode.msjd6.n0412;

/**
 * @Author: Nic1
 * @Date: 2022/8/6 20:10
 * @Theme: 求和路径
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径不一定非得从二叉树的根节点或叶节点开始或结束
 */
public class Solution {
    public static void main(String[] args) {
        //生成用于测试的二叉树
        Integer[] arr = new Integer[]{-2, null, -3};
        TreeNode root = arrayToTree(arr);

        Solution s = new Solution();
        int i = s.pathSum(root, -2);
        System.out.println(i);
    }

    //重建二叉树（用于测试）
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

    List<Integer> list;//全局计数器
    int sum;//sum

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        this.sum = sum;
        list = new ArrayList<>();
        tra(root);
        return list.size();
    }

    //遍历root根节点开始的每个节点，计算以每个节点开始的满足条件的路径个数
    public void tra(TreeNode node) {
        if (node == null) {
            return;
        }
        tra(node.left);
        dfs(node, sum, list);
        tra(node.right);
    }

    // 以当前指定节点为根节点开始搜索，计算以当前节点开始的满足条件的路径个数
    // 如果以当前节点开始的某条路径和为sum，则进行计数
    public void dfs(TreeNode root, int k, List<Integer> list) {//k为剩余和
        if (root == null) {
            return;
        }
        dfs(root.left, k - root.val, list);//处理左子树
        if (k - root.val == 0) list.add(1);//处理当前节点
        dfs(root.right, k - root.val, list);//处理右子树
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