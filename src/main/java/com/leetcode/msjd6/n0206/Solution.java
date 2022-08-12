package com.leetcode.msjd6.n0206;

/**
 * @Author: Nic1
 * @Date: 2022/2/12 20:59
 * @Theme: 回文链表（要求 O(n) 时间复杂度和 O(1) 空间复杂度）
 */
//反转链表的前半段
class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(3);
        ListNode l8 = new ListNode(2);
        ListNode l9 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = null;
        boolean palindrome = isPalindrome(l1);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        int len = 0;
        ListNode a = head;
        while (a != null) {
            len++;
            a = a.next;
        }
        if (len==1){
            return true;
        }
        //len%2==0时，可能为1->2->3->2->1回文链表
        //len%2==1时，可能为1->2->3->3->2->1回文链表
        ListNode p = head;
        ListNode q = p;
        ListNode r = head.next;
        int half = len / 2;
        while (half != 1) {
            q = r;
            r = r.next;
            q.next = p;
            p = q;
            half--;
        }
        if (len % 2 == 1) {//意味着节点为奇数个
            r = r.next;
        }
        while (r != null) {
            if (r.val != p.val) {
                return false;
            }
            r = r.next;
            p = p.next;
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
