package com.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Nic1
 * @Date: 2022/8/8 12:29
 * @Theme:
 */
public class Test06 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("1"));
        System.out.println(list.toString());
        func(list);
        System.out.println(list.toString());
    }

    public static void func(List<String> list) {
        list.add("2");
    }
}
