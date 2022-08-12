package com.leetcode.msjd6.n1721;

/**
 * @Author: Nic1
 * @Date: 2022/2/20 21:26
 * @Theme: 直方图的水量（接雨水）
 */
//方法1：单调栈
//方法2：先求出每个下标的左右最大柱子高度

import java.util.Stack;

/**
 * 方法1：单调栈
 */
class Solution1 {
    public static void main(String[] args) {
        int trap = new Solution1().trap(new int[]{5, 2, 1, 2, 1, 5});
        System.out.println(trap);
    }

    public static int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();//构建一个单调递减栈，存储的是直方图各元素的下标
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int pop = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                sum += (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - height[pop]);
            }
            stack.push(i);
        }
        return sum;
    }
}

/**
 * 方法2：先求出每个下表的左右最大柱子高度
 */
class Solution2 {
    public static void main(String[] args) {
        int trap = new Solution2().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }

    public int trap(int[] height) {
        int sum = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        for (int i = 0; i < height.length; i++) {
            int a = Math.min(leftMax[i], rightMax[i]);
            sum += a > height[i] ? (a - height[i]) : 0;
        }
        return sum;
    }
}
