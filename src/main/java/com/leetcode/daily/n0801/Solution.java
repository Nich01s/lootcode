package com.leetcode.daily.n0801;

/**
 * @Author: Nic1
 * @Date: 2022/8/1 9:21
 * @Theme: 生成每种字符都是奇数个的字符串
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = s.generateTheString(11);
        System.out.println(s1);
    }
    public String generateTheString(int n) {
        StringBuffer sb = new StringBuffer();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                sb.append("a");
            }
            sb.append("b");
        }else {
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
        }
        return sb.toString();
    }
}
