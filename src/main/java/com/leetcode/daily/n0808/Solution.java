package com.leetcode.daily.n0808;

/**
 * @Author: Nic1
 * @Date: 2022/8/8 11:54
 * @Theme: 特殊二进制序列【有效括号】
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 题面翻译：
 * Ⅰ、0和1的数量相等 → “右括号” 数量和 “左括号” 相同
 * Ⅱ、二进制序列的每一个前缀码中1的数量要大于等于0的数量 → “右括号” 必须能够找到一个 “左括号” 匹配
 * Ⅲ、选择S的两个连续且非空的特殊的子串，然后将它们交换： → 选择S中的两个相邻的有效的括号字符串，然后交换即可
 */
public class Solution {
    public String makeLargestSpecial(String s) {
        return dfs(s, 0, s.length() - 1);
    }
    //递归
    public String dfs(String s, int l, int r) {
        //递归退出条件
        if (r < l) {
            return "";
        }
        List<String> list = new ArrayList<>();
        int cnt = 0;
        int pre = l;
        for (int i = l; i <= r; i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            } else {
                cnt--;
                //如果当前子串是一个特殊子串，继续递归处理该特殊子串的子串
                if (cnt == 0) {
                    list.add("1" + dfs(s, pre + 1, i - 1) + "0");
                    pre = i + 1;
                }
            }
        }
        //完成对当前特殊子串处理后，对其内部的所有子串按字典序排序
        list.sort((a, b) -> b.compareTo(a));
        //list转String类型输出
        return String.join("", list);
    }
}
