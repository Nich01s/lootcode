package com.leetcode.hot100.n33;

/**
 * @Author: Nic1
 * @Date: 2022/2/9 21:24
 * @Theme: 索旋转排序数组
 */
//二分查找
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return searchMy(nums, target, left, right);
    }

    public int searchMy(int[] nums, int target, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {//左边长模型
                if (target < nums[mid] && target >= nums[left]) {
                    return binSearch(nums,target, left, mid - 1);
                } else {
                    return searchMy(nums, target,mid + 1, right);
                }
            } else {//右边长模型
                if (target > nums[mid] && target <= nums[right]) {
                    return binSearch(nums, target, mid + 1, right);
                } else {
                    return searchMy(nums, target, left, mid - 1);
                }
            }
        }
        return -1;
    }

    //二分查找
    public int binSearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
