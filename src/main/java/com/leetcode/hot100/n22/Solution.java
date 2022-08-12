package com.leetcode.hot100.n22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Nic1
 * @Date: 2022/2/9 19:51
 * @Theme: 括号生成
 */
//方法1：dfs
//方法2：动态规划

/**
 * 方法1：dfs。以下是dfs剪枝条件
 * ①、左括号剩余数量必须小于等于右边括号剩余数量
 * ②、左括号数量与右括号数量上限为传入的参数n
 */
class Solution1 {
    public static void main(String[] args) {
        List<String> list1 = generateParenthesis(3);
        System.out.println(list1);
        List<String> list2 = generateParenthesis(4);
        System.out.println(list2);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs(res, n, n, new StringBuffer());
        return res;
    }

    public static void dfs(List<String> res, int leftRemain, int rightRemain, StringBuffer cur) {
        if (leftRemain == 0 && rightRemain == 0) {
            res.add(cur.toString());
            return;
        }
        if (leftRemain > rightRemain) { //当左括号剩余数量>大于右括号剩余数量，剪枝
            return;
        }
        if (leftRemain > 0) { //左括号数量限制
            dfs(res, leftRemain - 1, rightRemain, cur.append("("));
            cur.deleteCharAt(cur.length() - 1);
        }
        if (rightRemain > 0) { //右括号数量限制
            dfs(res, leftRemain, rightRemain - 1, cur.append(")"));
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}


/**
 * 方法2：动态规划。
 *      核心思想:设当i<n时已有的括号组合中，最左边的左括号是新添加进来的第n组括号的左括号（因为所有左括号完全等效）
 *              设p+q=n-1，则n对所有的括号可能的组合为： "("+【i=p时所有括号的排列组合】+")"+【i=q时所有括号的排列组合】，其中p从0—>n-1,q从n-1—>0，且当[p1,q1]≠[p2,q2]时，括号组合一定不同（因为在新添加进来的右括号的右侧i=q的所有括号组合不同且q不断发生变化）
 *      状态转移方程：设dp[i]为i组括号的所有有效括号组合，则：
 *                  dp[i]="("+dp[p]的所有有效括号组合+")"+dp[q]的所有有效括号组合，其中p+q=i-1，且p:0—>i-1，q:i-1—>0
 *          边界条件：①当n=0时，dp[0]=""，②当n=1时，dp[1]="()"
 */
class Solution2 {
    public static void main(String[] args) {
        List<String> list1 = generateParenthesis(3);
        System.out.println(list1);
        List<String> list2 = generateParenthesis(4);
        System.out.println(list2);
        List<String> list3 = generateParenthesis(5);
        System.out.println(list3);
    }
    public static List<String> generateParenthesis(int n) {
        List<String>[] dp = new List[n + 1];//存放不同n的计算结果
        dp[0] = Arrays.asList("");//当n=0时
        for (int i = 1; i <= n; i++) {
            dp[i] = new ArrayList<>();//记录当前i所得结果
            for (int p = 0; p < i ; p++) {
                //所有dp[p]与dp[q]的结果，拼接"("和")"最终得到每个dp[i]
                for (String s : dp[p]) {
                    for (String t : dp[i - p - 1]) {
                        dp[i].add("("+s+")"+t);
                    }
                }
            }
        }
        return dp[n];
    }
}
