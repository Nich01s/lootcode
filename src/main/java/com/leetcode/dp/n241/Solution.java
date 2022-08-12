package com.leetcode.dp.n241;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Nic1
 * @Date: 2022/3/17 17:48
 * @Theme: 为运算表达式设计优先级
 */
//方法:dp
//状态转移方程:dp[i][j]为第i个数字到第j个数字返回的可能组合结果,遍历i~j中间的数字,作为区间分割 → 将i~j区间分割为:i~k,k+1~j,每个区间内的组合数相乘就是i~j区间的所有结果数
class Solution {
    public static void main(String[] args) {
        List<Integer> list = new Solution().diffWaysToCompute("2*3-4*5");
        System.out.println(list.toString());
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        char[] ch = expression.toCharArray();
        List<Integer> numList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < ch.length; i++) {
            if (isOperation(ch[i])) {
                numList.add(num);
                num = 0;
                opList.add(ch[i]);
                continue;
            }
            num = num * 10 + ch[i] - '0';
        }
        numList.add(num);
        List<Integer>[][] dp = new ArrayList[numList.size()][numList.size()]; //dp[i][j]就是下标i数字到下标j数字部分的所有可能组合结果
        //边界条件
        dp[0][0] = new ArrayList<>(Arrays.asList(numList.get(0)));
        for (int i = 1; i < numList.size(); i++) {
            dp[i][i] = new ArrayList<>(Arrays.asList(numList.get(i)));
        }
        //dp (注意的是:如果将dp[i][j]看作是一个上三角矩阵,dp[i][k]在dp[i][j]左侧,而dp[k+1][j]在dp[i][j]下方)
        for (int i = numList.size()-1; i >= 0; i--) {
            for (int j = i + 1; j < numList.size(); j++) {
                //遍历i~j中间的数字,作为区间分割 → 将i~j区间分割为:i~k,k+1~j,每个区间内的组合数相乘就是i~j区间的所有结果数
                List<Integer> list = new ArrayList<>();//记录当前区间结果
                for (int k = i; k < j; k++) {
                    List<Integer> temp1 = dp[i][k];
                    List<Integer> temp2 = dp[k + 1][j];
                    //获取计算符号
                    char c = opList.get(k);
                    //计算两个区级的组合结果
                    for (int m = 0; m < temp1.size(); m++) {
                        for (int n = 0; n < temp2.size(); n++) {
                            list.add(calculate(c, temp1.get(m), temp2.get(n)));
                        }
                    }
                }
                dp[i][j] = list;
            }
        }
        return dp[0][numList.size()-1];
    }

    private boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    //根据运算符号计算并返回结果
    public int calculate(char c, int a, int b) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return -1;
    }
}
