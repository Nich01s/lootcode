package com.leetcode.test;

import java.lang.ref.SoftReference;

/**
 * @Author: Nic1
 * @Date: 2022/3/3 9:28
 * @Theme:
 */
public class Test02 {
    public static void main(String[] args) throws InterruptedException {

        byte[] allocation1 = new byte[60000 * 1024];
        byte[] allocation2 = new byte[8000 * 1024];
        byte[] allocation3 = new byte[1000 * 1024];
        byte[] allocation4 = new byte[1000 * 1024];
        byte[] allocation5 = new byte[1000 * 1024];
        byte[] allocation6 = new byte[1000 * 1024];

        SoftReference<Test02> test02SoftReference = new SoftReference<>(new Test02());//软引用

    }
}
