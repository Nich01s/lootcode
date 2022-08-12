package com.leetcode.msjd6.n0106;

/**
 * @Author: Nic1
 * @Date: 2022/2/11 20:58
 * @Theme: 字符串压缩
 */
//双指针
class Solution {
    public static void main(String[] args) {
        String s = compressString("abcdefg");
        System.out.println(s);
    }

    public static String compressString(String s) {
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            int count = 0;
            while (right < s.length() && chars[left] == chars[right]) {
                count++;
                right++;
            }
            sb.append(chars[left]).append(count);
            left = right;
        }

        return sb.toString().length()>=s.length()?s:sb.toString();
    }
}
