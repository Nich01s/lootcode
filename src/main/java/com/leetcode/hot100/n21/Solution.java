package com.leetcode.hot100.n21;

/**
 * @Author: Nic1
 * @Date: 2022/2/9 19:48
 * @Theme: 合并两个有序链表
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode(-1);
        ListNode dummy = l3;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l3.next = l1;
                l1 = l1.next;
                l3 = l3.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
                l3 = l3.next;
            }
        }
        if (l1==null){
            l3.next = l2;
        }
        if (l2==null){
            l3.next = l1;
        }
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
