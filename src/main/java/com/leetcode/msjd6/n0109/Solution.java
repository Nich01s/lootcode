package com.leetcode.msjd6.n0109;

/**
 * @Author: Nic1
 * @Date: 2022/2/11 21:24
 * @Theme: 字符串轮转
 */
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length()==s2.length()&&(s1+s1).contains(s2);
    }
}
