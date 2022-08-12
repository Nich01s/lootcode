package com.leetcode.msjd6.n1708;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: Nic1
 * @Date: 2022/3/9 21:33
 * @Theme: 马戏团人塔
 */
//方法1：排序+最长递增子序列dp  （超时）
class Solution1 {
    public static void main(String[] args) {
        int i = new Solution1().bestSeqAtIndex(new int[]{65, 66, 67, 68, 69}, new int[]{73, 70, 70, 72, 75});
        System.out.println(i);
    }

    public int bestSeqAtIndex(int[] height, int[] weight) {
        if (weight.length < 1) {
            return 0;
        }
        int[][] person = new int[height.length][2];
        for (int i = 0; i < height.length; i++) {
            person[i] = new int[]{height[i], weight[i]};
        }
        //先按身高升序排，身高相同按体重降序排
        Arrays.sort(person, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        //在体重排列中找最递增子序列
        int[] newWeight = new int[weight.length];
        for (int i = 0; i < person.length; i++) {
            newWeight[i] = person[i][1];
        }
        return longIncreSubseq(newWeight);
    }

    //寻找最长递增地序列，时间复杂度为O(n^2)
    //设dp[i]为以下标i结尾的最长递增子序列长度
    public int longIncreSubseq(int[] newWeight) {
        int[] dp = new int[newWeight.length];
        dp[0] = 1;
        int maxRes = 1;
        for (int i = 1; i < newWeight.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (newWeight[j] < newWeight[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxRes = Math.max(dp[i], maxRes);
        }
        return maxRes;
    }
}

//方法2：
class Solution2 {
    public int bestSeqAtIndex(int[] height, int[] weight) {


        return 0;
    }
}
