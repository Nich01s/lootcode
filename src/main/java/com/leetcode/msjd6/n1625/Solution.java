package com.leetcode.msjd6.n1625;

import com.leetcode.msjd6.n0208.Solution;
import com.sun.webkit.graphics.WCCamera;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Nic1
 * @Date: 2022/3/11 22:03
 * @Theme: LRU 缓存
 */
class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);                        // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);                        // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }

    int size;//当前链表容量
    ListNode head;
    Map<Integer, Integer> map;
    int capacity;//规定上限容量

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new ListNode(-1);
        map = new HashMap<>();
    }

    //获取数据
    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode p = head;
            while (p.next != null) {
                if (p.next.val == key) {
                    if (p == head) {
                        break;
                    }
                    ListNode q = p.next;
                    p.next = p.next.next;
                    q.next = head.next;
                    head.next = q;
                } else {
                    p = p.next;
                }
            }
            return map.get(key);
        } else {
            return -1;
        }
    }

    //插入数据(LUR筛出掉链表尾部节点)
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            //判断容量是否达到上限
            if (size + 1 > capacity) {
                //删除尾部节点
                ListNode p = head;
                ListNode q = head.next;
                if (q != null) {
                    while (q.next != null) {
                        p = p.next;
                        q = q.next;
                    }
                    p.next = null;
                    //移除map中尾部节点对应key
                    map.remove(q.val);
                    size--;
                }
            }
            //插入新结点
            ListNode newNode = new ListNode(key);
            newNode.next = head.next;
            head.next = newNode;
            size++;
        } else {
            //更新链表
            ListNode p = head;
            while (p.next != null) {
                if (p.next.val == key) {
                    if (p == head) {
                        break;
                    }
                    ListNode q = p.next;
                    p.next = p.next.next;
                    q.next = head.next;
                    head.next = q;
                } else {
                    p = p.next;
                }
            }
        }
        map.put(key, value);//插入map/覆盖旧值
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}