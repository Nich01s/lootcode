package com.leetcode.msjd6.n0305;

/**
 * @Author: Nic1
 * @Date: 2022/7/30 21:14
 * @Theme: 栈排序
 */

import java.util.Stack;

/**
 * 编写程序，对栈进行排序使最小元素位于栈顶
 * 最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 *
 * 优化思路：
 * 既然有辅助栈，那么充分利用辅助栈，考虑到主栈栈顶元素>=辅助栈的栈顶元素，
 * 如果处在中间的元素，我们直接放入辅助栈中，而不用来回倒了
 */
class SortedStack {

    public static void main(String[] args) {
        SortedStack s = new SortedStack();
        s.pop();
        s.pop();
        s.push(1);
        s.pop();
        System.out.println(s.isEmpty());
    }

    Stack<Integer> stack;
    Stack<Integer> temp;

    public SortedStack() {
        stack = new Stack<>();
        temp = new Stack<>();
    }

    //入栈
    public void push(int val) {
        //当前入栈元素如果大于栈顶元素，将其放入临时栈，将当前元素放到合适位置时，将临时栈元素重新加入原栈
        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }
        while (!stack.isEmpty() && val > stack.peek()) {
            temp.push(stack.pop());
        }
        stack.push(val);
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    //出栈
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    //返回栈顶元素
    public int peek() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    //栈是否为空
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
