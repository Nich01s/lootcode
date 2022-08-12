package com.leetcode.msjd6.n0402;

/**
 * @Author: Nic1
 * @Date: 2022/8/2 20:50
 * @Theme: 最小高度树【递归思想】
 */

/**
 * 【递归思想】：父方法，可以直接使用子方法结果。注意递归需有退出条件
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = s.sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        //注意当left=right不是退出条件，因为当left=right时还需创建最后一个叶子节点
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = dfs(nums, left, mid - 1);
        midNode.right = dfs(nums, mid + 1, right);
        return midNode;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}