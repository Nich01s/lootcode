package com.leetcode.msjd6.n1710;

/**
 * @Author: Nic1
 * @Date: 2022/3/2 23:28
 * @Theme: 主要元素
 */
//方法：摩尔投票法
/**
 * 形象化理解：
 * 诸侯争霸游戏，假设你的人口占比超过总人口的一半，那么只要不内斗，每次和其他国家打仗都能一换一，最终赢家肯定是你。即使其他国家联合起来也打不过你，更不用说其他国家之间也会相互攻击。
 * 算法过程：
 * 遍历数组，从第一个元素开始计数，计数器初始为 1。
 * 遇到与当前元素相同的元素时，计数器加 1，否则减 1（比拼消耗）。
 * 若计数器为 0，则重新从当前元素开始计数，重复步骤 2 直至到达数组末尾。
 */
class Solution {
    public static void main(String[] args) {

        int i = new Solution().majorityElement(new int[]{1, 2,3});
        System.out.println(i);
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = -1;//
        for (int i = 0; i < nums.length; i++) {
            if (count > 0) {
                if (nums[i] != candidate) {
                    count--;
                    if (count == 0) {
                        candidate = -1;
                    }
                } else {
                    count++;
                }
            } else {
                candidate = nums[i];
                count++;
            }
        }
        //排除例如{1,2,3}，最后count=1的情况
        int n = 0;
        if (count > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == candidate) {
                    n++;
                }
            }
        }
        return n > nums.length / 2 ? candidate : -1;
    }
}
