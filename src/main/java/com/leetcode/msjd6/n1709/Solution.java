package com.leetcode.msjd6.n1709;

import com.leetcode.msjd6.n0208.Solution;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @Author: Nic1
 * @Date: 2022/3/3 22:10
 * @Theme: 第 k 个数
 */
//方法1：最小堆，堆顶元素每次移除前分别*3,*5,*7入堆
//方法2：动态规划
class Solution1 {
    public static void main(String[] args) {
        for (int i = 1; i < 50; i++) {
            System.out.println(new Solution1().getKthMagicNumber(i));
        }
        //int kthMagicNumber = new TripleInOne().getKthMagicNumber(20);
        //System.out.println(kthMagicNumber);
    }

    public int getKthMagicNumber(int k) {
        if (k == 1) {
            return 1;
        }
        Stack<Long> stack = new Stack<>();//存放出堆元素
        PriorityQueue<Long> pQ = new PriorityQueue<>();//默认是最小堆
        pQ.add(1L);
        while (stack.size() != k) {
            while (!stack.isEmpty() && (pQ.peek().equals(stack.peek()))) {
                pQ.poll();
            }
            long poll = pQ.poll();
            pQ.add(poll * 3);
            pQ.add(poll * 5);
            pQ.add(poll * 7);
            stack.add(poll);
        }
        return stack.pop().intValue();
    }
}

/**
 * 方法2：动态规划：
 *
 */
class Solution2 {
    public int getKthMagicNumber(int k) {


        return 0;
    }
}
