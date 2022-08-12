package com.leetcode.hot100.n17;


import java.util.*;

/**
 * @Author: Nic1
 * @Date: 2022/2/8 22:24
 * @Theme: 电话号码的字母组合
 */
//方法1：队列
//方法2：回溯

/**
 * 方法1：队列
 */
class Solution1 {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        Queue<String> queue = new LinkedList<String>();//队列
        Map<Integer, String> phoneMap = new HashMap<>();
        phoneMap.put(2, "abc");
        phoneMap.put(3, "def");
        phoneMap.put(4, "ghi");
        phoneMap.put(5, "jkl");
        phoneMap.put(6, "mno");
        phoneMap.put(7, "pqrs");
        phoneMap.put(8, "tuv");
        phoneMap.put(9, "wxyz");
        for (int i = 0; i < digits.length(); i++) {
            String str = phoneMap.get(digits.charAt(i) - '0');//获取当前下表数字对应的字符串
            queue_letterCombinations(queue, str);

        }
        combinations.addAll(queue);  //存放结果
        return combinations;
    }

    public void queue_letterCombinations(Queue<String> queue, String str) {
        if (queue.size() == 0) {

        } else {
            int size = queue.size();
        }
    }
}

/**
 * 方法2：回溯
 */
class Solution2 {
    public static void main(String[] args) {
        String digits = "2345";
        List<String> list = letterCombinations(digits);
        System.out.println(list);
    }
    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Integer, String> phoneMap = new HashMap<>();
        phoneMap.put(2, "abc");
        phoneMap.put(3, "def");
        phoneMap.put(4, "ghi");
        phoneMap.put(5, "jkl");
        phoneMap.put(6, "mno");
        phoneMap.put(7, "pqrs");
        phoneMap.put(8, "tuv");
        phoneMap.put(9, "wxyz");
        backtrack(combinations,phoneMap,digits,0,new StringBuffer());//回溯
        return combinations;
    }

    public static void backtrack(List<String> combinations, Map<Integer, String> phoneMap, String digits, int index, StringBuffer combination) {//index为当前所拨的第index个数字
        if (index==digits.length()){
            combinations.add(combination.toString());
        }else {
            Integer digit = digits.charAt(index)-'0';//当前所拨数字(层数)
            String letters = phoneMap.get(digit);//当前所拨数字对应的所有字符（当前节点所有分支）
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));//当前节点的某一个分支
                backtrack(combinations,phoneMap,digits,index+1,combination);//继续递归
                combination.deleteCharAt(index);//回溯
            }
        }
    }
}