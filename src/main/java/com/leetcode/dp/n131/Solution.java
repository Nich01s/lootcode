package com.leetcode.dp.n131;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Nic1
 * @Date: 2022/3/16 23:46
 * @Theme: 分割回文串
 */
//方法:dfs+dp
//思路:每个间隙要么被分割，要么不被分割，所以整个字符串一共有2^(n-1)种分割方案，对于每个分割下来的子字符串，使用dp方法验证其是否为回文串
//状态转移方程:
class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        //dfs:分割间隙
        int cnt = len - 1;//间隙个数
        dfs(new ArrayList<>(), new ArrayList<>(), 0, cnt, s);

        return res;
    }

    //dfs分割间隙
    public void dfs(List<List<String>> list, List<Integer> path, int i, int cnt, String s) {
        if (i == cnt) {
            //根据路径完成分割并加入结果集
            List<String> temp = new ArrayList<>();
            int last = 0;
            for (int k = 0; k < path.size(); k++) {
                int m = path.get(k);
                String str = s.substring(last, m);
                last = m;
                temp.add(str);
            }
            list.add(new ArrayList<>(temp));
        }
        i++;
        //第i个间隙进行了分割 或 第i个间隙不分割
        for (int k = 0; k < 2; k++) {
            if (k == 0) { //k==0进行分割
                path.add(i);
                path.remove(path.size() - 1);//移除路径最后一次选择的分割间隙
            }
            //k==1不进行分割
        }
    }

    //dp检测当前字符串是否为回文串
    public boolean isValid(String s) {
        int len = s.length();
        char[] ch = s.toCharArray();
        boolean[][] dp = new boolean[len + 1][len + 1];
        //边界条件
        dp[0][0] = true;
        for (int i = 1; i <= len; i++) {
            dp[i][i] = true;
        }
        //dp
        for (int i = 1; i <= len; i++) {
            for (int j = i; j <= len; j++) {
                if (j == i + 1) {
                    dp[i][j] = ch[i - 1] == ch[j - 1];
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && (ch[i - 1] == ch[j - 1]);
                }
            }
        }
        return dp[1][len];
    }
}
