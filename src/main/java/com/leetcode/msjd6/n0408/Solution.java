package com.leetcode.msjd6.n0408;

/**
 * @Author: Nic1
 * @Date: 2022/8/8 13:44
 * @Theme: 首个共同祖先【递归】
 */

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 分三种情况讨论：
 *     Ⅰ、在左右子树上：p=3，q=8
 *              5
 *            /   \
 *          <3>    7
 *         /  \     \
 *        2    4    <8>
 *     Ⅱ、在同一棵树上：p=3，q=4
 *              5
 *            /   \
 *          <3>    7
 *         /  \     \
 *        2   <4>    8
 *     Ⅲ、其中有一个就是根节点：p=5，q=3
 *             <5>
 *            /   \
 *          <3>    7
 *         /  \     \
 *        2    4     8
 *  解题思路：
 *     使用dfs
 *       使用left记录在左子树中查找p或q的情况，找到其中之一立刻结束，找不到则为null
 *       使用right记录在右子树中查找p或q的情况，找到其中之一立刻结束，找不到则为null
 *     根据以上思路，可用分为三种情况：
 *       Ⅰ、left=3，right=8，都不为null，因此root=5即为该两个节点的公共祖先
 *       Ⅱ、left=3，right=null，意味着左子树中找不到p或q，说明剩下的一个没找到的就在左子树中，而左子树中的3先被找到，因此root=3就是该两个节点的公共祖先
 *       Ⅲ、root=p/q，意味着root就是该两个节点的公共祖先
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{-1,0,3,-2,4,null,null,8};
        TreeNode root = arrayToTree(arr1);
        Solution s = new Solution();
        TreeNode p = new TreeNode(8);
        TreeNode q = new TreeNode(4);
        TreeNode treeNode = s.lowestCommonAncestor(root, p, q);
        System.out.println(true);
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Ⅲ、root=p/q
        if (p.val == root.val || q.val == root.val) {
            return root;
        }
        // Ⅰ、left=3，right=8，都不为null，因此root=5即为该两个节点的公共祖先
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        dfs(root.left, p.val,q.val, list1);//搜寻左子树p/q，结果存放在list1中
        dfs(root.right, p.val,q.val, list2);//搜寻右子树p/q，结果存放在list2中
        if (!list1.isEmpty() && !list2.isEmpty()) {
            return root;
        }
        // Ⅱ、left=3，right=null / left=4，right=null
        else if (!list1.isEmpty()) {
            return list1.get(0);
        } else {
            return list2.get(0);
        }
    }

    //在(左/右)子树中寻找指定值p/q的节点，通过参数返回该节点
    public void dfs(TreeNode node, int pVal,int qVal, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, pVal,qVal, list);
        //一旦找到立即返回
        if (node.val == pVal||node.val==qVal) {
            list.add(node);
            return;
        }
        dfs(node.right,pVal,qVal, list);
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