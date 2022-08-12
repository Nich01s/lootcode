package com.leetcode.hot100.n19;

/**
 * @Author: Nic1
 * @Date: 2022/2/9 16:56
 * @Theme: 删除链表的倒数第 N 个结点
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);//哑节点
        ListNode left = dummy;
        ListNode right = head;
        while (n > 0 && right != null) {
            right = right.next;
            n--;
        }
        while (right!=null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
