package com.leetcode.msjd6.n0501;

/**
 * @Author: Nic1
 * @Date: 2022/8/8 15:22
 * @Theme: 插入
 */
public class Solution {
    public int insertBits(int N, int M, int i, int j) {

        String N_bin = Integer.toBinaryString(N);
        String M_bin = Integer.toBinaryString(M);
        // 将M_bin插入N_bin
        int start = N_bin.length() - 1 - i;
        int end = N_bin.length() - 1 - j;
        //如果长度不够，对前缀进行0填充
        if (M_bin.length() < end - start + 1) {

        }

        return -1;
    }
}
