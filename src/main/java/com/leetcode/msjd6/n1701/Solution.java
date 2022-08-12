package com.leetcode.msjd6.n1701;

/**
 * @Author: Nic1
 * @Date: 2022/3/11 21:38
 * @Theme:
 */
class Solution {
    public int add(int a, int b) {

        int k = 1;//选择
        int carry = 1;
        while (k < 32) {
            int i = a & k;
            int j = b & k;
            if ((i ^ j) != 0) {

            }

            k <<= 1;
        }
        return 0;
    }
}
