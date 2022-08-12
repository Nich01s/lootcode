package com.leetcode.hot100.n42;

/**
 * @Author: Nic1
 * @Date: 2022/2/17 12:45
 * @Theme: 接雨水
 */
//方法1：单调栈
//方法2：动态规划

import java.util.Stack;

/**
 * 方法1：单调栈（单调递减栈）
 */
class Solution1 {
    public static void main(String[] args) {
        int trap = trap(new int[]{4,2,0,3,2,5});
        System.out.println(trap);
    }

    public static int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();//栈用于存储下标
        int volume = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int pop = stack.pop();//下标
                if (!stack.isEmpty()) {
                    volume += (Math.min(height[i], height[stack.peek()]) - height[pop]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return volume;
    }
}

/**
 * 方法2：动态规划（严格意义上非动态规划）
 * 计算每个下标的左右各最高柱子高度，则当前下标处所积雨水量=Max(左max,右边max)-height[i]
 */
class Solution2 {
    public static void main(String[] args) {
        int trap = trap(new int[]{1});
        System.out.println(trap);
    }

    public static int trap(int[] height) {
        int[] left = new int[height.length];//记录下标i左边的最高柱子
        int leftMax = left[0];
        int[] right = new int[height.length];//记录下标i右边的最高柱子
        int rightMax = right[height.length - 1];
        int volume = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i]);
            left[i] = Math.max(height[i], leftMax);
        }
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            right[i] = Math.max(height[i], rightMax);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(left[i], right[i]);
            if (min >= height[i]) {
                volume += min - height[i];
            }
        }
        return volume;
    }
}
