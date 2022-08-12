package com.leetcode.dp.n354;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Nic1
 * @Date: 2022/3/18 22:06
 * @Theme: 俄罗斯套娃信封问题
 */
//方法:dp
//状态转移方程:先将宽度从小到大排序,宽度相等时将高度从大到小排序(为什么这样排序,参看特例:[2,3],[5,4],[6,5],[6,7])
class Solution {
    public static void main(String[] args) {
        int[][] envelopes = new int[][]{{46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}};
        int i = new Solution().maxEnvelopes(envelopes);
        System.out.println(i);
    }

    public int maxEnvelopes(int[][] envelopes) {
        //先对envelopes数组进行排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        //求高度数组中的最长升序子数组
        int[] dp = new int[envelopes.length];
        //边界条件
        dp[0] = 1;
        //dp
        int res = 1;
        for (int i = 1; i < envelopes.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            res = Math.max(res, max);
        }
        return res;
    }
}
