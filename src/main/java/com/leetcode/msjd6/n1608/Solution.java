package com.leetcode.msjd6.n1608;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Nic1
 * @Date: 2022/3/14 19:31
 * @Theme: 整数的英语表示（整数最大值为10位数）
 */
class Solution {
    public static void main(String[] args) {
        String s = new Solution().numberToWords(1001);
        System.out.println(s);
    }

    Map<String, String> map;

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuffer res = new StringBuffer("");
        String s = String.valueOf(num);
        int len = s.length();
        List<String> list = new ArrayList<>();//存放单位
        if (len > 3) {
            list.add("Thousand");
        }
        if (len > 6) {
            list.add("Million");
        }
        if (len > 9) {
            list.add("Billion");
        }
        map = new HashMap<>();
        map.put("1", "One");
        map.put("2", "Two");
        map.put("3", "Three");
        map.put("4", "Four");
        map.put("5", "Five");
        map.put("6", "Six");
        map.put("7", "Seven");
        map.put("8", "Eight");
        map.put("9", "Nine");

        map.put("10", "Ten");
        map.put("11", "Eleven");
        map.put("12", "Twelve");
        map.put("13", "Thirteen");
        map.put("14", "Fourteen");
        map.put("15", "Fifteen");
        map.put("16", "Sixteen");
        map.put("17", "Seventeen");
        map.put("18", "Eighteen");
        map.put("19", "Nineteen");

        map.put("20", "Twenty");
        map.put("30", "Thirty");
        map.put("40", "Forty");
        map.put("50", "Fifty");
        map.put("60", "Sixty");
        map.put("70", "Seventy");
        map.put("80", "Eighty");
        map.put("90", "Ninety");
        int modLen = len % 3;
        boolean flag = true;//记录最前面可能存在的空格
        if (modLen != 0) {
            String threeLetter = three_letter(s.substring(0, modLen), modLen);
            res.append(threeLetter);
            if (list.size() > 0) {
                res.append(" " + list.remove(list.size() - 1));
            }
        }
        int fre = len / 3;
        int k = 0;
        while (k < fre) {
            String threeLetter = three_letter(s.substring(modLen + k * 3, modLen + k * 3 + 3), 3);
            res.append(" ");
            res.append(threeLetter);
            if (k != fre - 1) {
                res.append(" " + list.remove(list.size() - 1));
            }
            k++;
        }

        return res.toString().trim();
    }

    //输入长度为3的字符串，返回其表示
    public String three_letter(String str, int len) {
        StringBuffer sb = new StringBuffer("");
        if (len == 3) {
            if (str.charAt(0) != '0') {//百位数字
                String s = map.get(str.substring(0, 1));
                sb.append(s);
                sb.append(" Hundred");
            }
            if (str.charAt(1) == '1') {//十位数字是1
                String s1 = map.get(str.substring(1, 3));
                sb.append(" " + s1);
            } else {//十位数字>1
                String s2 = map.get(str.substring(1, 2) + "0");//单取十位数字
                sb.append(" " + s2);
            }
            if (str.charAt(1) != '1' && str.charAt(2) != '0') {//个位数字
                String s3 = map.get(str.substring(2, 3));
                sb.append(" " + s3);
            }
        } else if (len == 2) {
            if (str.charAt(0) == '1') {//十位数字是1
                String s = map.get(str.substring(0, 2));
                sb.append(s);
            } else {//十位数字>1
                String s1 = map.get(str.substring(0, 1) + "0");//单取十位数字
                sb.append(s1);
                if (str.charAt(1) != '0') {//个位数字
                    String s2 = map.get(str.substring(1, 2));
                    sb.append(" " + s2);
                }
            }
        } else if (len == 1) {
            String s = map.get(str);
            sb.append(s);
        }
        return sb.toString();
    }
}
