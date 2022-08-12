package com.leetcode.msjd6.n1001;

import java.util.Arrays;

/**
 * @Author: Nic1
 * @Date: 2022/3/6 22:35
 * @Theme:
 */
class Solution {
    public static void main(String[] args) {
        int[] A = {0};//1, 2, 3, 0, 0, 0
        int[] B = {1};
        int m = 0;
        int n = 1;
        new Solution().merge(A, m, B, n);
        System.out.println(Arrays.toString(A));
    }

    public void merge(int[] A, int m, int[] B, int n) {

        for (int i = 0; i < B.length; i++) {
            int a = m + i;
            A[a] = B[i];
            while (a > 0 && A[a] < A[a - 1]) {
                int temp = A[a];
                A[a] = A[a - 1];
                A[a - 1] = temp;
                a--;
            }
        }
    }
}
