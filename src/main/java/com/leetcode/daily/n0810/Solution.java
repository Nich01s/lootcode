package com.leetcode.daily.n0810;

/**
 * @Author: Nic1
 * @Date: 2022/8/10 8:49
 * @Theme: 求解方程
 */

/**
 * 情况1：有无限解，等式化简后为x=x
 * 情况2：无解，等式化简后，kx+b=kx，且b≠0
 * 情况3：有解，排除前两种情况后
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String equation = "x=0";
        System.out.println(s.solveEquation(equation));
        //String q1 = equation.substring(0, equation.lastIndexOf('='));
        //System.out.println(q1);
        //q1 = "+" + q1;
        //System.out.println(q1);
        //String q2 = equation.substring(equation.lastIndexOf('=') + 1);
        //System.out.println(q2);

        //System.out.println(("a"+"").length());
    }

    public String solveEquation(String equation) {

        int x = 0, num = 0, n = equation.length();
        char[] cs = equation.toCharArray();
        for (int i = 0, op = 1; i < n; ) {
            if (cs[i] == '+') {
                op = 1;
                i++;
            } else if (cs[i] == '-') {
                op = -1;
                i++;
            } else if (cs[i] == '=') {
                x *= -1;
                num *= -1;
                op = 1;
                i++;
            } else {
                int j = i;
                while (j < n && cs[j] != '+' && cs[j] != '-' && cs[j] != '=') j++;
                if (cs[j - 1] == 'x') x += (i < j - 1 ? Integer.parseInt(equation.substring(i, j - 1)) : 1) * op;
                else num += Integer.parseInt(equation.substring(i, j)) * op;
                i = j;
            }
        }
        if (x == 0) return num == 0 ? "Infinite solutions" : "No solution";
        else return "x=" + (num / -x);
    }
}

