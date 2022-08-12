package com.leetcode.msjd6.n0302;

import java.util.Stack;

/**
 * @Author: Nic1
 * @Date: 2022/7/29 20:44
 * @Theme: 栈的最小值
 */
public class MinStack{
    public static void main(String[] args) {
        MinStack1 minStack = new MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}

class MinStack1 {

    int[] stack;//本栈（使用数组表示）
    int[] minEle;//当前栈顶最小元素
    int index;//当前栈顶下标

    public MinStack1() {
        stack = new int[100000];
        minEle = new int[100000];
        index = 0;
    }

    //入栈，同时维护栈内最小元素
    public void push(int x) {
        stack[index] = x;
        if (index == 0 || x < minEle[index - 1]) {
            minEle[index] = x;
        } else {
            minEle[index] = minEle[index - 1];
        }
        index++;
    }

    //出栈
    public void pop() {
        if (index == 0) {
            return;
        }
        stack[index - 1] = 0;
        minEle[index - 1] = 0;
        index--;
    }

    //栈顶元素
    public int top() {
        if (index == 0) {
            return -1;
        }
        return stack[index - 1];
    }

    //返回当前栈内最小元素
    public int getMin() {
        if (index == 0) {
            return -1;
        }
        return minEle[index - 1];
    }
}
