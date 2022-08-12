package com.leetcode.msjd6.n0102;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Nic1
 * @Date: 2022/2/11 16:58
 * @Theme: 判定是否互为字符重排
 */
class Solution {
    public static void main(String[] args) {
        String s1 = "abcdefg";
        String s2 = "gfedcba";
        boolean b = CheckPermutation(s1, s2);
        System.out.println(b);
    }

    public static boolean CheckPermutation(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 2);
        map.put('b', 3);
        map.put('c', 5);
        map.put('d', 7);
        map.put('e', 11);
        map.put('f', 13);
        map.put('g', 17);
        map.put('h', 19);
        map.put('i', 23);
        map.put('j', 29);
        map.put('k', 31);
        map.put('l', 37);
        map.put('m', 41);
        map.put('n', 43);
        map.put('o', 47);
        map.put('p', 53);
        map.put('q', 59);
        map.put('r', 61);
        map.put('s', 67);
        map.put('t', 71);
        map.put('u', 73);
        map.put('v', 79);
        map.put('w', 83);
        map.put('x', 89);
        map.put('y', 97);
        map.put('z', 101);
        int pro1 = 1;
        int pro2 = 1;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            int a = map.get(c);
            pro1 *= a;
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            int a = map.get(c);
            pro2 *= a;
        }
        return pro1==pro2;
    }
}
