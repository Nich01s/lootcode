package com.leetcode.dp.n91;

/**
 * @Author: Nic1
 * @Date: 2022/3/16 12:49
 * @Theme: 解码方法
 */

//方法：dp
//状态转移方程：设dp[i]为前i个字符的子字符串的解码方法总数
//边界条件：dp[0] = 1（空字符串返回1种解法），dp[1] = 1 （单字符返回1中解法）
class Solution {
    public static void main(String[] args) {
        int i = new Solution().numDecodings("0");
        System.out.println(i);
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') { //迅速返回
            return 0;
        }
        char[] ch = s.toCharArray();
        int[] dp = new int[s.length() + 1]; //dp[0]为空字符串时解法数
        //边界条件
        dp[0] = 1; //空字符串只有一种解法
        dp[1] = 1; //单字符串只有一种解法
        //dp
        for (int i = 2; i <= ch.length; i++) {
            if (ch[i - 1] == '0') {
                if (ch[i - 2] != '1' && ch[i - 2] != '2') {
                    return 0;
                } else {
                    dp[i] = dp[i - 2];
                }
            } else {
                if (ch[i - 2] != '1' && ch[i - 2] != '2') { //ch[i-1]=0或3~9，且ch[i]!=0
                    dp[i] = dp[i - 1];
                } else { //ch[i-1]=1或2，且ch[i]!=0
                    if (ch[i - 2] == '1') {
                        dp[i] = dp[i - 1] + dp[i - 2];
                    } else { //ch[i-1]=2 且ch[i]!=0
                        if (ch[i - 1] != '7' && ch[i - 1] != '8' && ch[i - 1] != '9') { //ch[i-1]=2 且ch[i]=1/2/3/4/5/6
                            dp[i] = dp[i - 1] + dp[i - 2];
                        } else { //ch[i-1]=2 且ch[i]=7/8/9
                            dp[i] = dp[i - 1];
                        }
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
