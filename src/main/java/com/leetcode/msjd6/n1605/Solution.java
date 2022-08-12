package com.leetcode.msjd6.n1605;

/**
 * @Author: Nic1
 * @Date: 2022/3/14 22:22
 * @Theme: 阶乘尾数
 */
//方法：发现规律：5的倍数出现了多少次（注意如25中包含了两个5），阶乘尾数中就会有多少个零
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        for (long i = 5; n / i > 0; i *= 5) {//记录有多少个5的倍数，有多少个25的倍数，有多少个125的倍数
            res += n / i;
        }
        return res;
    }
}
