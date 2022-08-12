package com.leetcode.hot100.n32;

/**
 * @Author: Nic1
 * @Date: 2022/2/9 21:24
 * @Theme: 最长有效括号
 */
//方法1：栈
//方法2：动态规划

import java.util.Stack;

/**
 * 方法1：栈。
 */
class Solution1 {
    public static void main(String[] args) {
        int i = longestValidParentheses(")()())()((()))(");
        System.out.println(i);
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int maxLen = 0;
        int tempLen = 0;
        for (int i = 0; i < chars.length; i++) {
            //...
        }
        return maxLen;
    }
}

/**
 * 方法2：动态规划。
 * 状态转移方程：设dp[i]为以下标i结束的最长有效括号字串长度
 * ①、当s[i]='('时，dp[i]=0
 * ②、当s[i]=')'时，若s[i-1]='('，则dp[i]=dp[i-1]+2，若s[i-1]=')'，则dp[i]=2+dp[i-1]+dp[i-dp[i-1]-2]
 * 边界条件：
 */
class Solution2 {
    public static void main(String[] args) {
        int i = longestValidParentheses("()(())");
        System.out.println(i);
    }

    public static int longestValidParentheses(String s) {

        int[] dp = new int[s.length()];
        char[] chars = s.toCharArray();
        int maxLen = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;//注意边界条件
                } else {
                    if ((i - dp[i - 1] - 1) >= 0 && chars[i - dp[i - 1] - 1] == '(') {
                        dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
}
