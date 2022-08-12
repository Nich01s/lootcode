package com.leetcode.daily.n0811;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Nic1
 * @Date: 2022/8/11 7:25
 * @Theme: 重新格式化字符串【推荐使用双指针】
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reformat("ab123"));
    }

    public String reformat(String s) {
        //分割字符和数字
        char[] chars = s.toCharArray();
        List<Character> nums = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= '9' && chars[i] >= '0') {
                nums.add(chars[i]);
            } else {
                letters.add(chars[i]);
            }
        }
        int ln = nums.size();
        int ll = letters.size();
        if (Math.abs(ln - ll) > 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(ln, ll); i++) {
            if (ln >= ll) {
                sb.append(nums.get(i));
                sb.append(letters.get(i));
            } else {
                sb.append(letters.get(i));
                sb.append(nums.get(i));
            }
        }
        return ln > ll ? sb.append(nums.get(nums.size() - 1)).toString() : (ln == ll ? sb.toString() : sb.append(letters.get(letters.size() - 1)).toString());
    }
}
