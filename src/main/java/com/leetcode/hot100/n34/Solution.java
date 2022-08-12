package com.leetcode.hot100.n34;

/**
 * @Author: Nic1
 * @Date: 2022/2/10 23:21
 * @Theme: 在排序数组中查找元素的第一个和最后一个位置
 */
//二分查找
class Solution {
    public int[] searchRange(int[] nums, int target) {


        return null;
    }

    //二分查找下限坐标
    public int binSearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left + 1;
    }
    //二分查找上限坐标
}
