package com.leetcode.hot100.n11;

/**
 * @Author: Nic1
 * @Date: 2022/2/8 22:23
 * @Theme: 盛最多水的容器
 */
//双指（尽快排除不符合条件的下标组合）

/**
 * 在每个状态下，无论长板或短板向中间收窄1格，都会导致水槽底边宽度-1变短：
 * ①、若向内移动短板，水槽短板可能变长，因此下一个水槽的面积可能增大；
 * ②、若向内移动长板，水槽短板不变或变短，因此下一个水槽的面积一定变小；
 */
class Solution {
    public int maxArea(int[] height) {

        int i = 0;
        int j = height.length - 1;
        int maxArea = Math.min(height[i], height[j]) * (j - i);//计算一个初始面积
        while (i < j) {
            if (height[i] < height[j]) {
                maxArea = Math.max(maxArea, height[i] * (j - i));
                i++;
            } else {
                maxArea = Math.max(maxArea, height[j] * (j - i));
                j--;
            }
        }
        return maxArea;
    }
}
