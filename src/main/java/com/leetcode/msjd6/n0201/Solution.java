package com.leetcode.msjd6.n0201;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author: Nic1
 * @Date: 2022/2/11 21:49
 * @Theme: 移除重复节点
 */
//方法1：hash表
//方法2：0n^2遍历

/**
 * 方法1：hash表
 */
class Solution1 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l6.next = l6;
        l6.next = null;
        ListNode listNode = removeDuplicateNodes(l1);
        System.out.println(listNode);
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = head;
        while (q != null) {
            if (!set.contains(q.val)) {
                set.add(q.val);
                p = q;
                q = q.next;
            } else {
                p.next = q.next;
                q = q.next;
            }
        }
        return head;
    }
}

/**
 * 方法2：On^2遍历
 */
class Solution2 {
    public ListNode removeDuplicateNodes(ListNode head) {
        return null;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}