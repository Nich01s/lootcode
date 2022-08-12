package com.leetcode.hot100.n5;

/**
 * @Author: Nic1
 * @Date: 2022/1/2 22:14
 * @Theme: 最长回文子串
 */
//方法1：动态规划
//方法2：中心扩散
//方法3：马拉车

/**
 * 方法1：动态规划
 * 状态转移方程：假设dp[i][j]为下标i到下标j的字符串是否为回文字串，则dp[i][j]=dp[i+1][j-1]&&(s[i]==s[j])
 * 边界条件：当i=j时，d[i][j]=true
 * 当j=i+1时，d[i][j]==(s[i]==s[j])
 */
class Solution1 {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int maxLength = 1;
        int begin = 0;

        //构造边界条件
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();

        //枚举右边界
        for (int j = 1; j < length; j++) {
            //枚举左边界
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLength) {
                    begin = i;
                    maxLength = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }
}

/**
 * 方法2：中心扩散
 */
class Solution2 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            //1.当前位置进行奇数扩散
            String oddStr = curLongestPalindrome(i, i, s);
            //2.当前位置进行偶数扩散
            String evenStr = curLongestPalindrome(i, i + 1, s);
            String palindromeStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (palindromeStr.length() > longestPalindrome.length()) {
                longestPalindrome = palindromeStr;
            }
        }
        return longestPalindrome;
    }

    public String curLongestPalindrome(int i, int j, String s) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return s.substring(i + 1, j);
    }
}

/**
 * 方法3：马拉车
 */
class Solution3 {
    public String longestPalindrome(String s) {


        return null;
    }
}