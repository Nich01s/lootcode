package com.leetcode.msjd6.n0303;

/**
 * @Author: Nic1
 * @Date: 2022/7/29 21:09
 * @Theme: 堆盘子
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈，此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同
 * 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作
 * (当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1)
 */
public class StackOfPlates {

    List<Stack<Integer>> list;
    int cap;

    public static void main(String[] args) {
        StackOfPlates s = new StackOfPlates(2);
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.popAt(0));
        System.out.println(s.popAt(0));
        System.out.println(s.popAt(0));
    }

    public StackOfPlates(int cap) {
        this.cap = cap;
        list = new ArrayList<>();
    }

    // 入栈
    public void push(int val) {
        if (cap == 0) {
            return;
        }
        //如果当前list为空，新建一个栈
        if (list.size() == 0) {
            list.add(new Stack<>());
        }
        //如果当前栈满了，新建一个栈
        Stack<Integer> stack = list.get(list.size() - 1);
        if (stack.size() == cap) {
            Stack<Integer> newStack = new Stack<>();
            newStack.push(val);
            list.add(newStack);
        }
        //当前栈没满，直接入栈
        else {
            stack.push(val);
        }
    }

    //出栈
    public int pop() {
        //如果list为空
        if (list.size() == 0) {
            return -1;
        }
        //直接出栈
        Stack<Integer> stack = list.get(list.size() - 1);
        int pop = stack.pop();
        //如果栈为空，删除该栈
        if (stack.size() == 0) {
            list.remove(list.size() - 1);
        }
        return pop;
    }

    //指定栈的pop操作
    public int popAt(int index) {
        //如果list为空，或指定栈不存在
        if (list.size() == 0 || index > list.size() - 1) {
            return -1;
        }
        Stack<Integer> stack = list.get(index);
        //出栈
        int pop = stack.pop();
        //如果指定栈为空，删除栈
        if (stack.size() == 0) {
            list.remove(index);
        }
        return pop;
    }
}
