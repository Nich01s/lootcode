package com.leetcode.msjd6.n0103;

/**
 * @Author: Nic1
 * @Date: 2022/2/11 19:41
 * @Theme: URL化
 */
class Solution {
    public static void main(String[] args) {
        String s = "ds sdfs afs sdfa dfssf asdf             ";
        int length = 27;
        String s1 = replaceSpaces(s, length);
        System.out.println(s1);
    }

    public static String replaceSpaces(String s, int length) {
        if (s == null) {
            return null;
        }
        int realLen = s.length();
        char[] res = new char[realLen];
        int p = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != ' ') {
                res[p] = s.charAt(i);
                p++;
            } else {
                res[p] = '%';
                p++;
                res[p] = '2';
                p++;
                res[p] = '0';
                p++;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]);
        }
        return sb.toString().trim();
    }
}
