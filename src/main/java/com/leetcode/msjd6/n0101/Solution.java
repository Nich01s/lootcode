package com.leetcode.msjd6.n0101;

/**
 * @Author: Nic1
 * @Date: 2022/2/11 16:38
 * @Theme: 判定字符是否唯一（不使用额外的数据结构）
 */
//位运算（借助位运算，使用一个常数作为额外结构存储信息）
class Solution {
    public boolean isUnique(String astr) {
        int aa = 0;
        int cc = 1;
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            int offset = c - 'a';
            int bb = cc << offset;//位左移
            if ((aa & bb) != 0) {
                return false;
            }
            aa |= bb;
        }
        return true;
    }
}
