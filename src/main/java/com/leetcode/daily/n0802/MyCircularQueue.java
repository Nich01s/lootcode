package com.leetcode.daily.n0802;

import java.util.LinkedList;

/**
 * @Author: Nic1
 * @Date: 2022/8/2 0:20
 * @Theme: 设计循环队列
 */
public class MyCircularQueue {
    public static void main(String[] args) {
        /**
         *
         ["MyCircularQueue","enQueue","Rear","Rear","deQueue","enQueue","Rear","deQueue","Front","deQueue","deQueue","deQueue"]
         [[6],[6],[],[],[],[5],[],[],[],[],[],[]]
         */
        MyCircularQueue circularQueue = new MyCircularQueue(6);
        System.out.println(circularQueue.enQueue(6));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(5));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.Front());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
    }

    ListNode head;//单向循环链表，使用头尾指针表示
    ListNode tail;
    int size;//当前元素数
    int cap;//容量

    public MyCircularQueue(int k) {
        this.cap = k;
        //构造单向循环链表
        ListNode dummy = new ListNode(-1, null);
        ListNode p = dummy;
        for (int i = 0; i < cap; i++) {
            p.next = new ListNode(0, null);
            p = p.next;
        }
        p.next = dummy.next;//正向闭环
        head = dummy.next;
        tail = dummy.next;
    }

    //队尾入队：ifFull?
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        //如果当前为空
        if (isEmpty()) {
            tail.val = value;
        } else {
            tail = tail.next;
            tail.val = value;
        }
        size++;
        return true;
    }

    //队头出队:isEmpty?
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (size == 1) {
            head.val = 0;
        } else {
            head = head.next;
        }
        size--;
        return true;
    }

    //返回head所指元素
    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return head.val;
    }

    //返回tail所指元素
    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        return tail.val;
    }

    //size==0?
    public boolean isEmpty() {
        return size == 0;
    }

    //size==cap?
    public boolean isFull() {
        return size == cap;
    }
}

//双向循环链表
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
