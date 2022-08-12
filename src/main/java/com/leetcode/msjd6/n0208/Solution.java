package com.leetcode.msjd6.n0208;

/**
 * @Author: Nic1
 * @Date: 2022/2/12 21:43
 * @Theme: 环路检测（要求O1空间复杂度）
 */
//使用快慢指针检测是否有环路，快指针移动速度为慢指针速度的2倍
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;//如果没有环路将直接退出
            }
            slow = slow.next;
            fast = fast.next.next;
        }



        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
