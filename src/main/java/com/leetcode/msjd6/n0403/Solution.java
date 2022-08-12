package com.leetcode.msjd6.n0403;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Nic1
 * @Date: 2022/8/6 12:03
 * @Theme: 特定深度节点链表
 */
public class Solution {
    public ListNode[] listOfDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<TreeNode[]> res0 = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            TreeNode[] arr = list.toArray(new TreeNode[0]);
            res0.add(arr);
        }
        ListNode[] res = new ListNode[res0.size()];
        //TreeNode转ListNode
        for (int i = 0; i < res0.size(); i++) {
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            for (int j = 0; j < res0.get(i).length; j++) {
                p.next = new ListNode(res0.get(i)[j].val);
                p = p.next;
            }
            res[i] = dummy.next;
        }
        return res;
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

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}