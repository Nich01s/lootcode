package com.leetcode.dp.n87;

/**
 * @Author: Nic1
 * @Date: 2022/3/15 16:38
 * @Theme: 扰乱字符串
 */
//方法1：分治（只要是在同一侧的字母必须一直保持在同一侧）
//abcde—>a/bcde 或 ab/cde 或 abc/de 或 abcd/e
class Solution1 {
    public boolean isScramble(String s1, String s2) {


        return false;
    }

    public boolean isValid(String str) {


        return false;
    }
}

//方法2：dp
//状态转移方程：设dp[i][j][len]为s1中下标i字符起len个字符是否与s2中下标j字符起len个字符为一对扰乱字符
class Solution2 {
    public static void main(String[] args) {
        boolean scramble = new Solution2().isScramble("abcde", "caebd");
        System.out.println(scramble);
    }
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int n = s1.length();

        boolean[][][] dp = new boolean[n][n][n + 1];//n+1是要包含长度为0，但是为长度为0时不参与计算，使用n+1是为了方便

        //边界条件
        for (int i = 0; i < n; i++) { //枚举s1中起始下标
            for (int j = 0; j < n; j++) { //枚举s2中起始下标
                dp[i][j][1] = ch1[i] == ch2[j];
            }
        }
        //dp
        for (int len = 2; len <= n; len++) { //枚举长度，区间为2~n
            for (int i = 0; i <= n - len; i++) { //枚举s1中起始下标
                for (int j = 0; j <= n - len; j++) { //枚举s2中起始下标
                    for (int w = 1; w <= len - 1; w++) { //在长度区间内进行分割
                        /**
                         *     ////////////////////////////      ////////////////////////////      |      ////////////////////////////     ////////////////////////////
                         *     //    //                  //      //                //      //      |      //    //                  //     //                //      //
                         *     //    //                  //      //                //      //      |      //    //                  //     //                //      //
                         *     ////////////////////////////      ////////////////////////////      |      ////////////////////////////     ////////////////////////////
                         *       ↑            ↑                           ↑            ↑           |         ↑            ↑                          ↑            ↑
                         *       m1           m2                          n1           n2          |         m1           m2                         n1           n2
                         */
                        dp[i][j][len] = (dp[i][j][w] && dp[i + w][j + w][len - w]) || (dp[i][j + len - w][w] && dp[i + w][j][len - w]);
                        if (dp[i][j][len]) {
                            break;
                        }
                        //if (dp[i][j][w] && dp[i + w][j + w][len - w]){
                        //    dp[i][j][len] = true;
                        //    break;
                        //}
                        //if (dp[i][j + len - w][w] && dp[i + w][j][len - w]){
                        //    dp[i][j][len] = true;
                        //    break;
                        //}
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}


















