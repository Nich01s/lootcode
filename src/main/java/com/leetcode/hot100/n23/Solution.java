package com.leetcode.hot100.n23;

/**
 * @Author: Nic1
 * @Date: 2022/2/9 21:22
 * @Theme: 合并K个升序链表
 */
//方法1：使用归并方式，两两合并链表
//方法2：借助优先队列，获取当前K个节点中的最小节点

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 方法1：使用归并的方式两两合并升序链表
 */
class Solution1 {

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    //归并两两链表（递归）
    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, r));//归并
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
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
        if (l1 == null) {
            l3.next = l2;
        }
        if (l2 == null) {
            l3.next = l1;
        }
        return dummy.next;
    }
}

/**
 * 方法2：借助优先队列，获取当前K个节点中的最小节点
 */
class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        //先创建一个最小堆
        PriorityQueue<ListNode> pQ = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;//按照节点值排序
            }
        });//默认为最小堆
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pQ.add(lists[i]);//先将所有链表的头节点放入最小堆中
            }
        }
        ListNode p = new ListNode(-1);
        ListNode dummy = p;
        while (!pQ.isEmpty()) {
            ListNode minValNode = pQ.poll();//获取并移除当前堆顶节点
            p.next = minValNode;
            p = p.next;
            if (minValNode.next != null) {//如果堆顶节点的next不为空，就将其加入堆
                pQ.add(minValNode.next);//顺便将元堆顶节点删除
            }
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