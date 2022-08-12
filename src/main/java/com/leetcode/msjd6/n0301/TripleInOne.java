package com.leetcode.msjd6.n0301;

/**
 * @Author: Nic1
 * @Date: 2022/7/29 19:53
 * @Theme: 三合一（用一个数组来实现三个栈）
 */

public class TripleInOne {
    private int[] arr;//存储数值
    private int[][] sizes;//标记每个栈的元素数
    private int sL;

    //构造函数会传入一个stackSize参数，代表每个栈的大小
    public TripleInOne(int stackSize) {
        arr = new int[stackSize * 3];
        sizes = new int[][]{{0, 0}, {1, 0}, {2, 0}};
        sL = stackSize;
    }

    //向第stackNum号栈压入value，如果栈满，则不执行压入
    public void push(int stackNum, int value) {
        //获取第stackNum号栈元素数，当栈不满才执行压入操作
        if (sizes[stackNum][1] < sL) {
            arr[stackNum * sL + sizes[stackNum][1]] = value;//压栈
            sizes[stackNum][1]++;
        }
    }

    //第stackNum号栈出栈，如果该栈为空，返回-1
    public int pop(int stackNum) {
        if (sizes[stackNum][1] == 0) {
            return -1;
        }
        int peek = arr[stackNum * sL + sizes[stackNum][1] - 1];
        arr[stackNum * sL + sizes[stackNum][1] - 1] = 0;
        sizes[stackNum][1]--;
        return peek;
    }

    // 返回第stackNum号栈的栈顶元素，如果该栈为空，返回-1
    public int peek(int stackNum) {
        if (sizes[stackNum][1] == 0) {
            return -1;
        }
        return arr[stackNum * sL + sizes[stackNum][1] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum][1] == 0;
    }
}
