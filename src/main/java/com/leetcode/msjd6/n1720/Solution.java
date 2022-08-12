package com.leetcode.msjd6.n1720;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: Nic1
 * @Date: 2022/2/20 21:28
 * @Theme: 连续中值
 */
//方法：构造对顶堆（思路：构建一个最大堆和最小堆，以最小堆堆顶元素为界线，当大于界线时加入最小堆，反之加入最大堆，当两个堆元素个数之差大于1时，将堆元素多的那个堆堆顶元素弹出加入另一个堆）
class MedianFinder {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        double median1 = medianFinder.findMedian();
        medianFinder.addNum(3);
        double median2 = medianFinder.findMedian();
        System.out.println(median1+","+median2);

    }
    PriorityQueue<Integer> minHeap;//默认是最小堆
    PriorityQueue<Integer> maxHeap;//默认是最小堆
    int size;//当前堆容量

    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        size = 0;
    }

    //添加元素
    public void addNum(int num) {
        if (size == 0) {
            minHeap.add(num);//第一个元素加入最小堆
            size++;
        } else {
            if (num > minHeap.peek()) {
                minHeap.add(num);
                size++;
            } else {
                maxHeap.add(num);
                size++;
            }
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (size != 0) {
            if (size % 2 == 0) {
                return (double) (maxHeap.peek() + minHeap.peek()) / 2;
            } else {
                if (minHeap.size() > maxHeap.size()) {
                    return (double) minHeap.peek();
                } else {
                    return (double) maxHeap.peek();
                }
            }
        }
        return 0;
    }
}