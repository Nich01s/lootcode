package com.leetcode.test;

import java.util.ArrayList;

/**
 * @Author: Nic1
 * @Date: 2022/3/2 14:54
 * @Theme:
        */
public class HeapTest {
    byte[] a = new byte[1024*100]; //100KB
    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> heapTests = new ArrayList<>();
        while (true){
            heapTests.add(new HeapTest());
            Thread.sleep(30);
        }
    }
}
