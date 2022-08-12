package com.leetcode.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Nic1
 * @Date: 2022/3/4 21:21
 * @Theme:
 */
public class Test04 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer integer = map.get(null);
        System.out.println(integer);
    }
}
