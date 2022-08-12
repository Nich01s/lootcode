package com.leetcode.msjd6.n1618;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Nic1
 * @Date: 2022/3/12 19:38
 * @Theme: 模式匹配
 */
class Solution {
    public static void main(String[] args) {
        boolean b = new Solution().patternMatching("bbbbbbbbbbbbbbabbbbb", "ppppppppppppppjsftcleifftfthiehjiheyqkhjfkyfckbtwbelfcgihlrfkrwireflijkjyppppg");
        System.out.println(b);
    }

    public boolean patternMatching(String pattern, String value) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('b', 0);
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') {
                map.put('a', map.get('a') + 1);
            }
            if (pattern.charAt(i) == 'b') {
                map.put('b', map.get('b') + 1);
            }
        }
        int m = map.get('a');//统计a出现的个数
        int n = map.get('b');//统计b出现的个数
        if (m == 0) {
            if (value.length() % n == 0) {
                int a = value.length() / n;
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < n; i++) {
                    sb.append(value.substring(0, a));
                }
                if (value.equals(sb.toString())) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (n == 0) {
            if (value.length() % m == 0) {
                int a = value.length() / m;
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < m; i++) {
                    sb.append(value.substring(0, a));
                }
                if (value.equals(sb.toString())) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        int len = value.length();
        for (int i = 0; i < len; i++) { //枚举一个a匹配几个字符
            int k = len - m * i;//留b长度
            if (k < 0) {
                break;
            }
            if (k % n == 0) {
                //当前a匹配i个字符，b匹配k个字符
                int aStart = pattern.indexOf("a", -1);
                int bStart = pattern.indexOf("b", -1);
                String sA = aStart == -1 ? "" : value.substring(aStart * k / n, aStart * k / n + i);//a匹配字符串
                String sB = bStart == -1 ? "" : value.substring(bStart * i, bStart * i + k / n);//b匹配字符串
                if (sA.equals(sB)) {
                    return false;
                }
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < pattern.length(); j++) {
                    if (pattern.charAt(j) == 'a') {
                        sb.append(sA);
                    }
                    if (pattern.charAt(j) == 'b') {
                        sb.append(sB);
                    }
                }
                if (value.equals(sb.toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}
